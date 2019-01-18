package cs1302.p2;

/**
 * This class represents a Board.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public abstract class Board {
	
	/**
	 * Prints out board.
	 */
	public abstract void printBoard();
	
	/**
	 * Updates board with new player piece
	 * @param row the row of the board the player's piece was placed on
	 * @param col the col of the board the player's piece was placed on
	 * @param p the type of player placing the piece
	 */
	public abstract void updateBoard(int row, int col, Player p);
	
	/**
	 * Determines whether board is full or not.
	 * @return true if board is full
	 */
	public abstract boolean isFull();
	
}


