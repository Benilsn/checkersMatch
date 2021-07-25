package main;

import checkers.Board;
import checkers.UI;


public class Play {

	public static void main(String[] args) {
		

		UI ui = new UI();
		Board board = new Board();
		
		ui.initialBoard();
		ui.placePiece(0, 0, "WHITE");
		
		
		ui.showBoard();
	}
}
