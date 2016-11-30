package classes;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
//import java.util.ArrayList;

@SuppressWarnings("serial")
public class GameBoard extends JFrame implements ActionListener, MouseListener{

	//private final int nameCount = 5;
	private static final int SIZE =5;
	private Dice[] diceArray;
	private int value;
	//private ArrayList<Integer> diceValueHolder;
	private int[] diceValueHolder;
	private JPanel panel;
	private JButton rollButton;
	private JButton[] diceButton;
	private JTable table;
	
	
	public GameBoard(/*String gameTitle*/) {
		// TODO Auto-generated constructor stub
		super();
		diceArray = new Dice[SIZE];
		//diceValueHolder=new ArrayList();
		diceValueHolder = new int[SIZE];
		value=0;
		rollButton= new JButton("Roll Dice");
		diceButton= new JButton[SIZE];
		this.setTitle("Yahtzee Game");
		
	}
	
	public void initDefaultGUI()
	{
		String[] col={"Categories","Player1"};
		String[][] data = {{"Ones"," "},
				{"Twos"," "},
				{"Threes"," "},
				{"Fours"," "},
				{"Fives"," "},
				{"Upper Score"," "},
				{"Upper Bonus[35]"," "},
				{"Tree Of Kind"," "},
				{"Four Of Kind"," "},
				{"Full House[25]"," "},
				{"Small Straight[30]"," "},
				{"Large Straight[40]"," "},
				{"Yahtzee[50]"," "},
				{"Chance"," "},
				{"Lower Score"},
				{"Total"," "}

		};
		
		DefaultTableModel tableModel = new DefaultTableModel(data,col);
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		JPanel primary = new JPanel();
		panel = new JPanel();
		JPanel panel1 = new JPanel();
		
		
		panel.add(rollButton);
		createAndRollDice();
		panel1.add(scrollPane);
		
		
		
		
		/*for(int i = 0; i <col.length;i++)
		{
			col[i]=getColums();
		}*/
		
		panel.setPreferredSize(new Dimension(100,200));
		panel.setLayout(new GridLayout(0,1));
		panel1.setPreferredSize(new Dimension(300,300));
		panel1.setLayout(new GridLayout(1,2));
	
		primary.setPreferredSize(new Dimension(600,400));
		primary.setBackground(Color.CYAN);
		primary.add(panel);
		primary.add(panel1);
		
	
		
		
		this.add(primary);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		int counter = 0;
		 
		if(counter >= 2)
		{
			rollButton.disable();
		}
		else
		{
			rollButton.addActionListener(this);
			counter++;
		}

		
		table.addMouseListener(this);
	}
	

	public void createAndRollDice()
	{
		for(int i = 0; i<diceArray.length;i++)
		{
			
			diceArray[i] = new Dice();
			diceButton[i] = new JButton();
			
			value= diceArray[i].getDice();
			diceButton[i].setText(String.valueOf(value));;
			panel.add(diceButton[i]);
			diceValueHolder[i] = value;
			
			//System.out.println(value);
		}
		printOutDiceValueHolder();
		
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
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		int counter=0;
		
		if(e.getSource()==rollButton)
		{
			for(int i = 0; i<diceArray.length;i++)
			{
				diceArray[i] = new Dice();
				value= diceArray[i].getDice();
				diceButton[i].setText(String.valueOf(value));;
				diceValueHolder[i]= value;

			}
			printOutDiceValueHolder();
			counter++;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int value=5;
		if(e.getSource()==table)
		{
			table.setValueAt(value, table.getSelectedRow(), 1);
		}
		
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
