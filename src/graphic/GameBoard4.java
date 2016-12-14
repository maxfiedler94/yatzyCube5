package graphic;



import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.jensen.model.Dice;

public class GameBoard4 implements MouseListener
{
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
	private JTable table3;
	private JScrollPane scrollPane3;
	private String player1, player2, player3, player4;
	int counter = 0;
	
	/**
	 * @wbp.parser.constructor
	 */
	public GameBoard4()
	{
		panelGame = new JPanel();
	}
	public GameBoard4(String p1, String p2, String p3, String p4) 
	{
		player1 = p1;
		player2 = p2;
		player3 = p3;
		player4 = p4;
		panelGame = new JPanel();
		
	}
	void iniGUI()
	{
		
		panelGame.setBackground(Color.BLACK);

		panelGame.setLayout(null);
		
		rollButton.setPressedIcon(new ImageIcon("Resourses/RollClick.jpg"));
		rollButton.setFocusPainted(false);
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				if(e.getSource()==rollButton)
				{
					
					for(int i = 0; i<diceButton.length;i++)
					{
						diceArray[i] = new Dice();
						value= diceArray[i].getDice();
						diceButton[i].setIcon(new ImageIcon("Resourses/dice"+value+".jpg"));
						diceValueHolder[i]= value;
					}
					
				}
				if(counter == 2)
				{
					rollButton.setEnabled(false);
				}
				else
				{
					
					counter++;
				}
				printOutDiceValueHolder();
				
				
			}
		});
		
		 
		
		
		
		//table.addMouseListener(this);
		rollButton.setIcon(new ImageIcon("Resourses/RollDefault.jpg"));
		rollButton.setBorderPainted(false);
		rollButton.setBounds(80, 32, 115, 50);
		panelGame.add(rollButton);
		
		dice1Button = new JButton();
		dice1Button.setBorderPainted(false);
		dice1Button.setIcon(new ImageIcon("Resourses/RollDice.jpg"));
		dice1Button.setBounds(84, 130, 100, 100);
		panelGame.add(dice1Button);
		
		dice2Button = new JButton();
		dice2Button.setBorderPainted(false);
		dice2Button.setIcon(new ImageIcon("Resourses/RollDice.jpg"));
		dice2Button.setBounds(84, 243, 100, 100);
		panelGame.add(dice2Button);
		
		dice3Button = new JButton();
		dice3Button.setBorderPainted(false);
		dice3Button.setIcon(new ImageIcon("Resourses/RollDice.jpg"));
		dice3Button.setBounds(84, 356, 100, 100);
		panelGame.add(dice3Button);
		
		dice4Button = new JButton();
		dice4Button.setBorderPainted(false);
		dice4Button.setIcon(new ImageIcon("Resourses/RollDice.jpg"));
		dice4Button.setBounds(84, 469, 100, 100);
		panelGame.add(dice4Button);
		
		dice5Button = new JButton();
		dice5Button.setBorderPainted(false);
		dice5Button.setIcon(new ImageIcon("Resourses/RollDice.jpg"));
		dice5Button.setBounds(84, 582, 100, 100);
		panelGame.add(dice5Button);
		
		diceButton[0] = dice1Button;
		diceButton[1] = dice2Button;
		diceButton[2] = dice3Button;
		diceButton[3] = dice4Button;
		diceButton[4] = dice5Button;
		
		JButton devTeamButton = new JButton("");
		devTeamButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		devTeamButton.setBorderPainted(false);
		devTeamButton.setPressedIcon(new ImageIcon("Resourses/devClick.jpg"));
		devTeamButton.setIcon(new ImageIcon("Resourses/devDefault.jpg"));
		devTeamButton.setBounds(1051, 237, 80, 80);
		panelGame.add(devTeamButton);
		
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
		
		table3 = new JTable();
		table3.setGridColor(Color.BLACK);
		
		table3.setRowHeight(25);
		table3.setCellSelectionEnabled(true);
		table3.setPreferredScrollableViewportSize(new Dimension(850, 800));
		table3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table3.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		table3.setModel(new DefaultTableModel(
			new Object[][] {
				{"ONES", null, null, null, null},
				{"TWOS", null, null, null, null},
				{"THREES", null, null, null, null},
				{"FOURS", null, null, null, null},
				{"FIVES", null, null, null, null},
				{"UPPER SCORE", null, null, null, null},
				{"UPPER BONUS [35]", null, null, null, null},
				{"PAIR", null, null, null, null},
				{"THREE OF A KIND", null, null, null, null},
				{"FOUR OF A KIND", null, null, null, null},
				{"FULL HOUSE [25]", null, null, null, null},
				{"SMALL STRAIGHT [30]", null, null, null, null},
				{"LARGE STRAIGHT[40]", null, null, null, null},
				{"YATZY [50]", null, null, null, null},
				{"CHANCE", null, null, null, null},
				{"LOWER SCORE", null, null, null, null},
				{"TOTAL", null, null, null, null},
			},
			new String[] {
				"    Combinations", player1, player2, player3, player4
			}
		) {
			Class[] columnTypes3 = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass3(int columnIndex3) {
				return columnTypes3[columnIndex3];
			}
	
		});
		table3.getColumnModel().getColumn(0).setPreferredWidth(229);
		table3.getColumnModel().getColumn(1).setPreferredWidth(209);
		table3.getColumnModel().getColumn(2).setPreferredWidth(209);
		table3.getColumnModel().getColumn(3).setPreferredWidth(209);
		table3.getColumnModel().getColumn(4).setPreferredWidth(209);
		table3.setBackground(Color.GRAY);
		
		
		scrollPane3 = new JScrollPane();
		scrollPane3.setForeground(Color.GRAY);
		scrollPane3.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		scrollPane3.setBounds(295, 32, 731, 457);
		scrollPane3.setViewportView(table3);
		panelGame.add(scrollPane3);
		
		
		Yatzy.frame.getContentPane().add(panelGame, "name_531936123301123");
		//Yatzy.frame.getContentPane().add(panelGame);
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
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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


		