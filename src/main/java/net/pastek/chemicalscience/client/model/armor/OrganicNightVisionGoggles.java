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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.pastek.chemicalscience.ChemicalScience;
import voltaic.client.model.armor.GenericArmorModel;

public class OrganicNightVisionGoggles<T extends LivingEntity> extends GenericArmorModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"organic_night_vision_goggles"), "main");

    public OrganicNightVisionGoggles(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition part = meshdefinition.getRoot();

        part.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

        part.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(16, 2).addBox(-3.0F, -5.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 8).addBox(-1.0F, -5.0F, -4.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(10, 16).addBox(-4.25F, -5.0F, -4.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 0).addBox(-4.5F, -5.0F, -3.25F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 8).addBox(3.5F, -5.0F, -3.25F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 11).addBox(2.25F, -5.0F, -4.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 16).addBox(0.25F, -5.0F, 3.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 0).addBox(-4.25F, -5.0F, 3.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(16, 14).addBox(-1.25F, -5.0F, 3.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 18).addBox(1.0F, -5.0F, -7.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.ZERO);

        part.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        part.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
        part.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
        part.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
        part.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, color);
    }
}