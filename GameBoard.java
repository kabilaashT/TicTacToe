package tictactoe;

public class GameBoard{

	private static char board[] = {'0','|','1','|','2','\n','-','+','-','+','-','\n','3','|','4','|','5','\n','-','+','-','+','-','\n','6','|','7','|','8','\n'};
    private static int posToIndex[] = { 0, 2, 4, 12, 14, 16, 24, 26, 28 };

    public static boolean checkBoard(int Position) {
    if (
      board[posToIndex[Position]] == 'X' ||
      board[posToIndex[Position]] == 'O'
    ) {
      return true;
    }
    return false;
  }

  public static char winner(int depth) {

    char winner = '?';
    for (int i = 0; i < 3; i++){
      if (board[posToIndex[i]] == board[posToIndex[i+3]] && board[posToIndex[i+3]]== board[posToIndex[i+6]]) {
        winner = board[posToIndex[i]];
        break;
      }
    }
    if(winner == '?'){
      if (board[posToIndex[0]] == board[posToIndex[4]] && board[posToIndex[4]] == board[posToIndex[8]]) winner = board[posToIndex[0]];
      if (board[posToIndex[2]] == board[posToIndex[4]] && board[posToIndex[4]] == board[posToIndex[6]]) winner = board[posToIndex[2]];
    }

    if(winner == '?'){
      for (int i = 0; i <= 6; i+=3){
        if (board[posToIndex[i]] == board[posToIndex[i+1]] && board[posToIndex[i+1]] == board[posToIndex[i+2]]) {
          winner = board[posToIndex[i]];
          break;
        }
      }
    }
    if (winner != '?'){
    	System.out.println(board);
        System.out.println("The winner is " + winner);
        return winner;
    } 
    if (depth == 9) {
      System.out.println("The Game was a Tie!");
      return 'T';
    }
  return '?';
}

public static char[]getBoard(){
	return board;
}

public static int[]getPosToIndex(){
	return posToIndex;
}


}