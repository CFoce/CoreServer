package com.akaiha.core;

import org.bukkit.plugin.java.JavaPlugin;

import com.akaiha.core.data.network.NetworkHandler;
import com.akaiha.core.data.network.Transmit;

public class Core extends JavaPlugin {

	public static NetworkHandler nh;
	
	@Override
	public void onEnable(){
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "Return", nh = new NetworkHandler(this));
        new Transmit(this);
    }
	
	@Override
	public void onDisable(){
		getServer().getMessenger().unregisterOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().unregisterIncomingPluginChannel(this, "Return", nh);
    }
}
