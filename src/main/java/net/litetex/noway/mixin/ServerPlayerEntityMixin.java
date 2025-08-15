package net.litetex.noway.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.network.ServerPlayerEntity;


@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin
{
	@Inject(
		method = "canReceiveWaypoints",
		at = @At("HEAD"),
		cancellable = true)
	public void canReceiveWaypoints(final CallbackInfoReturnable<Boolean> cir)
	{
		cir.setReturnValue(false);
	}
}
