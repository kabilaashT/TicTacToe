package tictactoe;

import java.util.Scanner;

public class Gameplay{
	private Scanner input;
	private GameBoard board;
	private Player player1;
	private Player player2;
	private String name1, name2;
	private int currentPosition;
	private int depth;
	private char currentLetter;
	private char result;

	public Gameplay (){
		input = new Scanner(System.in);
		board = new GameBoard();
		currentPosition = 0;
		depth = 0;
		currentLetter = 'X';
	}

	public void runGame(){
		System.out.println("Enter player 1 name?");
		name1 = input.nextLine();
		player1 = new Player(name1, 'X', "unknown");

		System.out.println("Enter player 2 name?");
		name2 = input.nextLine();
		player2 = new Player(name2, 'O', "unknown");

		result = board.winner(depth);

		while(result == '?'){

			System.out.println(board.getBoard());

			if(depth % 2 == 0){
				System.out.println("Turn = X");
				System.out.println("Player 1 name:" + player1.getPlayerName());
				currentLetter = 'X';
			}
			else{
				System.out.println("Turn = O");
				System.out.println("Player 2 name:" + player2.getPlayerName());
				currentLetter = 'O';
			}
			System.out.println("Enter Position between 0 and 8:");
			currentPosition = input.nextInt();

			if(board.checkBoard(currentPosition)){
				System.err.println("Illegal Move! Try Again");
			}
			else{
				board.getBoard()[board.getPosToIndex()[currentPosition]] = currentLetter;
				depth++;
			} 
			result = board.winner(depth);
		}
        if(result == 'X'){
        	System.out.println(player1.getPlayerName() + ":Win");
        	System.out.println(player2.getPlayerName() + ":Loss");
        }
        else if(result == 'O'){
        	System.out.println(player1.getPlayerName() + ":Loss");
        	System.out.println(player2.getPlayerName() + ":Win");
        }
        else{
        	System.out.println(player1.getPlayerName() + ":Tie");
        	System.out.println(player2.getPlayerName() + ":Tie");
        }
	}

}