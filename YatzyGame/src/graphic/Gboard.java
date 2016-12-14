package graphic;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import classes.Dice;

import java.awt.*;
import java.awt.event.*;
import com.jensen.model.Dice;
import com.jensen.model.SetScoreByYahtzeeRules;

//import java.util.ArrayList;

public class Gboard extends JFrame implements ActionListener, MouseListener{


		private DefaultTableModel tableModel;
		//*****************************************//
		
		//Variabler som används för att byta spelare//
		private int playerCount = 1;
		private int currentPlayer = 1;
		//*****************************************//
		
		private String[][] data1;
		private String[] col;
		JPanel primary;
		private static final int SIZE = 5;
		private Dice[] diceArray;
		private int value;
		private int[] diceValueHolder;
		private JPanel panel;
		private JButton rollButton;
		private JButton[] diceButton;
		//private JButton[] diceButton1;
		private JTable table;
		private int counter;
		private JCheckBox checkBox,checkBox2,checkBox3,checkBox4,checkBox5;
		private int playerAmount;
		private String[] playerName;
		
		public Gboard() {
			// TODO Auto-generated constructor stub
			super();
			this.setTitle("Yahtzee Game");
			
		}
		
		public Gboard(int getPlayerAmount, String[] getName) {
			// TODO Auto-generated constructor stub
			super();
			playerName = new String[getPlayerAmount];
			diceArray = new Dice[SIZE];
			//arrCheckBox1 = new JCheckBox[SIZE];
			diceValueHolder = new int[SIZE];
			value=0;
			rollButton= new JButton(new ImageIcon("src/Resource/rollDiceB.jpg"));
			diceButton= new JButton[SIZE];
			//diceButton1 = new JButton[SIZE];
			//this.setTitle("Yahtzee Game");
			checkBox = new JCheckBox();
			checkBox2 = new JCheckBox();
			checkBox3 = new JCheckBox();
			checkBox4 = new JCheckBox();
			checkBox5 = new JCheckBox();
			playerAmount = getPlayerAmount;
			for(int i = 0; i < playerName.length; i++)
			{
				playerName[i] = getName[i];
			}
			
			//test = new Test();
			//createPlayer();
			
		}
		
		public void initDefaultGUI()
		{
			//RollAndDiceButtons rAndDButton = new RollAndDiceButtons();
			
			createBoard();
			
			tableModel = new DefaultTableModel(data1,col);
			table = new JTable(tableModel);
			table.getTableHeader().setReorderingAllowed(false);
			table.setModel(tableModel);
			table.setEnabled(false);
				
			
			JScrollPane scrollPane = new JScrollPane(table);
			primary = new JPanel();
			panel = new JPanel();
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			
			panel2.setBackground(Color.DARK_GRAY);
			panel2.setOpaque(true);
			panel2.add(checkBox);
			panel2.add(checkBox2);
			panel2.add(checkBox3);
			panel2.add(checkBox4);
			panel2.add(checkBox5);
			
			rollButton.setSize(new Dimension(50, 50));;
			
			
			createAndRollDice();
			panel1.add(scrollPane);
		
			
					
			panel.setPreferredSize(new Dimension(50,300));
			panel.setLayout(new GridLayout(0,1));
			//panel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			
			panel1.setPreferredSize(new Dimension(400,350));
			panel1.setLayout(new GridLayout(1,2));
			//panel1.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			
			panel2.setPreferredSize(new Dimension(20,300));
			panel2.setLayout(new GridLayout(5,1));
			//panel2.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			
			
			primary.setPreferredSize(new Dimension(800,400));
			primary.setBackground(Color.DARK_GRAY);
			primary.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			primary.add(rollButton);
			primary.add(panel);
			primary.add(panel2);
			primary.add(panel1);
			
			this.add(primary);
			
			//this.setSize(new Dimension(1200,800));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			this.pack();
			this.setLocationRelativeTo(null);
			
			rollButton.addActionListener(this);
			table.addMouseListener(this);
			diceButton[4].addActionListener(this);
			//checkBox.addMouseListener(this);
			
		}
		
		private void createBoard() {
			// TODO Auto-generated method stub
			col = new String[playerAmount+1];
			col[0]="Categories";
			for(int y = 1; y <= playerAmount; y++)
			{
				col[y]= playerName[y-1];
			}
			
			data1 = new String[19][playerAmount+1]; 
			data1[0][0] = "Ones";
			data1[1][0] = "Twos";
			data1[2][0] = "Threes";
			data1[3][0] = "Fours";
			data1[4][0] = "Fives";
			data1[5][0] = "Sixes";
			data1[6][0] = "Upper Score";
			data1[7][0] = "Upper B";
			data1[8][0] = "Pair";
			data1[9][0] = "Two Pair";
			data1[10][0] = "Three Of Kind";
			data1[11][0] = "Four Of Kind";
			data1[12][0] = "Full House[25]";
			data1[13][0] = "Small Str[30]";
			data1[14][0] = "Large Str[40]";
			data1[15][0] = "Chance";
			data1[16][0] = "Yahtzee[50]";
			data1[17][0] = "Lower Score";
			data1[18][0] = "Total";
			
			for(int i = 0; i <19;i++)
			{
				for(int j = 1; j<=playerAmount;j++)
				{
					data1[i][j] = "";
					
					//System.out.println("Hej");
				}
			}
			
		}

		public void createAndRollDice()
		{
			//int counter=0;
			for(int i = 0; i<diceArray.length;i++)
			{
				
				diceArray[i] = new Dice();
				diceButton[i] = new JButton();
				
				resetDice(i);
				panel.add(diceButton[i]);
				
			}
			//printOutDiceValueHolder();
			
		}

		public void printOutDiceValueHolder()
		{
			System.out.println("First DICE: " + diceValueHolder[0]);
			for(int i=0;i<diceValueHolder.length;i++)
			{
				System.out.println(diceValueHolder[i]);
			}
			
		}
		
		//Resettar boarden
		void clearBoard()
		{
			for(int i = 0; i < 19; i++)
			{
				for(int j = 1; j <= playerAmount; j++)
				{
					table.setValueAt("", i, j);
				}
			}
					
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			
			if(e.getSource()==rollButton)
			{
				
				for(int i = 0; i<diceArray.length;i++)
				{
					if(checkBox.isSelected())
					{
						if(i == 0)
						{
							continue;
						}
						
					}
					if(checkBox2.isSelected())
					{
						if(i == 1)
						{
							continue;
						}
						
					}
					if(checkBox3.isSelected())
					{
						if(i == 2)
						{
							continue;
						}
						
					}
					if(checkBox4.isSelected())
					{
						if(i == 3)
						{
							continue;
						}
						
					}
					if(checkBox5.isSelected())
					{
						if(i == 4)
						{
							continue;
						}
						
					}
					
					rollButtonDice(i);
				}
				
				printOutDiceValueHolder();	
				
				if(counter ==2)
				{
					rollButton.setEnabled(false);
				}	
				counter++;
				table.setEnabled(true);
			}
			
			
			//byter spelare
			for(currentPlayer = 1; currentPlayer <= playerAmount; currentPlayer++ )
			{
				if(currentPlayer == playerCount)
				{
					currentPlayer = playerCount;
					break;
				}
			}
			
			
		}
		
		public JPanel getPanelGame()
		{
			return this.primary;
		}
		
		void rollButtonDice(int _value)
		{
			value= diceArray[_value].rollDice();
			//diceButton[_value].setText(String.valueOf(value));
			diceButton[_value].setIcon(new ImageIcon("src/Resource/dice"+value+".jpg"));
			diceValueHolder[_value]= value;
		}
		
		void resetDice(int _value)
		{
			value= diceArray[_value].getDice();
			//diceButton[_value].setText(String.valueOf(value));;
			diceButton[_value].setIcon(new ImageIcon("src/Resource/rollDice.jpg"));
			
			diceValueHolder[_value]= value;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==table)
			{
				int value=0,getTableRow=0;
				getTableRow = table.getSelectedRow();
				SetScoreByYahtzeeRules setScore = new SetScoreByYahtzeeRules(diceValueHolder,getTableRow);
				
				
				
				
				for(int i=0; i<6;i++)
				{
					if(getTableRow == i)
					{
						value = setScore.upperScoreSet();
					}
				}
				
				if(getTableRow == 8)
				{
					value = setScore.pair();
				}
				if(getTableRow == 9)
				{
					value = setScore.twoPair();
				}
				
				if(getTableRow == 10)
				{
					value = setScore.threeOfKind();
				}
				if(getTableRow == 11)
				{
					value = setScore.fourOfKind();
				}
				if(getTableRow == 12)
				{
					value = setScore.fullHouse();
				}
				if(getTableRow == 13)
				{
					value = setScore.smallStraight();
				}
				if(getTableRow == 14)
				{
					value = setScore.largeStraight();
				}
				if(getTableRow == 15)
				{
					value = setScore.chance();
				}
				if(getTableRow == 16)
				{
					value = setScore.yahtzee();
				}
				
				
				
				if(isRowEmpty(getTableRow))
				{
					table.setValueAt(value, getTableRow, currentPlayer);
					for(int i=0;i<diceArray.length;i++)
					{
						diceArray[i] = new Dice();
						resetDice(i);
					}
					
					rollButton.setEnabled(true);
					
					if(playerCount == playerAmount)
					{
						playerCount = 0;
					}
					playerCount++;
					
					checkBox.setSelected(false);
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
					checkBox5.setSelected(false);
					table.setEnabled(false);
					
				}
				
				//table.setValueAt(value, getTableRow, 1);
				int upperScore = 0;
				int bonusPoint = 0;
				if(!isRowEmpty(0) && !isRowEmpty(1) && !isRowEmpty(2) && !isRowEmpty(3) && !isRowEmpty(4) && !isRowEmpty(5))
				{
					
					upperScore = getUpperScore();
					table.setValueAt(upperScore, 6, currentPlayer);
					if(upperScore >= 63)
					{
						bonusPoint = 50;
						table.setValueAt(bonusPoint, 7, currentPlayer);
					}
					else
					{
						bonusPoint = 0;
						table.setValueAt(bonusPoint, 7, currentPlayer);
					}
				}
				
				
				int lowerScore = 0;
				if(!isRowEmpty(8) && !isRowEmpty(9) && !isRowEmpty(10) && !isRowEmpty(11) && !isRowEmpty(12) && !isRowEmpty(13) && !isRowEmpty(14)&&!isRowEmpty(15))
				{
					lowerScore = getLowerScore();
					table.setValueAt(lowerScore, 16, currentPlayer);
				}
				
				
				if(!isRowEmpty(0) && !isRowEmpty(1) && !isRowEmpty(2) && !isRowEmpty(3) && !isRowEmpty(4) && !isRowEmpty(5) && !isRowEmpty(8) && !isRowEmpty(9) && !isRowEmpty(10) && !isRowEmpty(11) && !isRowEmpty(12) && !isRowEmpty(13) && !isRowEmpty(14)&&!isRowEmpty(15))
				{
					int total = bonusPoint + lowerScore + upperScore;
					table.setValueAt(total, 17, currentPlayer);
					clearBoard();
					//table.setEnabled(false);
					
				}
				
				//table.removeRowSelectionInterval(getTableRow, 1);
				counter=0;
			}
			
			//System.out.println(getTableRow);
		}
		
		private int getLowerScore() {
			// TODO Auto-generated method stub
			int returnValue = 0,newValue = 0;
			
			String getValueAsString = "";
			
			for(int i = 8; i < 16; i++)
			{
				getValueAsString = table.getValueAt(i, currentPlayer).toString();
				returnValue = Integer.parseInt(getValueAsString);
				newValue += returnValue; 
			}
			
			return newValue;
		}

		private int getUpperScore() {
			// TODO Auto-generated method stub
			int returnValue = 0,newValue = 0;
			
			String getValueAsString = "";
			
			for(int i = 0; i < 6; i++)
			{
				getValueAsString = table.getValueAt(i, currentPlayer).toString();
				returnValue = Integer.parseInt(getValueAsString);
				newValue += returnValue; 
			}
			
			return newValue;
		}

		boolean isRowEmpty(int currentClickedRow)
		{
			boolean isTrue = false;
			String getValueInRow = "";
			getValueInRow = table.getValueAt(currentClickedRow, currentPlayer).toString();
			//table.getValueAt(currentClickedRow, 1);
			
			if(getValueInRow == "")
			{
				isTrue = true;
			}
			else
			{
				isTrue = false;
			}
			
			return isTrue;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}	

