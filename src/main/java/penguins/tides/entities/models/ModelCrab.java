package penguins.tides.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCrab extends ModelBase {
    //fields
    private ModelRenderer Base;
    private ModelRenderer BaseTop;
    private ModelRenderer ClawLeft1;
    private ModelRenderer ClawLeft2;
    private ModelRenderer ClawLeft3;
    private ModelRenderer ClawRight1;
    private ModelRenderer ClawRight2;
    private ModelRenderer ClawRight3;
    private ModelRenderer LegLeft2;
    private ModelRenderer LegLeft1;
    private ModelRenderer LegLeft3;
    private ModelRenderer LegRight2;
    private ModelRenderer LegRight1;
    private ModelRenderer LegRight3;
    private ModelRenderer EyeLeft;
    private ModelRenderer EyeRight;

    public ModelCrab() {
        textureWidth = 32;
        textureHeight = 32;

        Base = new ModelRenderer(this, 0, 24);
        Base.addBox(-4F, 1F, -3F, 8, 2, 6);
        Base.setRotationPoint(0F, 18F, 0F);
        Base.setTextureSize(32, 32);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        BaseTop = new ModelRenderer(this, 0, 17);
        BaseTop.addBox(-3.5F, 0F, -2.5F, 7, 1, 5);
        BaseTop.setRotationPoint(0F, 18F, 0F);
        BaseTop.setTextureSize(32, 32);
        BaseTop.mirror = true;
        setRotation(BaseTop, 0F, 0F, 0F);
        ClawLeft1 = new ModelRenderer(this, 24, 18);
        ClawLeft1.addBox(0F, 0F, 0F, 3, 2, 1);
        ClawLeft1.setRotationPoint(3.5F, 20F, 3F);
        ClawLeft1.setTextureSize(32, 32);
        ClawLeft1.mirror = true;
        setRotation(ClawLeft1, 0F, -0.7853982F, 0F);
        ClawLeft2 = new ModelRenderer(this, 28, 22);
        ClawLeft2.addBox(3F, 1F, 0F, 1, 1, 1);
        ClawLeft2.setRotationPoint(3.5F, 20F, 3F);
        ClawLeft2.setTextureSize(32, 32);
        ClawLeft2.mirror = true;
        setRotation(ClawLeft2, 0F, -0.7853982F, 0F);
        ClawLeft3 = new ModelRenderer(this, 28, 22);
        ClawLeft3.addBox(2F, 1F, 1F, 1, 1, 1);
        ClawLeft3.setRotationPoint(3.5F, 20F, 3F);
        ClawLeft3.setTextureSize(32, 32);
        ClawLeft3.mirror = true;
        setRotation(ClawLeft3, 0F, -0.7853982F, 0F);
        ClawRight1 = new ModelRenderer(this, 24, 18);
        ClawRight1.addBox(-3F, 0F, 0F, 3, 2, 1);
        ClawRight1.setRotationPoint(-3.5F, 20F, 3F);
        ClawRight1.setTextureSize(32, 32);
        ClawRight1.mirror = true;
        setRotation(ClawRight1, 0F, 0.7853982F, 0F);
        ClawRight2 = new ModelRenderer(this, 28, 22);
        ClawRight2.addBox(-3F, 1F, 1F, 1, 1, 1);
        ClawRight2.setRotationPoint(-3.5F, 20F, 3F);
        ClawRight2.setTextureSize(32, 32);
        ClawRight2.mirror = true;
        setRotation(ClawRight2, 0F, 0.7853982F, 0F);
        ClawRight3 = new ModelRenderer(this, 28, 22);
        ClawRight3.addBox(-4F, 1F, 0F, 1, 1, 1);
        ClawRight3.setRotationPoint(-3.5F, 20F, 3F);
        ClawRight3.setTextureSize(32, 32);
        ClawRight3.mirror = true;
        setRotation(ClawRight3, 0F, 0.7853982F, 0F);
        LegLeft2 = new ModelRenderer(this, 0, 14);
        LegLeft2.addBox(0F, 0.5F, -0.5F, 4, 1, 1);
        LegLeft2.setRotationPoint(4F, 20F, 0F);
        LegLeft2.setTextureSize(32, 32);
        LegLeft2.mirror = true;
        setRotation(LegLeft2, 0F, 0F, 0.7853982F);
        LegLeft1 = new ModelRenderer(this, 0, 14);
        LegLeft1.addBox(0F, 0.5F, -0.5F, 4, 1, 1);
        LegLeft1.setRotationPoint(4F, 20F, -1.5F);
        LegLeft1.setTextureSize(32, 32);
        LegLeft1.mirror = true;
        setRotation(LegLeft1, 0F, 0.3490659F, 0.7853982F);
        LegLeft3 = new ModelRenderer(this, 0, 14);
        LegLeft3.addBox(0F, 0.5F, -0.5F, 4, 1, 1);
        LegLeft3.setRotationPoint(4F, 20F, 1.5F);
        LegLeft3.setTextureSize(32, 32);
        LegLeft3.mirror = true;
        setRotation(LegLeft3, 0F, -0.3490659F, 0.7853982F);
        LegRight2 = new ModelRenderer(this, 0, 14);
        LegRight2.addBox(0F, -1.5F, -0.5F, 4, 1, 1);
        LegRight2.setRotationPoint(-4F, 20F, 0F);
        LegRight2.setTextureSize(32, 32);
        LegRight2.mirror = true;
        setRotation(LegRight2, 0F, 0F, 2.356194F);
        LegRight1 = new ModelRenderer(this, 0, 14);
        LegRight1.addBox(0F, -1.5F, -0.5F, 4, 1, 1);
        LegRight1.setRotationPoint(-4F, 20F, -1.5F);
        LegRight1.setTextureSize(32, 32);
        LegRight1.mirror = true;
        setRotation(LegRight1, 0F, -0.3490659F, 2.356194F);
        LegRight3 = new ModelRenderer(this, 0, 14);
        LegRight3.addBox(0F, -1.5F, -0.5F, 4, 1, 1);
        LegRight3.setRotationPoint(-4F, 20F, 1.5F);
        LegRight3.setTextureSize(32, 32);
        LegRight3.mirror = true;
        setRotation(LegRight3, 0F, 0.3490659F, 2.356194F);
        EyeLeft = new ModelRenderer(this, 0, 10);
        EyeLeft.addBox(1F, -1F, 2F, 1, 2, 1);
        EyeLeft.setRotationPoint(0F, 18F, 0F);
        EyeLeft.setTextureSize(32, 32);
        EyeLeft.mirror = true;
        setRotation(EyeLeft, 0F, 0F, 0F);
        EyeRight = new ModelRenderer(this, 0, 10);
        EyeRight.addBox(-2F, -1F, 2F, 1, 2, 1);
        EyeRight.setRotationPoint(0F, 18F, 0F);
        EyeRight.setTextureSize(32, 32);
        EyeRight.mirror = true;
        setRotation(EyeRight, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(180F, 0F, 1F, 0F);
        Base.render(scale);
        BaseTop.render(scale);
        ClawLeft1.render(scale);
        ClawLeft2.render(scale);
        ClawLeft3.render(scale);
        ClawRight1.render(scale);
        ClawRight2.render(scale);
        ClawRight3.render(scale);
        LegLeft2.render(scale);
        LegLeft1.render(scale);
        LegLeft3.render(scale);
        LegRight2.render(scale);
        LegRight1.render(scale);
        LegRight3.render(scale);
        EyeLeft.render(scale);
        EyeRight.render(scale);
        GlStateManager.popMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.LegLeft1.rotateAngleZ = 0.7853982F + MathHelper.cos(limbSwing * 0.6662F) * 2.4F * limbSwingAmount;
        this.LegLeft2.rotateAngleZ = 0.7853982F + MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.4F * limbSwingAmount;
        this.LegLeft3.rotateAngleZ = 0.7853982F + MathHelper.cos(limbSwing * 0.6662F) * 2.4F * limbSwingAmount;
        this.LegRight1.rotateAngleZ = 2.356194F + MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.4F * limbSwingAmount;
        this.LegRight2.rotateAngleZ = 2.356194F + MathHelper.cos(limbSwing * 0.6662F) * 2.4F * limbSwingAmount;
        this.LegRight3.rotateAngleZ = 2.356194F + MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.4F * limbSwingAmount;
    }
}
