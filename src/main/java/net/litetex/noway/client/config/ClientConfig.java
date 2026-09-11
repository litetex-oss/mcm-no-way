package net.litetex.noway.client.config;

public class ClientConfig
{
	private boolean alwaysHideLocatorBar;
	
	public boolean isAlwaysHideLocatorBar()
	{
		return this.alwaysHideLocatorBar;
	}
	
	public void setAlwaysHideLocatorBar(final boolean alwaysHideLocatorBar)
	{
		this.alwaysHideLocatorBar = alwaysHideLocatorBar;
	}
	
	public void reset()
	{
		this.alwaysHideLocatorBar = true;
	}
	
	public static ClientConfig createDefault()
	{
		final ClientConfig config = new ClientConfig();
		config.reset();
		return config;
	}
}
