package main;

import java.util.Scanner;

import checkers.Board;
import checkers.CheckersException;
import checkers.UI;


public class Play {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Board board = new Board();
		UI ui = new UI();
		ui.initialBoard();
		int n = 0;	

		
		while (true) {
			try {
			n = n +1;
			ui.showBoard();
				System.out.print("\nCurrent turn: "+n+" -"+ui.currentTurn(n)+"-");
			System.out.print("\n\nSource: ");
				String source = sc.nextLine().toUpperCase().trim();
				int[] sourcePosition = board.convertPosition(source);
				System.out.print("Target: ");
				String target = sc.nextLine().toUpperCase().trim();;
				int[] targetPosition = board.convertPosition(target);
				ui.movePiece(sourcePosition, targetPosition, n);

			}
			catch(CheckersException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}


