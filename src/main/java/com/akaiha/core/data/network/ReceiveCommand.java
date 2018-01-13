package com.akaiha.core.data.network;

import com.google.gson.JsonObject;

public interface ReceiveCommand {
	public void execute(JsonObject jObj);
}