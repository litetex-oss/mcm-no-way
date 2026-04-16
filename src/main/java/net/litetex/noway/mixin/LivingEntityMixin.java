package net.litetex.noway.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.LivingEntity;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin
{
	@Inject(
		method = "isTransmittingWaypoint",
		at = @At("HEAD"),
		cancellable = true)
	public void hasWaypoint(final CallbackInfoReturnable<Boolean> cir)
	{
		cir.setReturnValue(false);
	}
}
