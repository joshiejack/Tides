//package net.minecraft.src;
//
//public class ModelModelCrab extends ModelBase
//{
//  //fields
//    ModelRenderer Base;
//    ModelRenderer BaseTop;
//    ModelRenderer ClawLeft1;
//    ModelRenderer ClawLeft2;
//    ModelRenderer ClawLeft3;
//    ModelRenderer ClawRight1;
//    ModelRenderer ClawRight2;
//    ModelRenderer ClawRight3;
//    ModelRenderer LegLeft2;
//    ModelRenderer LegLeft1;
//    ModelRenderer LegLeft3;
//    ModelRenderer LegRight2;
//    ModelRenderer LegRight1;
//    ModelRenderer LegRight3;
//    ModelRenderer EyeLeft;
//    ModelRenderer EyeRight;
//
//  public ModelModelCrab()
//  {
//    textureWidth = 32;
//    textureHeight = 32;
//
//      Base = new ModelRenderer(this, 0, 24);
//      Base.addBox(-4F, -1F, -3F, 8, 2, 6);
//      Base.setRotationPoint(0F, 20F, 0F);
//      Base.setTextureSize(32, 32);
//      Base.mirror = true;
//      setRotation(Base, 0F, 0F, 0F);
//      BaseTop = new ModelRenderer(this, 0, 17);
//      BaseTop.addBox(-3.5F, 0F, -2.5F, 7, 1, 5);
//      BaseTop.setRotationPoint(0F, 18F, 0F);
//      BaseTop.setTextureSize(32, 32);
//      BaseTop.mirror = true;
//      setRotation(BaseTop, 0F, 0F, 0F);
//      ClawLeft1 = new ModelRenderer(this, 24, 18);
//      ClawLeft1.addBox(0F, 0F, 0F, 3, 2, 1);
//      ClawLeft1.setRotationPoint(3.5F, 20F, 3F);
//      ClawLeft1.setTextureSize(32, 32);
//      ClawLeft1.mirror = true;
//      setRotation(ClawLeft1, 0F, -0.7853982F, 0F);
//      ClawLeft2 = new ModelRenderer(this, 28, 22);
//      ClawLeft2.addBox(3F, 1F, 0F, 1, 1, 1);
//      ClawLeft2.setRotationPoint(3.5F, 20F, 3F);
//      ClawLeft2.setTextureSize(32, 32);
//      ClawLeft2.mirror = true;
//      setRotation(ClawLeft2, 0F, -0.7853982F, 0F);
//      ClawLeft3 = new ModelRenderer(this, 28, 22);
//      ClawLeft3.addBox(2F, 1F, 1F, 1, 1, 1);
//      ClawLeft3.setRotationPoint(3.5F, 20F, 3F);
//      ClawLeft3.setTextureSize(32, 32);
//      ClawLeft3.mirror = true;
//      setRotation(ClawLeft3, 0F, -0.7853982F, 0F);
//      ClawRight1.mirror = true;
//      ClawRight1 = new ModelRenderer(this, 24, 18);
//      ClawRight1.addBox(-3F, 0F, 0F, 3, 2, 1);
//      ClawRight1.setRotationPoint(-3.5F, 20F, 3F);
//      ClawRight1.setTextureSize(32, 32);
//      ClawRight1.mirror = true;
//      setRotation(ClawRight1, 0F, 0.7853982F, 0F);
//      ClawRight1.mirror = false;
//      ClawRight2.mirror = true;
//      ClawRight2 = new ModelRenderer(this, 28, 22);
//      ClawRight2.addBox(-3F, 1F, 1F, 1, 1, 1);
//      ClawRight2.setRotationPoint(-3.5F, 20F, 3F);
//      ClawRight2.setTextureSize(32, 32);
//      ClawRight2.mirror = true;
//      setRotation(ClawRight2, 0F, 0.7853982F, 0F);
//      ClawRight2.mirror = false;
//      ClawRight3.mirror = true;
//      ClawRight3 = new ModelRenderer(this, 28, 22);
//      ClawRight3.addBox(-4F, 1F, 0F, 1, 1, 1);
//      ClawRight3.setRotationPoint(-3.5F, 20F, 3F);
//      ClawRight3.setTextureSize(32, 32);
//      ClawRight3.mirror = true;
//      setRotation(ClawRight3, 0F, 0.7853982F, 0F);
//      ClawRight3.mirror = false;
//      LegLeft2 = new ModelRenderer(this, 0, 14);
//      LegLeft2.addBox(1F, -0.5F, -0.5F, 4, 1, 1);
//      LegLeft2.setRotationPoint(3F, 20F, 0F);
//      LegLeft2.setTextureSize(32, 32);
//      LegLeft2.mirror = true;
//      setRotation(LegLeft2, 0F, 0F, 0.7853982F);
//      LegLeft1 = new ModelRenderer(this, 0, 14);
//      LegLeft1.addBox(1F, -0.5F, -0.5F, 4, 1, 1);
//      LegLeft1.setRotationPoint(3F, 20F, -1.5F);
//      LegLeft1.setTextureSize(32, 32);
//      LegLeft1.mirror = true;
//      setRotation(LegLeft1, 0F, 0.3490659F, 0.7853982F);
//      LegLeft3 = new ModelRenderer(this, 0, 14);
//      LegLeft3.addBox(1F, -0.5F, -0.5F, 4, 1, 1);
//      LegLeft3.setRotationPoint(3F, 20F, 1.5F);
//      LegLeft3.setTextureSize(32, 32);
//      LegLeft3.mirror = true;
//      setRotation(LegLeft3, 0F, -0.3490659F, 0.7853982F);
//      LegRight2 = new ModelRenderer(this, 0, 14);
//      LegRight2.addBox(1F, -0.5F, -0.5F, 4, 1, 1);
//      LegRight2.setRotationPoint(-3F, 20F, 0F);
//      LegRight2.setTextureSize(32, 32);
//      LegRight2.mirror = true;
//      setRotation(LegRight2, 0F, 0F, 2.356194F);
//      LegRight1 = new ModelRenderer(this, 0, 14);
//      LegRight1.addBox(1F, -0.5F, -0.5F, 4, 1, 1);
//      LegRight1.setRotationPoint(-3F, 20F, -1.5F);
//      LegRight1.setTextureSize(32, 32);
//      LegRight1.mirror = true;
//      setRotation(LegRight1, 0F, -0.3490659F, 2.356194F);
//      LegRight3 = new ModelRenderer(this, 0, 14);
//      LegRight3.addBox(1F, -0.5F, -0.5F, 4, 1, 1);
//      LegRight3.setRotationPoint(-3F, 20F, 1.5F);
//      LegRight3.setTextureSize(32, 32);
//      LegRight3.mirror = true;
//      setRotation(LegRight3, 0F, 0.3490659F, 2.356194F);
//      EyeLeft = new ModelRenderer(this, 0, 10);
//      EyeLeft.addBox(-0.5F, -2F, 0F, 1, 2, 1);
//      EyeLeft.setRotationPoint(1.5F, 19F, 2F);
//      EyeLeft.setTextureSize(32, 32);
//      EyeLeft.mirror = true;
//      setRotation(EyeLeft, 0F, 0F, 0F);
//      EyeRight = new ModelRenderer(this, 0, 10);
//      EyeRight.addBox(-0.5F, -2F, 0F, 1, 2, 1);
//      EyeRight.setRotationPoint(-1.5F, 19F, 2F);
//      EyeRight.setTextureSize(32, 32);
//      EyeRight.mirror = true;
//      setRotation(EyeRight, 0F, 0F, 0F);
//  }
//
//  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
//  {
//    super.render(entity, f, f1, f2, f3, f4, f5);
//    setRotationAngles(f, f1, f2, f3, f4, f5);
//    Base.render(f5);
//    BaseTop.render(f5);
//    ClawLeft1.render(f5);
//    ClawLeft2.render(f5);
//    ClawLeft3.render(f5);
//    ClawRight1.render(f5);
//    ClawRight2.render(f5);
//    ClawRight3.render(f5);
//    LegLeft2.render(f5);
//    LegLeft1.render(f5);
//    LegLeft3.render(f5);
//    LegRight2.render(f5);
//    LegRight1.render(f5);
//    LegRight3.render(f5);
//    EyeLeft.render(f5);
//    EyeRight.render(f5);
//  }
//
//  private void setRotation(ModelRenderer model, float x, float y, float z)
//  {
//    model.rotateAngleX = x;
//    model.rotateAngleY = y;
//    model.rotateAngleZ = z;
//  }
//
//  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
//  {
//    super.setRotationAngles(f, f1, f2, f3, f4, f5);
//  }
//
//}
