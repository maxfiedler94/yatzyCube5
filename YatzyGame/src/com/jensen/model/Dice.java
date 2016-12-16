package com.jensen.model;


import java.util.*;
/**
 * Dice class contains the dice used in Gameboard
 */
public class Dice {
	private int dice;
	private Random ran;

	
	
	/**
	 * The dice method, used with rollDice method
	 */
	public Dice()
	{
		dice = rollDice();
		
	}
	/**
	 * Rolls the dice using random
	 * @return the dice
	 */
	public int rollDice()
	{
		ran = new Random();
		dice = ran.nextInt(6)+1;
		
		return dice;
	}
	
	/**
	 * Gets the dice
	 * @return the dice
	 */
	public int getDice()
	{
		return dice;
	}
	


}
