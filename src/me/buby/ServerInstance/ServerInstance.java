package me.buby.ServerInstance;
import java.net.InetAddress;

import me.buby.ServerInstance.socket.ServerRequest;
import me.buby.ServerInstance.socket.SocketSRV;
import me.buby.ServerInstance.util.Random;

public class ServerInstance {
	public static SocketSRV socketSRV = new SocketSRV();
	public static int port = 0;
	public final static String mainIP = "0.0.0.0";//"hythecraft.com";
	public final static int mainPort = 1333;
	
	public static int srvAmount = 0;
	
	public static String thisIP = null;
	
	public static String type = "MICRO";
	
	public static void main(String[] args) {
		
		//GET TYPE FROM SETTINGS
		port = new Random().random(30000, 50000);
		try {
			thisIP = InetAddress.getLocalHost().getHostAddress().toString();

			System.out.println("Connected to Main Server Manager");
			socketSRV.start(port);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean inited = false;
	public static void init() {
		if(inited) return;
		try {
		inited = true;
		new ServerRequest(ServerInstance.mainIP, ServerInstance.mainPort, "REG_SRVMNGR_INST#" + InetAddress.getLocalHost().getHostAddress().toString() + ":" + port + ":" + ServerInstance.type);
		}catch(Exception e) {}
		
	}
}
