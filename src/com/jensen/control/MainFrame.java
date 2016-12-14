package com.jensen.control;

import java.awt.EventQueue;

import javax.swing.JFrame;

import graphic.Yatzy;

public class MainFrame
{
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() 
		{
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
