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
		int n = 1;
		
		while (true) {
			try {
				
				
				ui.showBoard();
				
				System.out.print(n+" -"+ui.currentTurn(n)+"-");
				System.out.print("\n\nSource: ");
				String source = sc.nextLine().toUpperCase().trim();
				int[] sourcePosition = board.convertPosition(source);
				System.out.print("Target: ");
				String target = sc.nextLine();
				int[] targetPosition = board.convertPosition(target);
				ui.movePiece(sourcePosition, targetPosition, n);
				n = n +1;
				ui.showBoard();
			}
			catch(CheckersException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	
		
		
			
		
			
	
			
	
			
			
			
					
			
//		}
	}
	

}
