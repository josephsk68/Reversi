package cs1302.p2;

/**
 * This class represents a IntelligentComputerPlayer.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public class IntelligentComputerPlayer extends ComputerPlayer {

	protected static int[][] pointsForEachMove;
	protected static boolean intelligentCompPlay = false; // for skipping updating pieces to count points
	
	/**
	 * Creates IntelligentComputer with desired piece
	 * @param whichPiece identifies the piece, either dark piece "X" or light piece "O".
	 */
	public IntelligentComputerPlayer(String whichPiece) {
		setWhichPiece(whichPiece);
		setClassName("IntelligentComputerPlayer");
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
	 * Chooses best spot that are valid and places the computer's piece at that spot.
	 * @param board the board to be referenced with the chosen spot
	 */
	public void chooseMove(ReversiBoard board) {
		
		System.out.print("Enter your move, " + getWhichPiece() + "player: ");
		possibleMoves(board);
		determineBestMove(board);
	}
	
	/**
	 * Uses the updateBoard method to update the pointsForEachMove array with the values for each potential valid move
	 * @param board the board to be referenced 
	 */
	private void possibleMoves(ReversiBoard board) {
		
		pointsForEachMove = new int[board.getBoard().length][board.getBoard()[0].length];
		// possible flips stored
		for(int r=0; r<board.getBoard().length; r++) {
			for(int c=0; c<board.getBoard()[r].length; c++) {
				intelligentCompPlay = true; // skips updating the pieces 
				board.updateBoard(r, c, this); // updates an array of points for each possible flip
			}
		}
		board.removeUnderscores();
		intelligentCompPlay = false;
	}
	
	/**
	 * Chooses the highest point move from the valid moves. If there is more than one highest moves, then one of them 
	 * will be chosen randomly and then places the piece at the chosen spot.
	 * @param board the board to be referenced
	 */
	private void determineBestMove(ReversiBoard board) {
		// similar to chooseMove method from RandomComputerPlayer class, but chooses the highest point move
		int oldIntelligentComp = 0;
		int rowForIntelligentComp = 0;
		int colForIntelligentComp = 0;
		
		for(int i=0; i<board.getBoard().length; i++) {
			for(int j=0; j<board.getBoard()[i].length; j++) {
				
				if(pointsForEachMove[i][j] >= oldIntelligentComp) {
					oldIntelligentComp=pointsForEachMove[i][j];
					rowForIntelligentComp=i;
					colForIntelligentComp=j;
				}
			}
		}
		java.util.Random numGen = new java.util.Random(); // random move generator
		
		int minimumCount = 30;
		int maximumCount = numGen.nextInt(40) + minimumCount;
		int highestPointCount = 0; // if there is more than one highest possible score for a move, then one of them is chosen randomly
		
		while(highestPointCount <= maximumCount) {
			for(int i=0; i<board.getBoard().length; i++) {
				for(int j=0; j<board.getBoard()[i].length; j++) {
					if(pointsForEachMove[i][j]==pointsForEachMove[rowForIntelligentComp][colForIntelligentComp]) { // find the tie of the highest possible point
						highestPointCount++;
						if(highestPointCount == maximumCount) {
							createTimeDelay(2000); // creates delay for 2000 milliseconds for each move
							System.out.print((i+1) + " " + (j+1));
							System.out.println("\n");
							board.updateBoard(i, j, this); // (row, col, IntelligentComputerPlayer) piece placed
						}
					}
				}
			}
		}
	}	
}
