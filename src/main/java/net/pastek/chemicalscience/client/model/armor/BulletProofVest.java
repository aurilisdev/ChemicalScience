package net.pastek.chemicalscience.client.model.armor;

import org.jetbrains.annotations.NotNull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.item.gear.armor.types.ItemBulletProofVest;
import voltaic.client.model.armor.GenericArmorModel;

public class BulletProofVest<T extends LivingEntity> extends GenericArmorModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"bulletproofvest"), "main");

    public BulletProofVest(ModelPart root, EquipmentSlot slot) {
        super(root);
        this.parentHat.visible = false;
        this.parentHead.visible = false;
        this.parentChest.visible = true;
        this.parentRightArm.visible = true;
        this.parentLeftArm.visible = true;
        this.parentRightLeg.visible = false;
        this.parentLeftLeg.visible = false;
    }

    public static LayerDefinition createBodyLayer(int modelType, boolean noChestplate) {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition part = mesh.getRoot();
        part.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        part.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 5.0F, -3.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 7).addBox(-4.0F, 5.0F, 2.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 16).addBox(3.5F, 5.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(10, 16).addBox(-4.5F, 5.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(18, 5).addBox(-3.0F, 2.0F, -3.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(18, 0).addBox(-3.0F, 1.0F, 2.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(22, 13).addBox(-3.75F, 1.0F, -2.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(1, 14).addBox(-4.0F, 0.0F, 1.75F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(18, 9).addBox(-3.0F, 11.0F, 1.75F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(18, 11).addBox(-3.0F, 11.0F, -2.75F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(9, 26).addBox(-4.0F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(14, 26).addBox(3.0F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(20, 16).addBox(3.25F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(20, 21).addBox(-4.25F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 26).addBox(0.75F, 1.0F, -2.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));


        part.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        part.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int light) {
        if (this.parentHead.visible) {
            this.parentHead.render(poseStack, this.getCustomConsumer(RenderType.entityTranslucent(ItemBulletProofVest.ARMOR_TEXTURE_LOCATION)), packedLight, packedOverlay);
        }

        if (this.parentChest.visible) {
            this.parentChest.render(poseStack, buffer, packedLight, packedOverlay);
            this.parentRightArm.render(poseStack, buffer, packedLight, packedOverlay);
            this.parentLeftArm.render(poseStack, buffer, packedLight, packedOverlay);
        }

        if (this.parentRightLeg.visible) {
            this.parentRightLeg.render(poseStack, buffer, packedLight, packedOverlay);
            this.parentLeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
        }

    }
}
