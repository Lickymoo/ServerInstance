package me.buby.ServerInstance.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import me.buby.ServerInstance.MCSRVInstance;
import me.buby.ServerInstance.ServerInstance;

public class SocketSRV {
	
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;	
	
	public void start(int port) {
	        try {
	 	       	serverSocket = new ServerSocket(port, 100);
	 			new Thread() {
	 				@Override
	 				public void run() {
	 					ServerInstance.init();
	 				}
	 			}.start();
	 	     	clientSocket = serverSocket.accept();
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String msg = in.readLine();
				String delim = null;
				{
					delim = "NEW_MCSRV_DONE#";
	            	if(msg.contains(delim))
	            	{
	            		MCSRVInstance inst = new MCSRVInstance();
	            		out.println(ServerInstance.thisIP + ":" +inst.port);
	            	}
				}
				{
					delim = "GET_AMOUNT_SRV";
	            	if(msg.contains(delim))
	            	{
	            		out.println(ServerInstance.srvAmount);
	            	}
				}
				{
					delim = "GET_AMOUNT_RAM";
	            	if(msg.contains(delim))
	            	{
	            		out.println(Runtime.getRuntime().freeMemory());
	            	}
				}
				{
					delim = "GET_WEIGHT";
	            	if(msg.contains(delim))
	            	{
	            		out.println(0);
	            	}
				}
				{
					delim = "GET_SERVERS";
	            	if(msg.contains(delim))
	            	{
	            	}
				}

	                      
        		stop(port); //RECURSIVE;
	            
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void stop(int port) {
		try {
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		start(port);
	}
	
}