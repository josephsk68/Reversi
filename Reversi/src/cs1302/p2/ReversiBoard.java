package cs1302.p2;

/**
 * This class represents a ReversiBoard.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public class ReversiBoard extends Board {
	
		private final int row = 8;
		private final int col = 8;
		private String [][] board = new String[row][col];
		// board size is set to 8x8
		
		public ReversiBoard() {
			for(int i = 0; i < row; i++) { // row = 8
				for(int j = 0; j < col; j++) { // col = 8
					board[i][j] = ". ";
				}
			}
			board[3][3] = "X ";
			board[4][4] = "X ";
			board[3][4] = "O ";
			board[4][3] = "O ";
		} // initial board set up
			
		public void printBoard() {
			for(int i = 0; i < row; i++) { // row = 8
				if(i == 0) { // only for the first row
					for(int k = 0; k < row; k++ ) { // row = 8
						if(k == 0) {
							System.out.print("    " + (k + 1)); // indentation
							} else {
							System.out.print(" " + (k + 1)); // k = " "1" "2" "3" "4" "5" "6" "7" "8
							}
						}
					System.out.println(); // next line at the end of the row
					}
				System.out.print("  " + (i + 1) + " "); // "  "1" "
				for(int j = 0; j < col; j++) { // col = 8
					System.out.print(board[i][j]); // board[". "][". "]
					}
					System.out.println(); // next line at the end of the row
					}
			System.out.println();
		} // generates a Reversi game board
		
		public void updateBoard(int r, int c, Player p) { // r = row, c = col, p = player
			
			String opponentPiece = "";
			String playerPiece = "";
			
			if(p.getWhichPiece().equals("X ")) { // checks and sees if player p's piece is dark
				opponentPiece = "O "; // if dark, opponent's piece is light
				playerPiece = "X ";
				} else { // vice versa
					opponentPiece = "X ";
					playerPiece = "O ";
					}
			
			int intelligentPieces = 0; // number of intelligent computer's piece
			int locatePiece = 0;
			
			if(board[r][c].equals("_ ") || p.getValidMovesArray()[r][c]) { 
				if(!IntelligentComputerPlayer.intelligentCompPlay) {
					board[r][c]=playerPiece;
				}
				locatePiece = 1; // piece located
			}
	
			if(locatePiece == 1) { // if a piece is located, checks to 8 different directions adjacently to that piece
			
				int checkPiece = 0;
				int checkStop = 1;
				int wrongPiece = 0;
				int checkFlipPieces = 0;
				int wrongDirectionPiece = 0; 
				int checkSkip = 0;
				for(int i=c+1; i<col; i++) {	// checks to the right horizontally
					if(!board[r][i].equals(opponentPiece)) {
						checkSkip=1; // skips the check because flips are not available
					}
					if(board[r][i].equals(opponentPiece) && checkSkip==0) {
						if(checkStop==1) {
							for(int j=i; j<col; j++) {
								if(board[r][j].equals(opponentPiece)) {
									checkPiece=1; // possibly a valid direction to flip pieces
									wrongDirectionPiece++; // reiterates the amount of pieces to flip
									continue;
								}
								if(board[r][j].equals(". ") || board[r][j].equals("_ ") || (j==col-1 && board[r][j].equals(opponentPiece))){							
									wrongPiece=1; // makes sure not to flip wrong pieces
									wrongDirectionPiece=0; // remove all the pieces in invalid directions
								}
								if(board[r][j].equals(playerPiece) && checkPiece==1 && wrongPiece!=1) {
									checkFlipPieces=1; // verifies it's a valid direction to flip the pieces
									checkStop=0; // stops the checking because the valid flip check is complete
									break;
								}
							}
						} 
						if(checkFlipPieces==1 && board[r][i].equals(opponentPiece) && wrongDirectionPiece>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[r][i]=(playerPiece);
							}
							wrongDirectionPiece--; // stops the pieces from being flipped
							intelligentPieces++; // keep track of the flips to determine move for the intelligent computer
							continue;
						}
						else if(board[r][i].equals(playerPiece)) {
							break;
						}
						
					}
				}
				
				int checkPiece2 = 0;
				int checkStop2 = 1;
				int wrongPiece2 = 0;
				int checkFlipPieces2 = 0;
				int wrongDirectionPiece2 = 0; 
				int checkSkip2 = 0;
				for(int i=c-1; i>=0; i--) { // checks to the left horizontally
					if(!board[r][i].equals(opponentPiece)) {
						checkSkip2=1;
					}
					if(board[r][i].equals(opponentPiece) && checkSkip2==0) {
						if(checkStop2==1) {
							for(int j=i; j>=0; j--) {
								if(board[r][j].equals(opponentPiece)) {
									checkPiece2=1;
									wrongDirectionPiece2++; 
									continue;
								}
								if(board[r][j].equals(". ") || board[r][j].equals("_ ") || (j==0 && board[r][j].equals(opponentPiece))){
									wrongPiece2=1;
									wrongDirectionPiece2=0;
									break;
								}
								if(board[r][j].equals(playerPiece) && checkPiece2==1 && wrongPiece2!=1) {
									checkFlipPieces2=1;
									checkStop2=0;
									break;
								}
							}
						}
						if(checkFlipPieces2==1 && board[r][i].equals(opponentPiece) && wrongDirectionPiece2>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[r][i]=(playerPiece);
							}
							wrongDirectionPiece2--;
							intelligentPieces++;
							continue;
						}
						else if(board[r][i].equals(playerPiece)) {
							break;
						}			
					}			
				}
				
				int checkPiece3 = 0;
				int checkStop3 = 1;
				int wrongPiece3 = 0;
				int checkFlipPieces3 = 0;
				int wrongDirectionPiece3 = 0; 
				int checkSkip3 = 0;
				for(int i=r+1; i<row; i++) {	// checks to down vertically
					if(!board[i][c].equals(opponentPiece)) {
						checkSkip3=1;
					}
					if(board[i][c].equals(opponentPiece) && checkSkip3==0) {
						if(checkStop3==1) {
							for(int j=i; j<row; j++) {
								if(board[j][c].equals(opponentPiece)) {
									checkPiece3=1;
									wrongDirectionPiece3++;
									continue;
								}
								if(board[j][c].equals(". ") || board[j][c].equals("_ ") || (j==row-1 && board[j][c].equals(opponentPiece))){
									wrongPiece3=1;
									wrongDirectionPiece3=0;
									break;
								}
								if(board[j][c].equals(playerPiece) && checkPiece3==1 && wrongPiece3!=1) {
									checkFlipPieces3=1;
									checkStop3=0;
									break;
								}
							}
						}
						if(checkFlipPieces3==1 && board[i][c].equals(opponentPiece) && wrongDirectionPiece3>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[i][c]=(playerPiece);
							}
							wrongDirectionPiece3--;
							intelligentPieces++;
							continue;
						}
						else if(board[i][c].equals(playerPiece)) {
							break;
						}			
					}				
				} 
					
				int checkPiece4 = 0;
				int checkStop4 = 1;
				int wrongPiece4 = 0;
				int checkFlipPieces4 = 0;
				int wrongDirectionPiece4 = 0; 
				int checkSkip4 = 0;
				for(int i=r-1; i>=0; i--) { // checks to up vertically
					if(!board[i][c].equals(opponentPiece)) {
						checkSkip4=1;
					}
					if(board[i][c].equals(opponentPiece) && checkSkip4==0) {
						if(checkStop4==1) {
							for(int j=i; j>=0; j--) {
								if(board[j][c].equals(opponentPiece) && wrongPiece4==0) {
									checkPiece4=1;
									wrongDirectionPiece4++;
									continue;
								}
								if((board[j][c].equals(". ") ||  board[j][c].equals("_ ")) || (j==0 && board[j][c].equals(opponentPiece))){
									wrongPiece4=1;
									wrongDirectionPiece4=0;
									break;
								}
								if(board[j][c].equals(playerPiece) && checkPiece4==1 && wrongPiece4!=1) {
									checkFlipPieces4=1;
									checkStop4=0;
									break;
								}
							}
						}
						if(checkFlipPieces4==1 && board[i][c].equals(opponentPiece) && wrongDirectionPiece4>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[i][c]=(playerPiece);
							}
							wrongDirectionPiece4--;
							intelligentPieces++;
							continue;
						}
						else if(board[i][c].equals(playerPiece)) {
							break;
						}				
					}				
				}
			
				int checkPiece5 = 0;
				int checkStop5 = 1;
				int wrongPiece5 = 0;
				int checkFlipPieces5 = 0;
				int wrongDirectionPiece5 = 0; 
				int checkSkip5 = 0;
				for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) { // checks to the upper left diagonally
					if(!board[i][j].equals(opponentPiece)) {
						checkSkip5=1;
					}
					if(board[i][j].equals(opponentPiece) && checkSkip5==0) {
						if(checkStop5==1) {
							for(int k=i, l=j; k>=0 && l>=0; k--, l--) {
								if(board[k][l].equals(opponentPiece)) {
									checkPiece5=1;
									wrongDirectionPiece5++;
									continue;
								}
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==0 && j==0) && board[k][l].equals(opponentPiece))){
									wrongPiece5=1;
									wrongDirectionPiece5=0;
									break;
								}
								if(board[k][l].equals(playerPiece) && checkPiece5==1 && wrongPiece5!=1) {
									checkFlipPieces5=1;
									checkStop5=0;
									break;
								}
							}
						}
						if(checkFlipPieces5==1 && board[i][j].equals(opponentPiece) && wrongDirectionPiece5>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[i][j]=(playerPiece);
							}
							wrongDirectionPiece5--;
							intelligentPieces++;
							continue;
						}
						else if(board[i][j].equals(playerPiece)) {
							break;
						}		
					}				
				}
				
				int checkPiece6 = 0;
				int checkStop6 = 1;
				int wrongPiece6 = 0;
				int checkFlipPieces6 = 0;
				int wrongDirectionPiece6 = 0; 
				int checkSkip6 = 0;
				for(int i=r-1, j=c+1; i>=0 && j<col; i--, j++) {	// checks to the upper right diagonally
					if(!board[i][j].equals(opponentPiece)) {
						checkSkip6=1;
					}
					if(board[i][j].equals(opponentPiece) && checkSkip6==0) {
						if(checkStop6==1) {
							for(int k=i, l=j; k>=0 && l<col; k--, l++) {
								if(board[k][l].equals(opponentPiece)) {
									checkPiece6=1;
									wrongDirectionPiece6++;
									continue;
								}
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==0 && j==col-1) && board[k][l].equals(opponentPiece))){
									wrongPiece6=1;
									wrongDirectionPiece6++;
									break;
								}
								if(board[k][l].equals(playerPiece) && checkPiece6==1 && wrongPiece6!=1) {
									checkFlipPieces6=1;
									checkStop6=0;
									break;
								}
							}
						}
						if(checkFlipPieces6==1 && board[i][j].equals(opponentPiece) && wrongDirectionPiece6>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[i][j]=(playerPiece);
							}
							wrongDirectionPiece6--;
							intelligentPieces++;
							continue;
						}
						else if(board[i][j].equals(playerPiece)) {
							break;
						}			
					}				
				}
				
				int checkPiece7 = 0;
				int checkStop7 = 1;
				int wrongPiece7 = 0;
				int checkFlipPieces7 = 0;
				int wrongDirectionPiece7 = 0; 
				int checkSkip7 = 0;
				for(int i=r+1, j=c+1; i<row && j<col; i++, j++) {	 // checks to the lower right diagonally
					if(!board[i][j].equals(opponentPiece)) {
						checkSkip7=1;
					}
					if(board[i][j].equals(opponentPiece) && checkSkip7==0) {
						if(checkStop7==1) {
							for(int k=i, l=j; k<row && l<col; k++, l++) {
								if(board[k][l].equals(opponentPiece)) {
									checkPiece7=1;
									wrongDirectionPiece7++;
									continue;
								}
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==row-1 && j==col-1) && board[k][l].equals(opponentPiece))){
									wrongPiece7=1;
									wrongDirectionPiece7=0;
									break;
								}
								if(board[k][l].equals(playerPiece) && checkPiece7==1 && wrongPiece7!=1) {
									checkFlipPieces7=1;
									checkStop7=0;
									break;
								}
							}
						}
						if(checkFlipPieces7==1 && board[i][j].equals(opponentPiece) && wrongDirectionPiece7>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[i][j]=(playerPiece);
							}
							wrongDirectionPiece7--;
							intelligentPieces++;
							continue;
						}
						else if(board[i][j].equals(playerPiece)) {
							break;
						}			
					}			
				}
				
				int checkPiece8 = 0;
				int checkStop8 = 1;
				int wrongPiece8 = 0;
				int checkFlipPieces8 = 0;
				int wrongDirectionPiece8 = 0; 
				int checkSkip8 = 0;
				for(int i=r+1, j=c-1; i<row && j>=0; i++, j--) { 	// checks to the lower left diagonally
					if(!board[i][j].equals(opponentPiece)) {
						checkSkip8=1;
					}
					if(board[i][j].equals(opponentPiece) && checkSkip8==0) {
						if(checkStop8==1) {
							for(int k=i, l=j; k<row && l>=0; k++, l--) {
								if(board[k][l].equals(opponentPiece)) {
									checkPiece8=1;
									wrongDirectionPiece8++;
									continue;
								}
								if(board[k][l].equals(". ") || board[k][l].equals("_ ") || ((k==row-1 && j==0) && board[k][l].equals(opponentPiece))){
									wrongPiece8=1;
									wrongDirectionPiece8=0;
									break;
								}
								if(board[k][l].equals(playerPiece) && checkPiece8==1 && wrongPiece8!=1) {
									checkFlipPieces8=1;
									checkStop8=0;
									break;
								}
							}
						} 
						if(checkFlipPieces8==1 && board[i][j].equals(opponentPiece) && wrongDirectionPiece8>0) {
							if(!IntelligentComputerPlayer.intelligentCompPlay) {
								board[i][j]=(playerPiece);
							}
							wrongDirectionPiece8--;
							intelligentPieces++;
							continue;
						}
						else if(board[i][j].equals(playerPiece)) {
							break;
						}		
					}
				}
				
				// stores possible flips for that move into an array for intelligentComputerPlayer
				if(p.getClassName() == "IntelligentComputerPlayer") {
					IntelligentComputerPlayer.pointsForEachMove[r][c]=intelligentPieces; 
					}
				}
			}	
		
		/**
		 * Determines all possible moves for player p and returns an 8x8 boolean array
		 * @param p the player for which all possible moves
		 */
		public boolean[][] getValidMoves(Player p) {
			
			boolean[][] validMoves = new boolean[row][col];
		
			String opponentPiece, playerPiece;
			if(p.getWhichPiece().equals("X ")) {
				opponentPiece = "O ";
				playerPiece = "X ";
			} else {
				opponentPiece = "X ";
				playerPiece = "O ";
			}
			
			for(int r=0; r<row; r++) {
				
				for(int c=0; c<col; c++) {
					
					//Locate the player piece
					int locatePiece=0;
					if(board[r][c].equals(playerPiece)) {
						locatePiece=1;
					} //if
					
					if(locatePiece==1) {
						
						// checks to the right horizontally
						int checkContinued = 1;
						int foundOpponentPiece = 0;
						
						for(int i=c+1; i<col; i++) {
							if(board[r][i].equals(". ") && foundOpponentPiece==0) {
								checkContinued=0;
								break;
							}
							if(board[r][i].equals(opponentPiece) && checkContinued==1) {
								foundOpponentPiece=1;
								continue;
							}
							else if(!board[r][i].equals(opponentPiece) && !board[r][i].equals(". ") && checkContinued==1) {
								break;
							}
							else if(board[r][i].equals(". ") && foundOpponentPiece==1 && checkContinued==1) {
								board[r][i]="_ ";
								validMoves[r][i] = true;
								break;
							}
						}

						// checks to the left horizontally
						int checkContinued2 = 1; 
						int foundOpponentPiece2 = 0;
						
						for(int i=c-1; i>=0; i--) {
							if(board[r][i].equals(". ") && foundOpponentPiece2==0) {
								checkContinued2=0;
								break;
							}
							if(board[r][i].equals(opponentPiece) && checkContinued2==1) {
								foundOpponentPiece2=1;
								continue;
							}
							else if(!board[r][i].equals(opponentPiece) && !board[r][i].equals(". ") && checkContinued2==1) {
								break;
							}
							else if(board[r][i].equals(". ") && foundOpponentPiece2==1 && checkContinued2==1) {
								board[r][i]="_ ";
								validMoves[r][i] = true;
								break;
							}
						}
				
				
						// checks down vertically
						int checkContinued3 = 1;
						int foundOpponentPiece3=0;
						
						for(int i=r+1; i<row; i++) {
							if(board[i][c].equals(". ") && foundOpponentPiece3==0) {
								checkContinued3=0;
								break;
							}
							if(board[i][c].equals(opponentPiece) && checkContinued3==1) {
								foundOpponentPiece3=1;
								continue;
							}
							else if(!board[i][c].equals(opponentPiece) && !board[i][c].equals(". ") && checkContinued3==1) {
									break;
							}
							else if(board[i][c].equals(". ") && foundOpponentPiece3==1 && checkContinued3==1) {
								board[i][c]="_ ";
								validMoves[i][c] = true;
								break;
							}
						}
						
						
						// checks up vertically
						int checkContinued4 = 1;
						int foundOpponentPiece4 = 0;
						
						for(int i=r-1; i>=0; i--) {
							if(board[i][c].equals(". ") && foundOpponentPiece4==0) {
								checkContinued4=0;
								break;
							}
							if(board[i][c].equals(opponentPiece) && checkContinued4==1) {
								foundOpponentPiece4=1;
								continue;
							}
							else if(!board[i][c].equals(opponentPiece) && !board[i][c].equals(". ") && checkContinued4==1) {
								break;
							}
							else if(board[i][c].equals(". ") && foundOpponentPiece4==1 && checkContinued4==1) {
								board[i][c]="_ ";
								validMoves[i][c] = true;
								break;
							}
						}
						
						
						// checks to the upper left diagonally
						int checkContinued5 = 1;
						int foundOpponentPiece5 = 0;
						
						for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--) {
							if(board[i][j].equals(". ") && foundOpponentPiece5==0) {
								checkContinued5=0;
								break;
							}
							else if(board[i][j].equals(opponentPiece) && checkContinued5==1) {
								foundOpponentPiece5=1;
								continue;
							}
							else if(!board[i][j].equals(opponentPiece) && !board[i][j].equals(". ")) {
								break;
							}
							else if(board[i][j].equals(". ") && foundOpponentPiece5==1 ) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							}
						}
						
						// checks to the upper right diagonally
						int checkContinued6 = 1; 
						int foundOpponentPiece6 = 0;
						
						for(int i=r-1, j=c+1; i>=0 && j<col; i--, j++) {
							if(board[i][j].equals(". ") && foundOpponentPiece6==0) {
								checkContinued6=0;
								break;
							}
							if(board[i][j].equals(opponentPiece) && checkContinued6==1) {
								foundOpponentPiece6=1;
								continue;
							}
							else if(!board[i][j].equals(opponentPiece) && !board[i][j].equals(". ")) {
								break;
							}
							else if(board[i][j].equals(". ") && foundOpponentPiece6==1) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							}
						}
									
						// checks to the lower right diagonally
						int checkContinued7 = 1; 
						int foundOpponentPiece7 = 0;
						
						for(int i=r+1, j=c+1; i<row && j<col; i++, j++) {
							if(board[i][j].equals(". ") && foundOpponentPiece7==0) {
								checkContinued7=0;
								break;
							}
							if(board[i][j].equals(opponentPiece) && checkContinued7==1) {
								foundOpponentPiece7=1;
								continue;
							}
							else if(!board[i][j].equals(opponentPiece) && !board[i][j].equals(". ")) {
								break;
							}
							else if(board[i][j].equals(". ") && foundOpponentPiece7==1) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							}
						}
						
						// checks to the lower left diagonally
						int checkContinued8 = 1;
						int foundOpponentPiece8 = 0;

						for(int i=r+1, j=c-1; i<row && j>=0; i++, j--) {
							if(board[i][j].equals(". ") && foundOpponentPiece8==0) {
								checkContinued8=0;
								break;
							}
							if(board[i][j].equals(opponentPiece) && checkContinued8==1) {
								foundOpponentPiece8=1;
								continue;
							}
							else if(!board[i][j].equals(opponentPiece) && !board[i][j].equals(". ")) {
								break;
							}
							else if(board[i][j].equals(". ") && foundOpponentPiece8==1) {
								board[i][j]="_ ";
								validMoves[i][j] = true;
								break;
							}
						}
					}
				}
			}
			return validMoves;
		}
		
		/**
		 * Removes the underscores from the board.
		 */
		public void removeUnderscores() {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(board[i][j] == "_ ") {
						board[i][j] = ". ";
					}
				}
			}
		}
		
		/**
		 * Gets the String board.
		 */
		public String[][] getBoard() {
			return this.board;
		}
		
		/**
		 * Counts the number of dark piece "X " on the game board.
		 * @return the number of dark piece "X "
		 */
		public int countNumX() {
			int numX = 0;
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					if(board[i][j] == "X ") {
						numX++;
					}
				}
			}
			return numX;
		}
		
		/**
		 * Counts the number of light piece "O " on the game board.
		 * @return the number of light piece "O "
		 */
		public int countNumO() {
			int numO = 0;
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					if(board[i][j] == "O ") {
						numO++;
					}
				}
			}
			return numO;
		}
		
		public boolean isFull() {
			return (countNumX() + countNumO()) == board.length*board.length;
		}
		

}