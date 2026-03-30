package net.litetex.noway.client;

import java.util.function.Consumer;

import net.litetex.noway.client.config.ClientConfig;


public class NoWayClient
{
	private static NoWayClient instance;
	
	public static NoWayClient instance()
	{
		return instance;
	}
	
	public static void setInstance(final NoWayClient instance)
	{
		NoWayClient.instance = instance;
	}
	
	private final ClientConfig config;
	private final Consumer<ClientConfig> saveConfigFunc;
	
	public NoWayClient(
		final ClientConfig config,
		final Consumer<ClientConfig> saveConfigFunc)
	{
		this.config = config;
		this.saveConfigFunc = saveConfigFunc;
	}
	
	protected void saveConfig()
	{
		this.saveConfigFunc.accept(this.config);
	}
	
	public boolean alwaysHideLocatorBar()
	{
		return this.config.isAlwaysHideLocatorBar();
	}
	
	public boolean toggleAlwaysHideLocatorBar()
	{
		this.config.setAlwaysHideLocatorBar(!this.config.isAlwaysHideLocatorBar());
		this.saveConfig();
		return this.alwaysHideLocatorBar();
	}
}
