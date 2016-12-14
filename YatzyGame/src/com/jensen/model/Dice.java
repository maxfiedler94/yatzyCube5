package com.jensen.model;


import java.util.*;

public class Dice {
	private int dice;
	private Random ran;

	
	
	
	public Dice()
	{
		dice = rollDice();
		
	}
	
	public int rollDice()
	{
		ran = new Random();
		dice = ran.nextInt(6)+1;
		
		return dice;
	}
	
	
	public int getDice()
	{
		return dice;
	}
	


}
