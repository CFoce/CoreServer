package com.akaiha.core.data.network;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.JsonObject;

public class Receive {

	private static Map<String,ReceiveCommand> commands = new ConcurrentHashMap<String,ReceiveCommand>();
	
	public static void registerCommand(String name, ReceiveCommand command) {
		commands.put(name, command);
	}
	
	public static void unregisterCommand(String name) {
		commands.remove(name);
	}
	
	public static void unregisterCommand(ReceiveCommand command) {
		commands.values().remove(command);
	}
	
	public static void executeCommand(String name, JsonObject jObj) {
		commands.get(name).execute(jObj);
	}
}
