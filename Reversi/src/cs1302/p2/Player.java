package cs1302.p2;

/**
 * This class represents a Player.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public abstract class Player {
	
	protected boolean[][] validMoves; // row and column by user input entered in a [row] [column] format are stored
	private boolean forFeitedTurn = false; // if false, not forfeited
	
	private String whichPiece = "";
	private String className = "";
	
	/**
	 * Chooses where to place a piece
	 * @param board the board to be referenced with a row/col position
	 */
	public abstract void chooseMove(ReversiBoard board); // abstract method
	
	/**
	 * Checks and determines if player has any remaining moves.
	 * @return true if player has a valid move remaining
	 */
	public abstract boolean remainingValidMoves();  // abstract method

	/**
	 * Gets validMoves array
	 * @return boolean[][] the validMoves array
	 */
	public boolean[][] getValidMovesArray() {
		return this.validMoves;
	} // getter
	
	/**
	 * Sets validMoves array.
	 */
	public void setValidMovesArray(boolean[][] moves) {
		this.validMoves = moves;
	} // setter
	
	/**
	 * Gets forFeitedTurn field.
	 * @return boolean the forFeitedTurn field
	 */
	public boolean getForFeitedTurn() {
		return this.forFeitedTurn;
	} // getter	
	
	/**
	 * Sets forFeitedTurn field.
	 * @param value the true/false value assigned to the forFeitedTurn field
	 */
	public void setForFeitedTurn(boolean value) {
		this.forFeitedTurn = value;
	} // setter
	
	/**
	 * Gets whichPiece field.
	 * @return String the pieceIdentifier field
	 */
	public String getWhichPiece() {
		return this.whichPiece;
	} // getter
	
	/**
	 * Sets the whichPiece field.
	 * @param whichPiece the identifier of the piece, either dark "X " or light "O ". dark piece goes first.
	 */
	public void setWhichPiece(String whichPiece) {
		if(whichPiece.equals("X ") || whichPiece.equals("O ")) {
			this.whichPiece = whichPiece;
		}
	} // setter
	
	/**
	 * Gets className field
	 */
	public String getClassName() {
		return this.className;
	} // getter
	
	/**
	 * Sets the className field
	 * @param name the name of the class
	 */
	public void setClassName(String name) {
		this.className = name;
	} // setter
	
}