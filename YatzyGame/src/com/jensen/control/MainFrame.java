package com.jensen.control;

import java.awt.EventQueue;

import javax.swing.JFrame;

import graphic.Yatzy;
/**
 * MainFrame class contains the main method
 *
 */
public class MainFrame
{
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() 
		{
			/**
			 * Runs the game
			 */
			public void run() 
			{
				
				try {
					
					Yatzy window = new Yatzy();
					window.frame.setVisible(true);
					} catch (Exception e) 
					{
					e.printStackTrace();
					}
			}
		});
	}
}
