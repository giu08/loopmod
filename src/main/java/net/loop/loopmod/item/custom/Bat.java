package net.loop.loopmod.item.custom;

import net.loop.loopmod.Loopmod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.Vec3d;

public class Bat extends SwordItem {

    public Bat(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Vec3d look = attacker.getRotationVec(1.0f).normalize();

        Vec3d knockback = new Vec3d(1, 0, 0);

        target.addVelocity(new Vec3d(
                look.x*knockback.x + look.z*knockback.z,
                look.y*knockback.x + knockback.y,
                look.z*knockback.x + look.x*knockback.z
        ));

        return super.postHit(stack, target, attacker);
    }

}
