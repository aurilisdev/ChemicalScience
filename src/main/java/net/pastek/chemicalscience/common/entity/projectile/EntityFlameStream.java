package net.pastek.chemicalscience.common.entity.projectile;

import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.pastek.chemicalscience.common.reloadlistener.FlamethrowerFuelManager;
import net.pastek.chemicalscience.registers.CSEntities;
import net.pastek.chemicalscience.registers.CSParticles;

public class EntityFlameStream extends Projectile implements ItemSupplier {

    private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(EntityFlameStream.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(EntityFlameStream.class, EntityDataSerializers.FLOAT);

    public EntityFlameStream(EntityType<? extends Projectile> type, Level level) {
        super(type, level);
        this.noCulling = true;
    }

    public EntityFlameStream(Level level, LivingEntity shooter, FlamethrowerFuelManager.FuelInfo info) {
        this(CSEntities.ENTITY_FLAMESTREAM.get(), level);
        this.setOwner(shooter);
        this.setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());

        this.entityData.set(COLOR, info.color());
        this.entityData.set(DAMAGE, info.damage());

        Vec3 view = shooter.getViewVector(1.0F);
        this.shoot(view.x, view.y, view.z, 1.5F, 1.0F);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(COLOR, 0xFF4400);
        builder.define(DAMAGE, 4.0f);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.tickCount > 10) {
            this.discard();
            return;
        }

        Vec3 movement = this.getDeltaMovement();
        Vec3 pos = this.position();
        Vec3 nextPos = pos.add(movement);

        HitResult hitresult = this.level().clip(new net.minecraft.world.level.ClipContext(
                pos, nextPos, net.minecraft.world.level.ClipContext.Block.COLLIDER, net.minecraft.world.level.ClipContext.Fluid.NONE, this));

        if (hitresult.getType() != HitResult.Type.MISS) {
            nextPos = hitresult.getLocation();
        }

        EntityHitResult entityHit = net.minecraft.world.entity.projectile.ProjectileUtil.getEntityHitResult(
                this.level(),
                this,
                pos,
                nextPos,
                this.getBoundingBox().expandTowards(movement).inflate(1.0D),
                this::canHitEntity
        );

        if (entityHit != null) {
            hitresult = entityHit;
        }

        if (hitresult.getType() != HitResult.Type.MISS) {
            this.onHit(hitresult);
        }

        this.setPos(this.getX() + movement.x, this.getY() + movement.y, this.getZ() + movement.z);

        if (this.level().isClientSide) {
            spawnParticles();
        }
    }

    private DustParticleOptions createFlameOptions(float r, float g, float b, float scale, float jitterAmount) {
        float jitter = (this.random.nextFloat() * jitterAmount * 2) - jitterAmount;

        Vector3f color = new Vector3f(
                Math.clamp(r + jitter, 0.0f, 1.0f),
                Math.clamp(g + jitter, 0.0f, 1.0f),
                Math.clamp(b + jitter, 0.0f, 1.0f)
        );

        return new DustParticleOptions(color, scale) {
            @Override
            public @NotNull ParticleType<DustParticleOptions> getType() {
                return CSParticles.COLORED_FLAME.get();
            }
        };
    }

    private void spawnParticles() {
        int colorInt = this.entityData.get(COLOR);
        float r = ((colorInt >> 16) & 0xFF) / 255.0f;
        float g = ((colorInt >> 8) & 0xFF) / 255.0f;
        float b = (colorInt & 0xFF) / 255.0f;

        Vec3 entityMotion = this.getDeltaMovement();

        for (int i = 0; i < 4; i++) {
            DustParticleOptions options = createFlameOptions(r, g, b, 1.4F, 0.04F);

            this.level().addParticle(
                    options,
                    this.getX() + (this.random.nextDouble() - 0.5) * 0.05,
                    this.getY() + (this.random.nextDouble() - 0.5) * 0.05,
                    this.getZ() + (this.random.nextDouble() - 0.5) * 0.05,
                    entityMotion.x,
                    entityMotion.y,
                    entityMotion.z
            );
        }
    }

    private void spawnImpactParticles(Vec3 hitLocation) {
        int colorInt = this.entityData.get(COLOR);
        float r = ((colorInt >> 16) & 0xFF) / 255.0f;
        float g = ((colorInt >> 8) & 0xFF) / 255.0f;
        float b = (colorInt & 0xFF) / 255.0f;

        for (int i = 0; i < 10; i++) {
            DustParticleOptions options = createFlameOptions(r, g, b, 1.0F, 0.06F);

            double dx = (this.random.nextDouble() - 0.5) * 0.2;
            double dy = this.random.nextDouble() * 0.2;
            double dz = (this.random.nextDouble() - 0.5) * 0.2;

            this.level().addParticle(
                    options,
                    hitLocation.x, hitLocation.y, hitLocation.z,
                    dx, dy, dz
            );
        }
    }

    @Override
    public @NotNull ItemStack getItem() {
        return new ItemStack(Items.FIRE_CHARGE);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity target = result.getEntity();
        Entity owner = this.getOwner();

        if (target == owner) return;

        target.setRemainingFireTicks(100);

        float damageValue = this.entityData.get(DAMAGE);

        if (owner instanceof LivingEntity livingOwner) {
            target.hurt(this.damageSources().mobProjectile(this, livingOwner), damageValue);
        } else {
            target.hurt(this.damageSources().thrown(this, owner), damageValue);
        }
    }

    @Override
    protected void onHit(@NotNull HitResult result) {
        super.onHit(result);

        if (!this.level().isClientSide) {
            if (result instanceof net.minecraft.world.phys.BlockHitResult blockHit) {
                net.minecraft.core.BlockPos hitPos = blockHit.getBlockPos();
                net.minecraft.core.Direction face = blockHit.getDirection();
                net.minecraft.core.BlockPos firePos = hitPos.relative(face);

                if (this.level().isEmptyBlock(firePos)) {
                    this.level().setBlockAndUpdate(firePos, BaseFireBlock.getState(this.level(), firePos));
                }
            }
        } else {
            spawnImpactParticles(result.getLocation());
        }

        if (result.getType() == HitResult.Type.BLOCK) {
            this.discard();
        }
    }
}