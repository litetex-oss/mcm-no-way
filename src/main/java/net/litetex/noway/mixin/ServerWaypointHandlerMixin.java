package net.litetex.noway.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.waypoints.ServerWaypointManager;
import net.minecraft.world.waypoints.WaypointTransmitter;


@Mixin(ServerWaypointManager.class)
public abstract class ServerWaypointHandlerMixin
{
	@Inject(
		method = "trackWaypoint(Lnet/minecraft/world/waypoints/WaypointTransmitter;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void onTrack(final WaypointTransmitter serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "updateWaypoint(Lnet/minecraft/world/waypoints/WaypointTransmitter;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void onUpdate(final WaypointTransmitter serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "untrackWaypoint(Lnet/minecraft/world/waypoints/WaypointTransmitter;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void onUntrack(final WaypointTransmitter serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "addPlayer",
		at = @At("HEAD"),
		cancellable = true)
	public void addPlayer(final ServerPlayer player, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "updatePlayer",
		at = @At("HEAD"),
		cancellable = true)
	public void updatePlayerPos(final ServerPlayer player, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "removePlayer",
		at = @At("HEAD"),
		cancellable = true)
	public void removePlayer(final ServerPlayer player, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "breakAllConnections",
		at = @At("HEAD"),
		cancellable = true)
	public void removePlayer(final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "remakeConnections(Lnet/minecraft/world/waypoints/WaypointTransmitter;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void refreshTracking(final WaypointTransmitter serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "isLocatorBarEnabledFor",
		at = @At("HEAD"),
		cancellable = true)
	private static void isLocatorBarEnabled(final ServerPlayer player, final CallbackInfoReturnable<Boolean> cir)
	{
		cir.setReturnValue(false);
	}
}
