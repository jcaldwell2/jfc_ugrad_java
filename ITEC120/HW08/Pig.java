/**
 * Pig.java - plays the dice game Pig. 
 *
 * @author  Jeff Pittges
 * @version	23-Oct-2013
 */
import java.util.Scanner;
public class Pig
{
	final private int HOLD = 0;
	final private int ROLL = 1; 
	final private int BUST = 1;

	final private int WINNING_SCORE = 30;

	final private String MENU = "\n0. Hold"
						      + "\n1. Roll \n";

	private Die die; 
	private Scanner scan; 

	public Pig()
	{
		this.die = new Die();
		this.scan = new Scanner(System.in);
	}

	private Player getPlayer()
	{
		String name = "";
		System.out.print("Enter the name of the player: ");
		name = this.scan.nextLine();
		Player player = new Player(name);
		System.out.println(); 
		return player;
	}

	private int getUserChoice()
	{
		int choice = -1; 
		while (choice < HOLD || choice > ROLL)
		{
			System.out.println(MENU);
			System.out.print("Enter choice: ");
			choice = scan.nextInt();
			System.out.println(); 

			if (choice < HOLD || choice > ROLL)
				System.out.println("Invalid choice\n");
		}
		return choice;
	}

	private void takeTurn(Player player1, Player player2, Player player)
	{
		int turnTotal = 0;
		boolean done = false;

		while (!done)
		{
			System.out.println(player1 + "    " + player2 + "\n");
			this.die.roll();
			System.out.print(player.getName() + " rolled: " + this.die.getValue());		

			if (die.getValue() == BUST)
			{
				System.out.println("  ***** Busted! *****\n");

				turnTotal = 0;
				done = true; 
			}
			else
			{
				turnTotal += die.getValue();
				System.out.println("    turn total: " + turnTotal);
			
				if (getUserChoice() == HOLD)
					done = true; 
			}
		}
		player.addToScore(turnTotal);
	}

	public void play()
	{
		System.out.println();

		Player currentPlayer = null;
		Player player1 = this.getPlayer();
		Player player2 = this.getPlayer();

		int turn = 1;
		boolean done = false;
		while (!done)
		{
			if (turn % 2 == 1)
				currentPlayer = player1;
			else
				currentPlayer = player2;
				
			this.takeTurn(player1, player2, currentPlayer);
			if (currentPlayer.getScore() >= WINNING_SCORE)
			{
				System.out.println(currentPlayer.getName() + " Wins!\n");
				done = true;
			}

			++turn;
		}

		System.out.println(player1 + "    " + player2);
	}
}


