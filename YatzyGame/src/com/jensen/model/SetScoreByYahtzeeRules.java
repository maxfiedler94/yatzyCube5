package com.jensen.model;

	import java.util.ArrayList;
	/**
	 * The SetScoreByYahtzeeRules class contains the calculations for the score.
	 *
	 */
	public class SetScoreByYahtzeeRules {

		private ArrayList<Integer> ones = new ArrayList<>();
		private ArrayList<Integer> twos = new ArrayList<>();
		private ArrayList<Integer> threes = new ArrayList<>();
		private ArrayList<Integer> fours = new ArrayList<>();
		private ArrayList<Integer> fives= new ArrayList<>();
		private ArrayList<Integer> sixes = new ArrayList<>();
		private int[] diceArr;
		
		private int selectedCategory;
		/**
		 * The method which sets the score
		 * @param getDiceArray Gets the array with dices
		 * @param category The category of the score
		 */
		public SetScoreByYahtzeeRules(int[] getDiceArray, int category) 
		{
			diceArr = new int[5];
			for(int i =0; i<diceArr.length;i++)
			{
				diceArr[i] = getDiceArray[i];
			}
			selectedCategory = category+1;
			
			
			for(int i=0;i<diceArr.length;i++)
			{
				if(diceArr[i] == 1)
				{
					ones.add(1);
				}
				if(diceArr[i] == 2)
				{
					twos.add(1);
				}
				if(diceArr[i] == 3)
				{
					threes.add(1);
				}
				if(diceArr[i] == 4)
				{
					fours.add(1);
				}
				if(diceArr[i] == 5)
				{
					fives.add(1);
				}
				if(diceArr[i] == 6)
				{
					sixes.add(1);
				}
			}
			
		}
		/**
		 * Method to set the upper score
		 * @return returns the set value
		 */
		public int upperScoreSet()
		{	
			int setValue = 0;
			
			for(int upperScore = 1; upperScore <= 6;upperScore++)
			{
				if(selectedCategory == upperScore)
				{	
					for(int i = 0; i<5;i++)
					{
						if(diceArr[i] == upperScore)
						{
							setValue += diceArr[i];
						}
					}
				}
			}
		
			return setValue;
		}
		
		public void scoreForOTTFFS()
		{		
			/*
			if(selectedCategory == 1)
			{	
				if(diceArr[value] == 1)
				{
					setValue += diceArr[value];
				}
			}
			
			if(selectedCategory == 2)
			{
				if(diceArr[value] == 2)
				{
					setValue += diceArr[value];
				}
			}
			
			if(selectedCategory == 3)
			{
				if(diceArr[value] == 3)
				{
					setValue += diceArr[value];
				}
			}
			
			if(selectedCategory == 4)
			{
				if(diceArr[value] == 4)
				{
					setValue += diceArr[value];
				}
			}
			
			if(selectedCategory == 5)
			{
				if(diceArr[value] == 5)
				{
					setValue += diceArr[value];
				}
			}
			
			if(selectedCategory == 6)
			{
				if(diceArr[value] == 6)
				{
					setValue += diceArr[value];
				}
			}*/
		}
		
	/*	
		public int twos()
		{
			int onesValue = 0;
			
			for(int i=0;i<diceArr.length;i++)
			{
				if(diceArr[i] == 2)
				{
					onesValue+=diceArr[i];
				}
			}
		
			return onesValue;
		}
		
		public int threes()
		{
			int onesValue = 0;
			
			for(int i=0;i<diceArr.length;i++)
			{
				if(diceArr[i] == 3)
				{
					onesValue+=diceArr[i];
				}
			}
		
			return onesValue;
		}
		
		public int fours()
		{
			int onesValue = 0;
			
			for(int i=0;i<diceArr.length;i++)
			{
				if(diceArr[i] == 4)
				{
					onesValue+=diceArr[i];
				}
			}
		
			return onesValue;
		}
		
		public int fives()
		{
			int onesValue = 0;
			
			for(int i=0;i<diceArr.length;i++)
			{
				if(diceArr[i] == 5)
				{
					onesValue+=diceArr[i];
				}
			}
		
			return onesValue;
		}
		
		public int sixes()
		{
			int onesValue = 0;
			
			for(int i=0;i<diceArr.length;i++)
			{
				if(diceArr[i] == 6)
				{
					onesValue+=diceArr[i];
				}
			}
		
			return onesValue;
		}
		*/
		
		/**
		 * Score calculation for pair
		 * @return the value of the dice
		 */
		public int pair()
		{
			int returnScore = 0;
			
			if(ones.size() >= 2)
			{
				returnScore = 2;
			}
			if(twos.size() >= 2)
			{
				returnScore = 4;
			}
			if(threes.size() >= 2)
			{
				returnScore = 6;
			}
			if(fours.size() >= 2)
			{
				returnScore = 8;
			}
			if(fives.size() >= 2)
			{
				returnScore = 10;
			}
			if(sixes.size() >= 2)
			{
				returnScore = 12;
			}
				


			return returnScore;
		}
		/**
		 * Score calculation for two pair
		 * @return the value of the dice
		 */
		public int twoPair()
		{
			int returnScore = 0;
			
			//One Comb
			if(ones.size() >= 2 && twos.size() >= 2)
			{
				returnScore = 6;
			}
			
			if(threes.size() >= 2 && ones.size() >= 2)
			{
				returnScore = 8;
			}
			
			if(fours.size() >= 2 && ones.size() >= 2 || threes.size() >= 2 && twos.size() >= 2)
			{
				returnScore = 10;
			}
			
			if(fives.size() >= 2 && ones.size() >= 2 || fours.size() >= 2 && twos.size() >= 2)
			{
				returnScore = 12;
			}
			
			//Twos comb
			if(fives.size() >= 2 && twos.size() >= 2 || fours.size() >= 2 && threes.size() >= 2 || sixes.size() >= 2 && ones.size() >= 2)
			{
				returnScore = 14;
			}
			
			if(sixes.size() >= 2 && twos.size() >= 2 || fives.size() >= 2 && threes.size() >= 2)
			{
				returnScore = 16;
			}
			
			//Three Comb
			if(sixes.size() >= 2 && threes.size() >= 2 || fives.size() >= 2 && fours.size() >= 2)
			{
				returnScore = 18;
			}
			
			//four Comb
			if(sixes.size() >= 2 && fours.size() >= 2)
			{
				returnScore = 20;
			}
			
			//Fives combo
			if(sixes.size() >= 2 && fives.size() >= 2)
			{
				returnScore = 22;
			}
				

			return returnScore;
		}
		/**
		 * Score calculation for three of a kind
		 * @return the value of the dice
		 */
		
		public int threeOfKind()
		{
			//int checkValue = 0;
			int returnScore = 0;
			/*if(specialCatagory())
			{*/
				if(ones.size() >= 3)
				{
					returnScore = 3;
				}
				if(twos.size() >= 3)
				{
					returnScore = 6;
				}
				if(threes.size() >= 3)
				{
					returnScore = 9;
				}
				if(fours.size() >= 3)
				{
					returnScore = 12;
				}
				if(fives.size() >= 3)
				{
					returnScore = 15;
				}
				if(sixes.size() >= 3)
				{
					returnScore = 18;
				}
					
			//}
		
			return returnScore;
		}
		/**
		 * Score calculation for four of a kind
		 * @return the value of the dice
		 */
		
		public int fourOfKind()
		{
			//int checkValue = 0;
			int returnScore = 0;
			/*if(specialCatagory())
			{*/
				if(ones.size() >= 4)
				{
					returnScore = 4;
				}
				if(twos.size() >= 4)
				{
					returnScore = 8;
				}
				if(threes.size() >= 4)
				{
					returnScore = 12;
				}
				if(fours.size() >= 4)
				{
					returnScore = 16;
				}
				if(fives.size() >= 4)
				{
					returnScore = 20;
				}
				if(sixes.size() >= 4)
				{
					returnScore = 24;
				}
			/*}*/
		
			return returnScore;
		}
		/**
		 * Score calculation for full house
		 * @return the value of the dice
		 */
		public int fullHouse()
		{
			int returnScore=0;
			if(specialCatagory())
			{
				for(int i = 0; i <diceArr.length; i++)
				{
					returnScore += diceArr[i];
				}
			}
			
			return returnScore;
		}
		/**
		 * Score calculation for small straight
		 * @return the value of the dice
		 */
		
		public int smallStraight()
		{
			int returnScore=0;
			if(specialCatagory())
			{
				returnScore = 15;
			}
			
			return returnScore;
		}
		/**
		 * Score calculation for large straight
		 * @return the value of the dice
		 */
		public int largeStraight()
		{
			int returnScore=0;
			if(specialCatagory())
			{
				returnScore = 20;
			}
			
			return returnScore;
		}
		/**
		 * Score calculation for yahtzee
		 * @return the value of the dice
		 */
		public int yahtzee()
		{
			int returnScore=0;
			if(specialCatagory())
			{
				returnScore = 50;
			}
			
			return returnScore;
		}
		/**
		 * Score calculation chance
		 * @return the value of the dice
		 */
		
		public int chance()
		{
			int returnScore=0;
			for(int i=0;i<diceArr.length;i++)
			{
				returnScore += diceArr[i];
			}
			return returnScore;
		}
		/**
		 * ????
		 * @return
		 */
		
		private boolean specialCatagory() {
			// TODO Auto-generated method stub
			boolean isTrue = false;
					
			
			if(selectedCategory == 11)
			{
				if(ones.size() >= 3 || twos.size() >= 3 || threes.size() >= 3 || fours.size() >= 3 || fives.size() >= 3 || sixes.size() >= 3)
				{
					isTrue = true;
				}
			}
			
			if(selectedCategory == 12)
			{
				if(ones.size() >= 4 || twos.size() >= 4 || threes.size() >= 4 || fours.size() >= 4 || fives.size() >= 4 || sixes.size() >= 4)
				{
					isTrue = true;
				}
			}
			
			if(selectedCategory == 13)
			{
				if(ones.size() == 3 || twos.size() == 3 || threes.size() == 3 || fours.size() == 3 || fives.size() == 3 || sixes.size() == 3)
				{
					if(ones.size() == 2 || twos.size() == 2 || threes.size() == 2 || fours.size() == 2 || fives.size() == 2 || sixes.size() == 2)
					{
						isTrue = true;
					}
				}
			}
			
			if(selectedCategory == 14)
			{
				if(ones.size() >= 1 && twos.size() >= 1 && threes.size() >= 1 && fours.size() >= 1 && fives.size() >= 1)
				{
					isTrue = true;
				}
				/*else if(twos.size() >= 1 && threes.size() >= 1 && fours.size() >= 1 && fives.size() >= 1)
				{
					isTrue = true;
				}
				else 
				{
					if(threes.size() >= 1 && fours.size() >= 1 && fives.size() >= 1 && sixes.size() >= 1)
					{
						isTrue = true;
					}
				}*/
			}
			
			if(selectedCategory == 15)
			{
				if(ones.size() == 1 && twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1)
				{
					isTrue = true;
				}
				/*else
				{
					if(twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1 && sixes.size() == 1)
					{
						isTrue = true;
					}
				}*/
			}
			
			if(selectedCategory == 17)
			{
				if(ones.size() == 5 || twos.size() == 5 || threes.size() == 5 || fours.size() == 5 || fives.size() == 5 || sixes.size() == 5)
				{
					isTrue = true;
				}
			}
			
				
			return isTrue;
		}
		
	}



