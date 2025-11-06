package net.litetex.noway.client;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.blaze3d.platform.InputConstants;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.litetex.noway.client.config.ClientConfig;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;


public class NoWayFabricClientInitializer implements ClientModInitializer
{
	private static final Logger LOG = LoggerFactory.getLogger(NoWayFabricClientInitializer.class);
	
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@Override
	public void onInitializeClient()
	{
		final ClientConfig config = this.loadConfig();
		NoWayClient.setInstance(new NoWayClient(
			config,
			this::saveConfig
		));
		
		this.initKeys();
		
		LOG.debug("Initialized");
	}
	
	private Path configFilePath()
	{
		return FabricLoader.getInstance().getConfigDir().resolve("no-way.json5");
	}
	
	private ClientConfig loadConfig()
	{
		final Path configFilePath = this.configFilePath();
		if(Files.exists(configFilePath))
		{
			try
			{
				return this.gson.fromJson(Files.readString(configFilePath), ClientConfig.class);
			}
			catch(final IOException ioe)
			{
				LOG.warn("Failed to read config file", ioe);
			}
		}
		
		final ClientConfig defaultConfig = ClientConfig.createDefault();
		this.saveConfig(defaultConfig);
		return defaultConfig;
	}
	
	private void saveConfig(final ClientConfig config)
	{
		try
		{
			Files.writeString(
				this.configFilePath(),
				this.gson.toJson(config));
		}
		catch(final IOException ioe)
		{
			throw new UncheckedIOException("Failed to save config", ioe);
		}
	}
	
	private void initKeys()
	{
		final KeyMapping kbToggleAlwaysHideLocatorBar = KeyBindingHelper.registerKeyBinding(new KeyMapping(
			"no-way.toggle-always-hide-locator-bar",
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_F10,
			KeyMapping.Category.MISC
		));
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while(kbToggleAlwaysHideLocatorBar.consumeClick())
			{
				final boolean on = NoWayClient.instance().toggleAlwaysHideLocatorBar();
				client.gui.getChat().addMessage(
					Component.translatable("no-way.always-hide-locator-bar." + (on ? "on" : "off")));
			}
		});
	}
}
