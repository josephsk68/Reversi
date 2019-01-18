package cs1302.p2;

/**
 * This class represents a HumanPlayer.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public class HumanPlayer extends Player {
	
	/**
	 * Creates HumanPlayer with desired piece
	 * @param whichPiece identifies the piece, either dark piece "X" or light piece "O".
	 */
	public HumanPlayer(String whichPiece) {
		setWhichPiece(whichPiece);
		setClassName("HumanPlayer");
	} // constructor
	
	public boolean remainingValidMoves() {
		
		boolean hasValidMove = false;
		
		for(int i = 0; i < validMoves.length; i++) {
			for(int j = 0; j < validMoves[i].length; j++) {
				if(validMoves[i][j]) {
					hasValidMove = true;
				}
			}
		}
		return hasValidMove;
	}
	
	/**
	 * Places the player's piece at the specified spot, only if valid.
	 * @param board the board to be referenced with the row/col position
	 */
	public void chooseMove(ReversiBoard board) {
		java.util.Scanner keyboard = new java.util.Scanner(System.in);	
		boolean isValidInput = false;
		String input; // user input
		
		do {System.out.print("Enter your move, " + getWhichPiece() + "player: ");
			input = keyboard.nextLine().trim();
			System.out.println();
			
			if(input.length() == 3 && input.charAt(1) == ' ') { // user input must be 3 in length and one white space in between
				java.util.Scanner keyboard2 = new java.util.Scanner(input);
				
				if(keyboard2.hasNextInt()) {
					int row = keyboard2.nextInt() - 1; // reversi starts at 0
					if(keyboard2.hasNextInt()) {
						int col = keyboard2.nextInt() - 1; // reversi starts at 0
						
						if(row < board.getBoard().length && // input row < board length
								col < board.getBoard()[0].length && // input col < board length
									row >= 0 && col >= 0) { // input row >= 0 and input col >= 0
							
							if(validMoves[row][col]) { // input row and col
 								board.updateBoard(row, col, this); // (row, col, HumanPlayer) piece placed
								board.removeUnderscores();
								isValidInput = true;
							}
						}
					}
				}
			} // format check
			
			if(!isValidInput) {
				System.out.println();
				System.out.println("Please enter a valid move.");
				System.out.println();
				board.printBoard();
			} // prints out this message if user input is invalid
		} while(!isValidInput);
	}
	
}