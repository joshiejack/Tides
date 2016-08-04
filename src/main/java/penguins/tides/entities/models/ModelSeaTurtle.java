package penguins.tides.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSeaTurtle extends ModelBase {
    //fields
    private ModelRenderer shellBottom;
    private ModelRenderer shellTop;
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer neck;
    private ModelRenderer flipper1;
    private ModelRenderer blipper1;
    private ModelRenderer flipper2;
    private ModelRenderer blipper2;

    public ModelSeaTurtle() {
        textureWidth = 64;
        textureHeight = 64;

        shellBottom = new ModelRenderer(this, 0, 44);
        shellBottom.addBox(-5F, -1F, -4F, 11, 2, 8);
        shellBottom.setRotationPoint(0F, 19F, 0F);
        shellBottom.setTextureSize(64, 64);
        shellBottom.mirror = true;
        setRotation(shellBottom, 0F, 0F, 0F);
        shellTop = new ModelRenderer(this, 0, 35);
        shellTop.addBox(-4.5F, -2F, -3.5F, 10, 1, 7);
        shellTop.setRotationPoint(0F, 19F, 0F);
        shellTop.setTextureSize(64, 64);
        shellTop.mirror = true;
        setRotation(shellTop, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 55);
        body.addBox(-4.5F, 0.5F, -3.5F, 10, 2, 7);
        body.setRotationPoint(0F, 19F, 0F);
        body.setTextureSize(64, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        head = new ModelRenderer(this, 52, 59);
        head.addBox(-3.5F, -1.3F, -1.5F, 3, 2, 3);
        head.setRotationPoint(-5F, 20F, 0F);
        head.setTextureSize(64, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        neck = new ModelRenderer(this, 41, 60);
        neck.addBox(-1.5F, -0.5F, -1F, 3, 2, 2);
        neck.setRotationPoint(-5F, 20F, 0F);
        neck.setTextureSize(64, 64);
        neck.mirror = true;
        setRotation(neck, 0F, 0F, 0.0872665F);
        flipper1 = new ModelRenderer(this, 0, 27);
        flipper1.addBox(-4.4F, -0.8F, -10F, 2, 1, 6);
        flipper1.setRotationPoint(-3F, 20F, 3F);
        flipper1.setTextureSize(64, 64);
        flipper1.mirror = true;
        setRotation(flipper1, 0.296706F, -0.7853982F, 0F);
        blipper1 = new ModelRenderer(this, 0, 21);
        blipper1.addBox(-1F, 0F, -4F, 2, 1, 4);
        blipper1.setRotationPoint(5F, 20F, -3F);
        blipper1.setTextureSize(64, 64);
        blipper1.mirror = true;
        setRotation(blipper1, 0.296706F, -0.7853982F, 0F);
        flipper2 = new ModelRenderer(this, 0, 27);
        flipper2.addBox(-0.4F, 0.2F, 0F, 2, 1, 6);
        flipper2.setRotationPoint(-3F, 20F, 3F);
        flipper2.setTextureSize(64, 64);
        flipper2.mirror = true;
        setRotation(flipper2, -0.296706F, 0.7853982F, 0F);
        blipper2 = new ModelRenderer(this, 0, 21);
        blipper2.addBox(-1F, 0F, 0F, 2, 1, 4);
        blipper2.setRotationPoint(5F, 20F, 3F);
        blipper2.setTextureSize(64, 64);
        blipper2.mirror = true;
        setRotation(blipper2, -0.296706F, 0.7853982F, 0F);
        blipper2.mirror = false;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        shellBottom.render(f5);
        shellTop.render(f5);
        body.render(f5);
        head.render(f5);
        neck.render(f5);
        flipper1.render(f5);
        blipper1.render(f5);
        flipper2.render(f5);
        blipper2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    private void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.rotateAngleX = f4 / (360F / (float) Math.PI);
        this.head.rotateAngleY = f3 / (720F / (float) Math.PI);
        this.neck.rotateAngleX = this.head.rotateAngleX;
        this.neck.rotateAngleY = this.head.rotateAngleY;
        this.flipper1.rotateAngleX = MathHelper.cos(f * -0.6662F) * 1.2F * f1;
        this.flipper2.rotateAngleX = MathHelper.cos(f * -0.6662F + (float) Math.PI) * 1.2F * f1;
        this.blipper1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.2F * f1;
        this.blipper2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.2F * f1;
    }
}
