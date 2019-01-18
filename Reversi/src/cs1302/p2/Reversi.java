package cs1302.p2;

/**
 * This class represents the driver for a Reversi game.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public class Reversi {
	
	public enum GameType {
		HUMAN_VS_HUMAN, 
		HUMAN_VS_RANDOMCOMP,
		RANDOMCOMP_VS_HUMAN, 
		RANDOMCOMP_VS_RANDOMCOMP, 
		RANDOMCOMP_VS_INTELLIGENTCOMP, 
		INTELLIGENTCOMP_VS_INTELLIGENTCOMP, 
		INTELLIGENTCOMP_VS_RANDOMCOMP, 
	} // GameType constants
		
		private GameType type;
		private ReversiBoard board;
		private HumanPlayer human;
		private HumanPlayer human2;
		private RandomComputerPlayer randomComputerP;
		private RandomComputerPlayer randomComputerP2;
		private IntelligentComputerPlayer intelligentComputerP;
		private IntelligentComputerPlayer intelligentComputerP2;

	/**
	 * Creates Reversi game for HumanPlayer vs. HumanPlayer
	 * @param player1 the HumanPlayer type of player1
	 * @param player2 the HumanPlayer type of player2
	 */
	public Reversi(HumanPlayer player1, HumanPlayer player2) {
		type = GameType.HUMAN_VS_HUMAN;
		board = new ReversiBoard();
		human = player1;
		human2 = player2;
		randomComputerP = null;
		randomComputerP2 = null;
		intelligentComputerP = null;
		intelligentComputerP2 = null;
	} // constructor
	
	/**
	 * Creates Reversi game for HumanPlayer vs. RandomComputerPlayer
	 * @param player1 the HumanPlayer type of player1
	 * @param player2 the RandomComputerPlayer type of player2
	 */
	public Reversi(HumanPlayer player1, RandomComputerPlayer player2) {
		type = GameType.HUMAN_VS_RANDOMCOMP;
		board = new ReversiBoard();
		human = player1;
		human2 = null;
		randomComputerP = player2;		
		randomComputerP2 = null;
		intelligentComputerP = null;
		intelligentComputerP2 = null;
	} // constructor
	
	/**
	 * Creates Reversi game for RandomComputerPlayer vs. RandomComputerPlayer
	 * @param player1 the RandomComputerPlayer type of player1
	 * @param player2 the RandomComputerPlayer type of player2
	 */
	public Reversi(RandomComputerPlayer player1, RandomComputerPlayer player2) {
		type = GameType.RANDOMCOMP_VS_RANDOMCOMP;
		board = new ReversiBoard();
		human = null;
		human2 = null;
		randomComputerP = player1;
		randomComputerP2 = player2;		
		intelligentComputerP = null;
		intelligentComputerP2 = null;
	} // constructor
	
	/**
	 * Creates Reversi game for RandomComputerPlayer vs. HumanPlayer
	 * @param player1 the RandomComputerPlayer type of player1
	 * @param player2 the HumanPlayer type of player2
	 */
	public Reversi(RandomComputerPlayer player1, HumanPlayer player2) {
		type = GameType.RANDOMCOMP_VS_HUMAN;
		board = new ReversiBoard();
		human = null;
		human2 = player2;
		randomComputerP = player1;
		randomComputerP2 = null;		
		intelligentComputerP = null;
		intelligentComputerP2 = null;
	} // constructor
	
	
	/**
	 * Creates Reversi game for RandomComputerPlayer vs. IntelligentComputerPlayer
	 * @param player1 the RandomComputerPlayer type of player1
	 * @param player2 the IntelligentComputerPlayer type of player2
	 */
	public Reversi(RandomComputerPlayer player1, IntelligentComputerPlayer player2) {
		type = GameType.RANDOMCOMP_VS_INTELLIGENTCOMP;
		board = new ReversiBoard();
		human = null;
		human2 = null;
		randomComputerP = player1;
		randomComputerP2 = null;
		intelligentComputerP = player2;		
		intelligentComputerP2 = null;
	} //constructor
	
	/**
	 * Creates Reversi game for IntelligentComputerPlayer vs. IntelligentComputerPlayer
	 * @param player1 the IntelligentComputerPlayer type of player1
	 * @param player2 the IntelligentComputerPlayer type of player2
	 */
	public Reversi(IntelligentComputerPlayer player1, IntelligentComputerPlayer player2) {
		type = GameType.INTELLIGENTCOMP_VS_INTELLIGENTCOMP;
		board = new ReversiBoard();
		human = null;
		human2 = null;
		randomComputerP = null;
		randomComputerP2 = null;
		intelligentComputerP = player1;
		intelligentComputerP2 = player2;
	} //constructor
	
	/**
	 * Creates Reversi game for IntelligentComputerPlayer vs. RandomComputerPlayer
	 * @param player1 the IntelligentComputerPlayer type of player1
	 * @param player2 the RandomComputerPlayer type of player2
	 */
	public Reversi(IntelligentComputerPlayer player1, RandomComputerPlayer player2) {
		type = GameType.INTELLIGENTCOMP_VS_RANDOMCOMP;
		board = new ReversiBoard();
		human = null;
		human2 = null;
		randomComputerP = player2;
		randomComputerP2 = null;
		intelligentComputerP = player1;
		intelligentComputerP2 = null;
	} //constructor
	
	/**
	 * Main method
	 * @param args the command line arguments from the user
	 */
	public static void main(String[] args) {
		
		Reversi game = null;
		
		switch (args.length) {
		
		case 2:
			
			if(args[0].equals("Human") && args[1].equals("Human")) {
				game = new Reversi(new HumanPlayer("X "), new HumanPlayer("O ")); // dark piece makes the first move
				break;
			} else if(args[0].equals("Human") && args[1].equals("RandomComputerPlayer")) {
				game = new Reversi(new HumanPlayer("X "), new RandomComputerPlayer("O ")); // dark piece makes the first move
				break;
			} else if(args[0].equals("RandomComputerPlayer") && args[1].equals("RandomComputerPlayer")) {
				game = new Reversi(new RandomComputerPlayer("X "), new RandomComputerPlayer("O ")); // dark piece makes the first move
				break;
			} else if(args[0].equals("RandomComputerPlayer") && args[1].equals("Human")) {
				game = new Reversi(new HumanPlayer("X "), new RandomComputerPlayer("O ")); // dark piece makes the first move
				break;
			} else if(args[0].equals("RandomComputerPlayer") && args[1].equals("IntelligentComputerPlayer")) {
				game = new Reversi(new RandomComputerPlayer("X "), new IntelligentComputerPlayer("O ")); // dark piece makes the first move
				break;
			} else if(args[0].equals("IntelligentComputerPlayer") && args[1].equals("IntelligentComputerPlayer")) {
				game = new Reversi(new IntelligentComputerPlayer("X "), new IntelligentComputerPlayer("O ")); // dark piece makes the first move
				break;
			} else if(args[0].equals("IntelligentComputerPlayer") && args[1].equals("RandomComputerPlayer")) {
				game = new Reversi(new IntelligentComputerPlayer("X "), new RandomComputerPlayer("O ")); // dark piece makes the first move
				break;
			}
		default:
		    System.out.println("Usage: java Reversi [PLAYER 1 TYPE] [PLAYER 2 TYPE]");
		    System.exit(0);
		}
	    game.run();   	
	}

	/**
	 * Runs the game.
	 */
	private void run() {
		Welcome();
		switch (this.type) { // keeps looping until game is over

		case HUMAN_VS_HUMAN: 
			while(true) { // while gameType is set on HUMAN_VS_HUMAN two players of human and human2 take each turn
				this.takeTurn(human);
				determineWinner(human, human2);
				this.takeTurn(human2);
				determineWinner(human, human2); 
			} // each player a takes turn, and then checks to see if there is no spot to place a piece
		case HUMAN_VS_RANDOMCOMP:
			while(true) { // while gameType is set on HUMAN_VS_RANDOMCOMP two players of human and randomComputerP take each turn
				this.takeTurn(human);
				determineWinner(human, randomComputerP);
				this.takeTurn(randomComputerP);
				determineWinner(human, randomComputerP);
			} // each player a takes turn, and then checks to see if there is no spot to place a piece
		case RANDOMCOMP_VS_RANDOMCOMP: 
			while(true) { // while gameType is set on RANDOMCOMP_VS_RANDOMCOMP two players of randomComputerP and randomComputerP2 take each turn
				this.takeTurn(randomComputerP);
				determineWinner(randomComputerP, randomComputerP2);
				this.takeTurn(randomComputerP2);
				determineWinner(randomComputerP, randomComputerP2);
			} // each player a takes turn, and then checks to see if there is no spot to place a piece
		case RANDOMCOMP_VS_HUMAN:
			while(true) { // while gameType is set on RANDOMCOMP_VS_HUMAN two players of randomComputerP and human take each turn
				this.takeTurn(randomComputerP);
				determineWinner(randomComputerP, human);
				this.takeTurn(human);
				determineWinner(randomComputerP, human);
			} // each player a takes turn, and then checks to see if there is no spot to place a piece
		case RANDOMCOMP_VS_INTELLIGENTCOMP:
			while(true) { // while gameType is set on RANDOMCOMP_VS_INTELLIGENTCOMP two players of randomComputerP and intelligentComputerP take each turn				// first  will always take the dark piece "X "
				this.takeTurn(randomComputerP);
				determineWinner(randomComputerP, intelligentComputerP);
				this.takeTurn(intelligentComputerP);
				determineWinner(randomComputerP, intelligentComputerP);
			} // each player a takes turn, and then checks to see if there is no spot to place a piece
		case INTELLIGENTCOMP_VS_INTELLIGENTCOMP: 
			while(true) { // while gameType is set on INTELLIGENTCOMP_VS_INTELLIGENTCOMP two players of intelligentComputerP and intelligentComputerP2 take each turn
				this.takeTurn(intelligentComputerP);
				determineWinner(intelligentComputerP, intelligentComputerP2);
				this.takeTurn(intelligentComputerP2);
				determineWinner(intelligentComputerP, intelligentComputerP2);
			} // each player a takes turn, and then checks to see if there is no spot to place a piece
		case INTELLIGENTCOMP_VS_RANDOMCOMP:
			while(true) { // while gameType is set on INTELLIGENTCOMP_VS_RANDOMCOMP two players of intelligentComputerP and randomComputerP take each turn
				this.takeTurn(intelligentComputerP);
				determineWinner(intelligentComputerP, randomComputerP);
				this.takeTurn(randomComputerP);
				determineWinner(intelligentComputerP, randomComputerP);
			} // each player takes a turn, and then checks to see if there is no spot to place a piece
		}
	}

	/**
	 * Lets each player take a turn.
	 * @param player the player object takes their turn
	 */
	private void takeTurn(Player player) {

		player.setValidMovesArray(board.getValidMoves(player));
		if(!player.remainingValidMoves()) {
			player.setForFeitedTurn(true);
			forfeit(player);
		} else {
			player.setForFeitedTurn(false);
		}
		
		if(!player.getForFeitedTurn()) {
			board.printBoard();
			player.chooseMove(board);
			player.setValidMovesArray(null);
		} 
	}

	/**
	 * Checks and determines if anyone has won the game after each turn.
	 * @param p1 the first player to check
	 * @param p2 the second player to check
	 */
	private void determineWinner(Player p1, Player p2) {
		if((p1.getForFeitedTurn() && p2.getForFeitedTurn()) || board.isFull()) {
			if(board.countNumX() > board.countNumO()) {
				player1Wins();
			} else if(board.countNumO() > board.countNumX()) {
				player2Wins();
			} else {
				tie();
			}
		} // checks if either both players forfeited, or if the board is full
	}
	
	/**
	 * Prints out welcome message.
	 */
	private void Welcome() {
		System.out.println();
		System.out.println("Welcome to Reversi!  Moves should be entered in a \"[row] [column]\" format.");
		System.out.println();
	}
	
	/**
	 * Prints out forfeit message.
	 * @param p the player who is forfeiting
	 */
	private void forfeit(Player p) {
		System.out.println();
		System.out.println(p.getWhichPiece() + "has no valid moves." + " Turn forfeited.");
		System.out.println();
	} 

	/**
	 * Prints out winning message and final score for player1, then ends the game.
	 */
	private void player1Wins() {
		System.out.println();
		System.out.println("X player wins!");
		System.out.println();
		System.out.println("FINAL SCORE: X=" + board.countNumX() + " , O=" + board.countNumO());
		System.out.println();
		board.printBoard();
		System.exit(0);
	}

	/**
	 * Prints out winning message and final score for player2, then ends the game.
	 */
	private void player2Wins() {
		System.out.println();
		System.out.println("O player wins!");
		System.out.println();
		System.out.println("FINAL SCORE: O=" + board.countNumO() + " , X=" + board.countNumX());
		System.out.println();
		board.printBoard();
		System.exit(0);
	}

	/**
	 * Prints out draw message and final score, then ends the game.
	 */
	private void tie() {
		System.out.println();
		System.out.println("It's a draw!");
		System.out.println();
		System.out.println("FINAL SCORE: X=" + board.countNumX() + " , O=" + board.countNumO());
		System.out.println();
		board.printBoard();
		System.exit(0);
	}

}