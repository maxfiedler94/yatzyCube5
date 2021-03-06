package graphic;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.jensen.model.Dice;
import com.jensen.model.SetScoreByYahtzeeRules;
/**
 * 
 * GboardG contains the gameboard and player
 * 
 */
public class GameBoardG implements MouseListener
{
	private DefaultTableModel tableModel;
	private int playerCount = 1;
	private int currentPlayer = 1;
	private int playerAmount;
	private String[][] data1;
	private String[] col;
	private static final int SIZE =5;
	private com.jensen.model.Dice[] diceArray = new Dice[SIZE];
	private int[] diceValueHolder = new int [SIZE];
	private int value;
	JButton rollButton = new JButton("");
	private JPanel panelGame;
	private JButton diceButton[] = new JButton[SIZE];
	private JButton dice1Button;
	private JButton dice2Button;
	private JButton dice3Button;
	private JButton dice4Button;
	private JButton dice5Button;
	private JTable table;
	private JFrame devFrame;
	private JTextField textField;
	private String[] playerName;
	private JPanel panel;
	private String getCurrentPlayer = "";
	//private JScrollPane scrollPane;
	//private String player1, player2;
	private JCheckBox checkBox,checkBox2,checkBox3,checkBox4,checkBox5;
	int counter = 0;
	
	/**
	 * @wbp.parser.constructor
	 * Constructor
	 */
	public GameBoardG()
	{
		checkBox = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		checkBox4 = new JCheckBox();
		checkBox5 = new JCheckBox();
		panelGame = new JPanel();
	}
	
	/**
	 * The gameboard for 2 players
	 * 
	 * @param p1 Player one
	 * @param p2 Player two
	 * @param playerCount amount of players
	 */
	public GameBoardG(String p1, String p2, int playerCount) 
	{
		playerAmount = playerCount;
		playerName = new String[playerAmount];
		playerName[0] = p1;
		playerName[1] = p2;
		
		panelGame = new JPanel();
		
	}
	/**
	 * The gameboard for 3 players
	 * 
	 * @param p1 Player one 
	 * @param p2 Player two
	 * @param p3 Player three
	 * @param playerCount amount of players
	 */
	
	public GameBoardG(String p1, String p2,String p3,int playerCount) 
	{
		playerAmount = playerCount;
		playerName = new String[playerAmount];
		playerName[0] = p1;
		playerName[1] = p2;
		playerName[2] = p3;
		panelGame = new JPanel();
		
	}
	
	/**
	 * The gameboard for 4 players
	 * @param p1 Player one
	 * @param p2 Player two
	 * @param p3 Player three
	 * @param p4 Player four
	 * @param playerCount amount of players
	 */
	
	public GameBoardG(String p1, String p2,String p3,String p4,int playerCount) 
	{
		playerAmount = playerCount;
		playerName = new String[playerAmount];
		playerName[0] = p1;
		playerName[1] = p2;
		playerName[2] = p3;
		playerName[3] = p4;
		panelGame = new JPanel();
		
	}
	/**
	 * Initializes the gameboard along with the graphics
	 */
	void iniGUI()
	{
		checkBox = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		checkBox4 = new JCheckBox();
		checkBox5 = new JCheckBox();
		
		panelGame.setBackground(Color.BLACK);

		panelGame.setLayout(null);
		
		rollButton.setPressedIcon(new ImageIcon("Resourses/RollClick.jpg"));
		rollButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rollButton.setFocusPainted(false);
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				if(e.getSource()==rollButton)
				{
					
					for(int i = 0; i<diceButton.length;i++)
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
						diceArray[i] = new Dice();
						rollButtonDice(i);
					}
					
					table.setEnabled(true);
					
					
					printOutDiceValueHolder();
					
				}
				
				if(counter == 2)
				{
					rollButton.setEnabled(false);
				}	
				counter++;
				
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
		});
		createBoard();
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("GAMECUBEN", Font.PLAIN, 18));
		textField.setForeground(new Color(0, 0, 255));
		textField.setBackground(Color.BLACK);
		textField.setEnabled(false);
		textField.setBounds(480, 510, 350, 58);
		panelGame.add(textField);
		textField.setColumns(10); 
		panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		//table.addMouseListener(this);
		rollButton.setIcon(new ImageIcon("Resourses/RollDefault.jpg"));
		rollButton.setBorderPainted(false);
		rollButton.setBounds(80, 32, 115, 50);
		panelGame.add(rollButton);
		
		dice1Button = new JButton();
		dice1Button.setBorderPainted(false);
		dice1Button.setIcon(new ImageIcon("Resourses/diceQ.jpg"));
		dice1Button.setBounds(84, 130, 100, 100);
		panelGame.add(dice1Button);
		
		
		dice2Button = new JButton();
		dice2Button.setBorderPainted(false);
		dice2Button.setIcon(new ImageIcon("Resourses/diceQ.jpg"));
		dice2Button.setBounds(84, 243, 100, 100);
		panelGame.add(dice2Button);
		
		dice3Button = new JButton();
		dice3Button.setBorderPainted(false);
		dice3Button.setIcon(new ImageIcon("Resourses/diceQ.jpg"));
		dice3Button.setBounds(84, 356, 100, 100);
		panelGame.add(dice3Button);
		
		dice4Button = new JButton();
		dice4Button.setBorderPainted(false);
		dice4Button.setIcon(new ImageIcon("Resourses/diceQ.jpg"));
		dice4Button.setBounds(84, 469, 100, 100);
		panelGame.add(dice4Button);
		
		dice5Button = new JButton();
		dice5Button.setBorderPainted(false);
		dice5Button.setIcon(new ImageIcon("Resourses/diceQ.jpg"));
		dice5Button.setBounds(84, 582, 100, 100);
		panelGame.add(dice5Button);
		
		diceButton[0] = dice1Button;
		diceButton[1] = dice2Button;
		diceButton[2] = dice3Button;
		diceButton[3] = dice4Button;
		diceButton[4] = dice5Button;
		
		checkBox = new JCheckBox("");
		checkBox.setBackground(Color.BLACK);
		checkBox.setBounds(196, 168, 25, 25);
		panelGame.add(checkBox);
		
		checkBox2 = new JCheckBox("");
		checkBox2.setBackground(Color.BLACK);
		checkBox2.setBounds(196, 280, 25, 25);
		panelGame.add(checkBox2);
		
		checkBox3 = new JCheckBox("");
		checkBox3.setBackground(Color.BLACK);
		checkBox3.setBounds(196, 395, 25, 25);
		panelGame.add(checkBox3);
		
		checkBox4 = new JCheckBox("");
		checkBox4.setBackground(Color.BLACK);
		checkBox4.setBounds(196, 507, 25, 25);
		panelGame.add(checkBox4);
		
		checkBox5 = new JCheckBox("");
		checkBox5.setBackground(Color.BLACK);
		checkBox5.setBounds(196, 622, 25, 25);
		panelGame.add(checkBox5);
		
		
		
			
		
		
		
		//knapp som �ppnar ny JFrame och visar vilka som utvecklat spelet
		JButton devTeamButton = new JButton("");
		devTeamButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		devTeamButton.setBorderPainted(false);
		devTeamButton.setPressedIcon(new ImageIcon("Resourses/devClick.jpg"));
		devTeamButton.setIcon(new ImageIcon("Resourses/devDefault.jpg"));
		devTeamButton.setBounds(1051, 237, 80, 80);
		panelGame.add(devTeamButton);
		devTeamButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				devFrame.setVisible(true);
			}
		});
		devFrame = new JFrame();
		devFrame.setResizable(false);
		devFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("Resourses/y6.jpg"));
		devFrame.setBounds(100, 100, 450, 300);
		devFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		devFrame.setSize(500,500);
		devFrame.getContentPane().setLayout(new CardLayout(0, 0));
		devFrame.setVisible(false);
		JPanel panelDev = new JPanel();
		devFrame.getContentPane().add(panelDev, "name_989956785704721");
		panelDev.setLayout(null);
		devFrame.setLocationRelativeTo(null);
		JLabel background3 = new JLabel("");
		background3.setIcon(new ImageIcon("Resourses/developers.jpg"));
		background3.setBounds(0, 0, 500, 500);
		panelDev.add(background3);
		devTeamButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				devFrame.setVisible(true);
			}
		});
		
		
		
		getCurrentPlayer = playerName[0]+"'S TURN"; 
		textField.setText(getCurrentPlayer);
		
		JButton infoButton = new JButton("");
		infoButton.setBorderPainted(false);
		infoButton.setPressedIcon(new ImageIcon("Resourses/infoClick.jpg"));
		infoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		infoButton.setIcon(new ImageIcon("Resourses/infoDefault.jpg"));
		infoButton.setBounds(1051, 109, 80, 80);
		panelGame.add(infoButton);
		
		JButton backButton = new JButton("");
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setBorderPainted(false);
		backButton.setRolloverIcon(new ImageIcon("Resourses/backHover.jpg"));
		backButton.setIcon(new ImageIcon("Resourses/backDefault.jpg"));
		backButton.setBounds(-1, 0, 25, 25);
		panelGame.add(backButton);
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Yatzy choose = new Yatzy();
				choose.getPanelChoose().setVisible(true);
				panelGame.setVisible(false);
			}
		});

		tableModel = new DefaultTableModel(data1,col);
		table = new JTable(tableModel);
		table.setCellSelectionEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setPreferredScrollableViewportSize(new Dimension(720, 720));
		table.setBackground(Color.GRAY);
		table.setGridColor(Color.BLACK);
		table.setRowHeight(23);
		table.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		table.setModel(tableModel);
		table.setEnabled(false);
		String temValue = "?";
		for(int i = 1; i <= playerAmount; i++)
		{
			table.setValueAt(temValue, 6, i);
			table.setValueAt(temValue, 7, i);
			table.setValueAt(temValue, 17, i);
			table.setValueAt(temValue, 18, i);
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel1.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		panel1.setPreferredSize(new Dimension(400,350));
		panel1.setBounds(295, 32, 731, 475);
		panel1.add(scrollPane);
	
		panel1.setForeground(Color.WHITE);
		panelGame.add(panel2);
		panelGame.add(panel1);
		
		table.addMouseListener(this);
		Yatzy.frame.getContentPane().add(panelGame, "name_531936123301123");
		//Yatzy.frame.getContentPane().add(panelGame);
	}
	/**
	 * Creates the gameboard
	 */
	private void createBoard() {
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
		data1[12][0] = "Full House";
		data1[13][0] = "Small Straight[15]";
		data1[14][0] = "Large Straight[20]";
		data1[15][0] = "Chance";
		data1[16][0] = "Yahtzee[50]";
		data1[17][0] = "Lower Score";
		data1[18][0] = "Total";
		
		for(int i = 0; i <19;i++)
		{
			for(int j = 1; j<=playerAmount;j++)
			{
				data1[i][j] = "";
			
			}
		}
		
	}
	
	public JPanel getPanelGame()
	{
		return panelGame;
	}
	public void printOutDiceValueHolder()
	{
		System.out.println("First DICE: " + diceValueHolder[0]);
		for(int i=0;i<diceValueHolder.length;i++)
		{
			System.out.println(diceValueHolder[i]);
		}
		
	}

	/**
	 * Creates dice object
	 */
	public void createAndRollDice()
	{

		for(int i = 0; i<diceArray.length;i++)
		{
			
			diceArray[i] = new Dice();
			diceButton[i] = new JButton();
			
			resetDice(i);
			panel.add(diceButton[i]);
			
		}
		
	}
	
	/**
	 * The roll button
	 * @param _value Value of the dice(button)
	 */
	void rollButtonDice(int _value)
	{
		value= diceArray[_value].rollDice();
		//diceButton[_value].setText(String.valueOf(value));
		diceButton[_value].setIcon(new ImageIcon("Resourses/dice"+value+".jpg"));
		diceValueHolder[_value]= value;
	}
	/**
	 * Resets the dice after 3 rolls
	 * @param _value Value of dice rolls
	 */
	void resetDice(int _value)
	{
		value= diceArray[_value].getDice();
		diceButton[_value].setIcon(new ImageIcon("Resourses/diceQ.jpg"));
		
		diceValueHolder[_value]= value;
	}
	
	/**
	 * Sets the score in the selected column inside the table
	 */
	public void mouseClicked(MouseEvent e) 
	{
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
				if(playerCount == playerAmount)
				{
					playerCount = 0;
				}
				playerCount++;
				
				rollButton.setEnabled(true);
				
				getCurrentPlayer = playerName[playerCount-1]+"'S TURN"; 
				textField.setText(getCurrentPlayer);
				
				table.setEnabled(false);
				
			}
			
			
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
			if(!isRowEmpty(8) && !isRowEmpty(9) && !isRowEmpty(10) && !isRowEmpty(11) && !isRowEmpty(12) && !isRowEmpty(13) && !isRowEmpty(14)&&!isRowEmpty(15)&&!isRowEmpty(16))
			{
				lowerScore = getLowerScore();
				table.setValueAt(lowerScore, 17, currentPlayer);
			}
			
			int playerTableCounter = 0;
			if(!isRowEmpty(0) && !isRowEmpty(1) && !isRowEmpty(2) && !isRowEmpty(3) && !isRowEmpty(4) && !isRowEmpty(5) && !isRowEmpty(8) && !isRowEmpty(9) && !isRowEmpty(10) && !isRowEmpty(11) && !isRowEmpty(12) && !isRowEmpty(13) && !isRowEmpty(14) && !isRowEmpty(15) && !isRowEmpty(16))
			{
				int total = bonusPoint + lowerScore + upperScore;
				table.setValueAt(total, 18, currentPlayer);
				
				playerTableCounter++;
				if(playerTableCounter == playerAmount)
				{
					if(playerAmount == 2)
					{
						int playerOnesTotalPoint = 0;
						int playerTwosTotalPoint = 0;
						String temp1 = "";
						String temp2 = "";
						
						temp1 = table.getValueAt(18, 1).toString();
						playerOnesTotalPoint = Integer.parseInt(temp1);
						
						temp2 = table.getValueAt(18, 2).toString();
						playerTwosTotalPoint = Integer.parseInt(temp2);
						
						if(playerOnesTotalPoint < playerTwosTotalPoint)
						{
							textField.setText(playerName[0]+" is winner.");
						}
						else if(playerOnesTotalPoint == playerTwosTotalPoint)
						{
							textField.setText("It's a draw!");
						}
						else
						{
							textField.setText(playerName[1]+" is winner.");
						}
					}
				/*SwingUtilities.updateComponentTreeUI(this);
				this.invalidate();
				this.validate();
				this.repaint();
				createBoard();*/
				table.revalidate();
				//table.repaint();
				
			}
	
			
			
			}
			checkBox.setSelected(false);
			checkBox2.setSelected(false);
			checkBox3.setSelected(false);
			checkBox4.setSelected(false);
			checkBox5.setSelected(false);
			counter = 0;
		}
		

	}
	/**
	 * Calculates total lower table score
	 * @return value of the score
	 */
	private int getLowerScore() {
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
	
	/**
	 * Calculates total upper table score
	 * @return value of the score
	 */
	
	private int getUpperScore() {

		
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
	/**
	 *  Checks if the row is empty
	 * @param currentClickedRow Selects row with click 
	 * @return if the row is taken or not
	 */

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
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	}