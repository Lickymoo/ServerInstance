package me.buby.ServerInstance.socket;

public class ServerRequest {

	public String response;
	
	public ServerRequest(String IP, int port, String msg) {
		SocketInterface client = new SocketInterface();
		client.startConnection(IP, port);
		String send = ""; 
		send = client.sendMessage(msg);
		client.stopConnection();
		this.response = send;
	}
}
