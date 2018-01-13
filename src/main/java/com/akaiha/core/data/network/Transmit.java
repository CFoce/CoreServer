package com.akaiha.core.data.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.entity.Player;

import com.akaiha.core.Core;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Transmit {
	
	private static volatile Core plugin;
	
	public Transmit(Core plugin) {
		Transmit.plugin = plugin;
	}

	public static void send(JsonObject jObj) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);
        try {
        	out.writeUTF(new Gson().toJson(jObj));
        } catch (IOException e) {
            e.printStackTrace();
        }
        plugin.getServer().getOnlinePlayers().iterator().next().sendPluginMessage(plugin, "BungeeCord", stream.toByteArray());
	}
	
	public static void send(Player p, String[] args) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);
        try {
        	for (int i = 0; i < args.length; i++) {
        		out.writeUTF(args[i]);
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.sendPluginMessage(plugin, "BungeeCord", stream.toByteArray());
	}
}
