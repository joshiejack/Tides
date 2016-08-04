// Date: 04/08/2016 19:10:52
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelModelSeaTurtle extends ModelBase
{
  //fields
    ModelRenderer ShellBottom;
    ModelRenderer ShellTop;
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Neck;
    ModelRenderer Flipper1;
    ModelRenderer Blipper1;
    ModelRenderer Flipper2;
    ModelRenderer Blipper2;
  
  public ModelModelSeaTurtle()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      ShellBottom = new ModelRenderer(this, 0, 44);
      ShellBottom.addBox(-5F, -1F, -4F, 11, 2, 8);
      ShellBottom.setRotationPoint(0F, 19F, 0F);
      ShellBottom.setTextureSize(64, 64);
      ShellBottom.mirror = true;
      setRotation(ShellBottom, 0F, 0F, 0F);
      ShellTop = new ModelRenderer(this, 0, 35);
      ShellTop.addBox(-4.5F, -1F, -3.5F, 10, 1, 7);
      ShellTop.setRotationPoint(0F, 18F, 0F);
      ShellTop.setTextureSize(64, 64);
      ShellTop.mirror = true;
      setRotation(ShellTop, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 55);
      Body.addBox(-4.5F, 0.5F, -3.5F, 10, 2, 7);
      Body.setRotationPoint(0F, 19F, 0F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 52, 59);
      Head.addBox(-8.5F, -0.3F, -1.5F, 3, 2, 3);
      Head.setRotationPoint(0F, 19F, 0F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Neck = new ModelRenderer(this, 41, 60);
      Neck.addBox(-6.5F, 0.5F, -1F, 3, 2, 2);
      Neck.setRotationPoint(0F, 19F, 0F);
      Neck.setTextureSize(64, 64);
      Neck.mirror = true;
      setRotation(Neck, 0F, 0F, 0.0872665F);
      Flipper1 = new ModelRenderer(this, 0, 27);
      Flipper1.addBox(-5.4F, 1.2F, -5F, 2, 1, 6);
      Flipper1.setRotationPoint(0.5F, 19F, 0F);
      Flipper1.setTextureSize(64, 64);
      Flipper1.mirror = true;
      setRotation(Flipper1, 0.296706F, -0.7853982F, 0F);
      Blipper1 = new ModelRenderer(this, 0, 21);
      Blipper1.addBox(0F, -0.5F, -9F, 2, 1, 4);
      Blipper1.setRotationPoint(0.5F, 19F, 0F);
      Blipper1.setTextureSize(64, 64);
      Blipper1.mirror = true;
      setRotation(Blipper1, 0.296706F, -0.7853982F, 0F);
      Flipper2.mirror = true;
      Flipper2 = new ModelRenderer(this, 0, 27);
      Flipper2.addBox(-5.4F, 1.2F, -1F, 2, 1, 6);
      Flipper2.setRotationPoint(0.5F, 19F, 0F);
      Flipper2.setTextureSize(64, 64);
      Flipper2.mirror = true;
      setRotation(Flipper2, -0.296706F, 0.7853982F, 0F);
      Flipper2.mirror = false;
      Blipper2.mirror = true;
      Blipper2 = new ModelRenderer(this, 0, 21);
      Blipper2.addBox(0F, -0.5F, 5F, 2, 1, 4);
      Blipper2.setRotationPoint(0.5F, 19F, 0F);
      Blipper2.setTextureSize(64, 64);
      Blipper2.mirror = true;
      setRotation(Blipper2, -0.296706F, 0.7853982F, 0F);
      Blipper2.mirror = false;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    ShellBottom.render(f5);
    ShellTop.render(f5);
    Body.render(f5);
    Head.render(f5);
    Neck.render(f5);
    Flipper1.render(f5);
    Blipper1.render(f5);
    Flipper2.render(f5);
    Blipper2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
