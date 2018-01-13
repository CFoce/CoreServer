package com.akaiha.core.data.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.akaiha.core.Core;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NetworkHandler implements PluginMessageListener {
	
	public NetworkHandler (Core plugin) {
		new Transmit(plugin);
	}
	
    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] message) {
    	try {
        	DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
            JsonParser parser = new JsonParser();
        	JsonObject jObj = parser.parse(in.readUTF()).getAsJsonObject();
        	if (jObj.has("channel")) {
        		Receive.executeCommand(jObj.get("channel").getAsString(), jObj);
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
