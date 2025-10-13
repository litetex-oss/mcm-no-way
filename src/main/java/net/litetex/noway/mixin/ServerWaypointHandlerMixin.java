package net.litetex.noway.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerWaypointHandler;
import net.minecraft.world.waypoint.ServerWaypoint;


@Mixin(ServerWaypointHandler.class)
public abstract class ServerWaypointHandlerMixin
{
	@Inject(
		method = "onTrack(Lnet/minecraft/world/waypoint/ServerWaypoint;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void onTrack(final ServerWaypoint serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "onUpdate(Lnet/minecraft/world/waypoint/ServerWaypoint;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void onUpdate(final ServerWaypoint serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "onUntrack(Lnet/minecraft/world/waypoint/ServerWaypoint;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void onUntrack(final ServerWaypoint serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "addPlayer",
		at = @At("HEAD"),
		cancellable = true)
	public void addPlayer(final ServerPlayerEntity player, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "updatePlayerPos",
		at = @At("HEAD"),
		cancellable = true)
	public void updatePlayerPos(final ServerPlayerEntity player, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "removePlayer",
		at = @At("HEAD"),
		cancellable = true)
	public void removePlayer(final ServerPlayerEntity player, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "clear",
		at = @At("HEAD"),
		cancellable = true)
	public void removePlayer(final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "refreshTracking(Lnet/minecraft/world/waypoint/ServerWaypoint;)V",
		at = @At("HEAD"),
		cancellable = true)
	public void refreshTracking(final ServerWaypoint serverWaypoint, final CallbackInfo ci)
	{
		ci.cancel();
	}
	
	@Inject(
		method = "isLocatorBarEnabled",
		at = @At("HEAD"),
		cancellable = true)
	private static void isLocatorBarEnabled(final ServerPlayerEntity player, final CallbackInfoReturnable<Boolean> cir)
	{
		cir.setReturnValue(false);
	}
}
