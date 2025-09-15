package net.litetex.noway.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.litetex.noway.client.NoWayClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.world.ClientWaypointHandler;


@Mixin(InGameHud.class)
public abstract class InGameHudMixin
{
	@Redirect(
		method = "getCurrentBarType",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWaypointHandler;hasWaypoint()Z"))
	public boolean hasWaypoint(final ClientWaypointHandler instance)
	{
		return !NoWayClient.instance().alwaysHideLocatorBar() && instance.hasWaypoint();
	}
}
