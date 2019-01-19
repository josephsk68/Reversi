# Reversi

Reversi Game

# Reversi Description

Reversi (also known as “Othello”) is a two-player board game that involves strategically placing two-sided pieces on a grid until no more pieces can be placed. Each move made results in one or more pieces getting flipped, changing ownership of those pieces. Your job is to implement this game on the command line, allowing for all different player matchups including human vs. computer, human vs. human, and computer vs. computer. You will implement different levels of computer intelligence. To get a better understanding of the game, play a couple of rounds of reversi. For further reading, see the Wikipedia entry for reversi.
Reversi Overview
	•	The game board is an 8×8 grid.
	•	The two opponents, dark and light, alternate turns.
	•	Game pieces have two sides: dark and light.
	•	Dark makes the first move.
	•	For each turn, the player must place a single piece with their color facing up in an empty cell, so that there exists at least one straight line (horizontal, vertical, or diagonal) between that piece and another piece of the same color, with an unbroken line of the opposing team’s color in-between.
	•	The surrounded pieces of the other color should be flipped, changing ownership from your opponent to you.
	•	One move may create multiple lines, so multiple lines of opposing pieces can be flipped.
	•	If a player cannot make a move, their turn if forfeited.
	•	The game ends when:
	  ◦	Neither player can make a move, or;
	  ◦	The board is full.
	  ◦	Whichever player has more pieces showing their color at the end wins the game. A tie is possible.

# Instruction

command to compile: javac -d cs1302/p2/bin/ cs1302/p2/Reversi.java

command to run: java -cp cs1302/p2/bin/ cs1302.p2.Reversi Human RandomComputerPlayer // for HumanPlayer vs. RandomComputerPlayer

command to run: java -cp cs1302/p2/bin/ cs1302.p2.Reversi RandomComputerPlayer RandomComputerPlayer // for RandomComputerPlayer vs. RandomComputerPlayer

command to run: java -cp cs1302/p2/bin/ cs1302.p2.Reversi Human Human // for HumanPlayer vs. HumanPlayer

command to run: java -cp cs1302/p2/bin/ cs1302.p2.Reversi RandomComputerPlayer Human // for HumanPlayer vs. RandomComputerPlayer

command to run: java -cp cs1302/p2/bin/ cs1302.p2.Reversi RandomComputerPlayer IntelligentComputerPlayer // for RandomComputerPlayer vs. IntelligentComputerPlayer

command to run: java -cp cs1302/p2/bin/ cs1302.p2.Reversi IntelligentComputerPlayer RandomComputerPlayer // for IntelligentComputerPlayer vs. RandomComputerPlayer

command to run: java -cp cs1302/p2/bin/ cs1302.p2.Reversi IntelligentComputerPlayer IntelligentComputerPlayer // for IntelligentComputerPlayer vs. IntelligentComputerPlayer


# Example

	•	Welcome to Reversi!  Moves should be entered in "[row] [column]" format.
	•	  
	•	    1 2 3 4 5 6 7 8
	•	  1 . . . . . . . .
	•	  2 . . . . . . . .
	•	  3 . . . . _ . . .
	•	  4 . . . X O _ . .
	•	  5 . . _ O X . . .
	•	  6 . . . _ . . . .
	•	  7 . . . . . . . .
	•	  8 . . . . . . . .
	•	
	•	Enter your move, X player: 3 5
	•	
	•	    1 2 3 4 5 6 7 8
	•	  1 . . . . . . . .
	•	  2 . . . . . . . .
	•	  3 . . . _ X _ . .
	•	  4 . . . X X . . .
	•	  5 . . . O X _ . .
	•	  6 . . . . . . . .
	•	  7 . . . . . . . .
	•	  8 . . . . . . . .
	•	
	•	Enter your move, O player: 3 4
