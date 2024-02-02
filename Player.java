package tictactoe;

public class Player{

	private String playerName;
	private char letter;
	private String result;

	public Player(String playerName, char letter, String result){
		this.playerName = playerName;
		this.letter = letter;
		this.result = result;
	}

	public String getPlayerName(){
		return this.playerName;
	}

	public void setPlayerName(String name){
		this.playerName = name;
	}

	public char getLetter(){
		return this.letter;
	}

	public void setLetter(char sign){
		this.letter = sign;
	}

	public String getResult(){
		return this.result;
	}

	public void setresult(String outcome){
		this.result = outcome;
	}
}