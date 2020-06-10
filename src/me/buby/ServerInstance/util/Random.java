package me.buby.ServerInstance.util;

public class Random {
	
	public int random(int min, int max)
	{
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
}
