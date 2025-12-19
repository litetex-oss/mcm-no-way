package net.litetex.noway.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.litetex.noway.client.NoWayClient;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.waypoints.ClientWaypointManager;


@Mixin(Gui.class)
public abstract class InGameHudMixin
{
	@Redirect(
		method = "nextContextualInfoState",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/waypoints/ClientWaypointManager;hasWaypoints()Z"))
	public boolean hasWaypoint(final ClientWaypointManager instance)
	{
		return !NoWayClient.instance().alwaysHideLocatorBar() && instance.hasWaypoints();
	}
}
