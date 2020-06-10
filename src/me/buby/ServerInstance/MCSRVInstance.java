package me.buby.ServerInstance;

import java.util.UUID;

import me.buby.ServerInstance.util.Random;

public class MCSRVInstance {
	
	public String ID;
	public int port;
	public MCSRVInstance() {
		this.ID = UUID.randomUUID().toString();
		this.port = new Random().random(50001, 70000);
		ServerInstance.srvAmount++;
		//CREATE DOCKER INSTANCE
	}
}
