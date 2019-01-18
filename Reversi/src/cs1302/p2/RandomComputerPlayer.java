package cs1302.p2;

/**
 * This class represents a RandomComputer.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public class RandomComputerPlayer extends ComputerPlayer {
	
	/**
	 * Creates RandomComputerPlayer with desired piece.
	 * @param whichPiece identifies the piece, either dark piece "X" or light piece "O".
	 */
	public RandomComputerPlayer(String whichPiece) {
		setWhichPiece(whichPiece);
		setClassName("RandomComputerPlayer");
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
	 * Chooses random position from the valid positions contained in the validMoves array and places the computer's piece
	 * at that spot.
	 * @param board the referenced board with the chosen spot.
	 */
	public void chooseMove(ReversiBoard board) {
		
		System.out.print("Enter your move, " + getWhichPiece() + "player: ");
		java.util.Random moveGenerator = new java.util.Random(); // random move generator
		
		int minimumCount = 30; // always bigger than the number of validMoves
		int maximumCount = moveGenerator.nextInt(40) + minimumCount;
		int validMoveCount = 0;
		
		while(validMoveCount <= maximumCount) { // validMoveCount reaches maximumCount before while-loop ends
			for(int i = 0; i < validMoves.length; i++) {
				for(int j = 0; j < validMoves[i].length; j++) {
					if(validMoves[i][j]) {
						validMoveCount++;
						if(validMoveCount == maximumCount) {
							createTimeDelay(2000); // creates delay for 2000 milliseconds for each move
							System.out.print((i+1) + " " + (j+1));
							System.out.println("\n");
							board.updateBoard(i, j, this); // (row, col, RandomComputerPlayer) piece placed
							board.removeUnderscores();
							return;
						}
					}
				}
			}
		}
	}	
}