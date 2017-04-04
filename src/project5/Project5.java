package project5;
import javax.swing.*;
/**
 *<p>Title: Project 5: yahtzee</p>
 *
 *Descriptions: <p>Used with DiceArray class and GUI class which allows a user to play 6 rounds of yahtzee</p>
 * 
 * @author <Brian Jordan>
 *
 */
public class Project5 {
	
	public static void main(String[] args) {

	GUI theWindow = new GUI(); //creates a GUI to display the dice
	DiceArray theDice = new DiceArray(5); //creates an array to store 5 dice and their values
	String whichDice1; //Used to ask user if they want to keep die 1
	String whichDice2; //Used to ask user if they want to keep die 2
	String whichDice3; //Used to ask user if they want to keep die 3
	String whichDice4; //Used to ask user if they want to keep die 4
	String whichDice5; //Used to ask user if they want to keep die 5
	String record; //Ask the user where they would like to record their score
	String reDo; //Ask the user to resubmit a location to record their score
	String response;  //used to receive answer on which dice to add up
	String answers[];//used to store users choices
	char choices[];// used to convert users choices from string to char
	int score[]; //keeps track of the user's score
	int count = 0; //used to convert string answer to int
	int sum = 0; //used to add score for certain location
	int round = 0; //used to keep track of round
	String roll; //keeps track of roll number
	int total = 0; //stores the final all all six places on the score card
	score = new int [6];
	choices = new char [5];
	answers = new String [5];
	int keepingTrack[] = {0,0,0,0,0,0}; // used to keep track of the locations the user has inputed a sum
	
	for (int fill = 0; fill < score.length; fill++)
		score[fill] = 0;
	for (int i = 0; i < score.length; i++ ) {
		
	//Phase 1 of round 1 (rolls and displays the dice)
		++round;
		roll = JOptionPane.showInputDialog(null, ("Round " + round + "\nRoll 1\nPress OK to roll"));
		theDice.roll();
		theWindow.showDice(theDice);
	
	//Phase 2 of round 1 (ask the user which dice to keep and rolls the others)
		whichDice1 = "Round " + round + ":\nWould you like to keep Die 1?\nEnter \"K\" to keep\nEnter \"R\" to roll";
		whichDice2 = "Round " + round + ":\nWould you like to keep Die 2?\nEnter \"K\" to keep\nEnter \"R\" to roll";
		whichDice3 = "Round " + round + ":\nWould you like to keep Die 3?\nEnter \"K\" to keep\nEnter \"R\" to roll";
		whichDice4 = "Round " + round + ":\nWould you like to keep Die 4?\nEnter \"K\" to keep\nEnter \"R\" to roll";
		whichDice5 = "Round " + round + ":\nWould you like to keep Die 5?\nEnter \"K\" to keep\nEnter \"R\" to roll";
		String questions[] = {whichDice1, whichDice2, whichDice3, whichDice4, whichDice5};
		for (int ask = 0; ask < choices.length; ask++) {
			answers[ask] = JOptionPane.showInputDialog(null, questions[ask]);
			choices[ask] = answers[ask].charAt(0);
		}
		theDice.keep(choices);
		roll = JOptionPane.showInputDialog(null, ("Round " + round + "\nRoll 2\nPress OK to roll"));
		theDice.roll();
		theWindow.showDice(theDice);
	
	//phase 3 of round 1 (ask the user which dice to keep and rolls for a 3rd time)
		for (int ask = 0; ask < choices.length; ask++) {
			answers[ask] = JOptionPane.showInputDialog(null, questions[ask]);
			choices[ask] = answers[ask].charAt(0);
		}
		theDice.keep(choices);
		roll = JOptionPane.showInputDialog(null, ("Round " + round + "\nRoll 2\nPress OK to roll"));
		theDice.roll();
		theWindow.showDice(theDice);
	
	//phase 4 of round 1 (displays score card and ask user where to store value), the resets dice
		record = "End of round, where would you like to record a score?\n(Please enter a number between 1-6 to store in that location)";
		reDo = "Sorry, but you already recorded a score here. Please choose a different location on the scorecard.";
		String scoreCard = "\n"; //used to keep track of users score
		for (int pos = 0; pos < score.length; pos++)
			scoreCard += ((pos + 1) + ": " + score[pos] + "\n");
		response = JOptionPane.showInputDialog(null, (record + scoreCard));
	
	//preventing changing score
		int test = 0; //used to keep track of the current user input to add up sum
		test = Integer.parseInt(response);
		for (int checking = 0; checking < keepingTrack.length; checking++) {
			if (test == keepingTrack[checking]) {
				response = JOptionPane.showInputDialog(null, (scoreCard + reDo));
				count = Integer.parseInt(response);
			}
		}
		keepingTrack[round - 1] = test;
		count = Integer.parseInt(response);
	// adding sum
		sum = theDice.calculateTotal((count));
		score[(count - 1)] = sum;
		scoreCard = "\n"; //
		for (int pos = 0; pos < score.length; pos++)
			scoreCard += ((pos + 1) + ": " + score[pos] + "\n");
		if (i == (score.length - 1)) {
			response = JOptionPane.showInputDialog(null, (scoreCard + "Press OK to see your final score"));
		}
		else if (i < (score.length - 1)) {
			response = JOptionPane.showInputDialog(null, (scoreCard + "Press OK to start the next round"));
		}
		theDice.reset();
		}
		for (int pos = 0; pos < score.length; pos++)
			total += score[pos];
		response = JOptionPane.showInputDialog(null, ("Your final score is " + total));
		}
	}
