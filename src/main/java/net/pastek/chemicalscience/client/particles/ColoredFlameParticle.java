package net.pastek.chemicalscience.client.particles;

import javax.annotation.Nullable;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.DustParticleOptions;

public class ColoredFlameParticle extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected ColoredFlameParticle(ClientLevel level, double x, double y, double z, double dx, double dy, double dz, DustParticleOptions options, SpriteSet sprites) {
        super(level, x, y, z, dx, dy, dz);
        this.sprites = sprites;
        this.friction = 0.9F;

        this.rCol = options.getColor().x();
        this.gCol = options.getColor().y();
        this.bCol = options.getColor().z();

        this.quadSize *= options.getScale();
        this.lifetime = 12 + this.random.nextInt(6);
        this.setSpriteFromAge(sprites);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public int getLightColor(float partialTick) {
        return 15728880;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.age++ >= this.lifetime) {
            this.remove();
            return;
        }

        this.setSpriteFromAge(this.sprites);

        this.move(this.xd, this.yd, this.zd);

        this.xd *= 0.98D;
        this.yd *= 0.98D;
        this.zd *= 0.98D;

        this.yd += 0.005D;

        this.quadSize *= 0.94F;

        this.alpha = 1.0F - ((float)this.age / (float)this.lifetime);
    }

    public static class Provider implements ParticleProvider<DustParticleOptions> {
        private final SpriteSet sprites;
        public Provider(SpriteSet sprites) { this.sprites = sprites; }

        @Override
        public @Nullable Particle createParticle(DustParticleOptions type, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
            return new ColoredFlameParticle(level, x, y, z, dx, dy, dz, type, this.sprites);
        }
    }
}