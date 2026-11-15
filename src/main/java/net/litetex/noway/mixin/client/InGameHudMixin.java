package net.litetex.noway.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import net.litetex.noway.client.NoWayClient;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.waypoints.ClientWaypointManager;


@Mixin(Hud.class)
public abstract class InGameHudMixin
{
	@WrapOperation(
		method = "nextContextualInfoState",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/waypoints/ClientWaypointManager;hasWaypoints()Z"))
	public boolean hasWaypoint(final ClientWaypointManager instance, final Operation<Boolean> original)
	{
		return !NoWayClient.instance().alwaysHideLocatorBar() && original.call(instance);
	}
}
