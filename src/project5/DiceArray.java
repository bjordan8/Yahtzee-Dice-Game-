package project5;
/**
 * <p>Title: Project 5: Yahtzee</p>
 * 
 * <p>Description: The class contains two instance variables used to store dice values and user decision about dice. Allows user 
 * to access, change, request data from the class to help simulate a dice game of dice. </p>
 * 
 * @author <Brian Jordan>
 *
 */
public class DiceArray {
	private int diceValues[]; // Stores the possible face values of the dice
	private char diceKept[]; //Stores which dice are kept
/**
 * DiceArray
 * Constructor that allows how many dice to be used and sets user choice of kept dice to zero	
 * @param howManyDice allows to pick how many dice the user wants to use
 */
public DiceArray(int howManyDice) {
	diceValues = new int [howManyDice];
	for (int fill = 0; fill < diceValues.length; fill++)
		diceValues[fill] = 0;
	diceKept = new char [howManyDice];
	for (int set = 0; set < diceKept.length; set++)
		diceKept[set] = 'R';
}
/**
 * toString creates and returns a String of the instance variables values
 * @return a reference to a string that contains the values of the dice and the users decision to keep or roll for each die
 */
public String toString() {
	String words = diceValues[0] + " ";
	String choice = diceKept[0] + " ";
	for (int print = 1; print < diceValues.length; print++) {
		words += diceValues[print] + " ";
		choice += diceKept[print] + " ";
	}
	return words + "\n" +choice;
}

/**
 * roll checks the diceKept array to see which dice is set to roll
 * if the dice is set to R or r then roll will change the value for the instance variable.
 * Any other value will keep the value for the die
 */
public void roll() {
	for (int change = 0; change < diceValues.length; change++) {
		if ((diceKept[change] == 'R') || (diceKept[change] == 'r'))
			diceValues[change] = (int)(Math.random() * 6 + 1 );
	}
}
/**
 * getDice - an accessor method for the diceValues array
 * @return the instance variables of the diceValues array
 */
public int[] getDice() {
	return diceValues;
}
/**
 * reset sets all dice to roll for the next turn by changing all
 * elements in the diceKept array to R
 */
public void reset() {
	for (int restart = 0; restart < diceKept.length; restart++)
		diceKept[restart] = 'R';
}
/**
 * keep allows the user to choose which dice to keep before rolling the dice for the next turn
 * the parameter is stored in an instance variable and used to change the diceKept array
 * @param theChoices is an instance variable from the user which is used to change the values of diceKept
 */
public void keep(char theChoices[]) {
	diceKept = theChoices;
}
/**
 * calculateTotal lets the user choose which die value they want to add up. It then checks
 * the values of the instance variable to add up the user's choice, returns the sum
 * @param die is a reference to an instance variable which contains the user's choice
 * @return the sum
 */
public int calculateTotal(int die) {
	int sum = 0;
	for (int count = 0; count < diceValues.length; count++) {
		if (diceValues[count] == die)
			sum += diceValues[count];
	}
	return sum;
}



}
