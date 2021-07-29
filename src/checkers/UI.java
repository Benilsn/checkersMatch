package checkers;

import java.util.ArrayList;
import java.util.List;

public class UI {


	Board board = new Board();
	Piece piece = new Piece();
	
	int[] capturedPieces = {0, 0};
	
	
	
	
	
	public void initialBoard() {
		for (int r = 0; r < board.getBoard().length;r++) {
			for (int c = 0; c < board.getBoard().length; c++) {
				if (r == 0 && c % 2 != 0 || r == 2 && c % 2 != 0) {
					placePiece(r, c, "BLACK");
				}else if(r == 1 && c % 2 == 0) {
					placePiece(r, c, "BLACK");
				}
				if (r == 5 && c % 2 == 0 || r == 7 && c % 2 == 0) {
					placePiece(r, c, "WHITE");
				}else if(r == 6 && c % 2 != 0) {
					placePiece(r, c, "WHITE");
				}
			}
		}
	}
	
	
	public void showBoard() {
		System.out.println("\n-- BINARY CHECKERS --");
		for (int r = 0; r < board.getBoard().length;r++) {
			System.out.println();
			System.out.print((r + 1) +"   ");
			for (int c = 0; c < board.getBoard().length; c++) {
				if (board.getBoard()[r][c] == null) {
					System.out.print("- ");
				}else {
					System.out.print(board.getBoard()[r][c].getType());
				}
			
			}
		}
		System.out.println("\n");
		System.out.println("    A B C D E F G H");
		
		System.out.println("\n    CAPTURED PIECES: \n   BLACK()    WHITE(1)\n     ["+capturedPieces[0]+"]         ["+capturedPieces[1]+"]");
	}
	
	
	public void placePiece(int row, int column, String color) {
		board.getBoard()[row][column] = new Piece(Color.valueOf(color),new Position(row, column));
	}

	public void movePiece(int[] source, int[] target, int currentTurn) throws CheckersException {
		String turn = "";
		try {
			if (currentTurn % 2 != 0) {
				turn = "WHITE";
			}else if (currentTurn % 2 == 0) {
				turn = "BLACK";	
			}

			if (board.getBoard()[source[1]][source[0]] == null) {
				throw new CheckersException("Invalid position");
			}else if (board.getBoard()[source[1]][source[0]].getType().equals("1 ")) {
				if (turn.equals("WHITE")) {
					if (currentTurn == 1 && source[1] == 5 || source[1] == 6) {
						if (target[1] < source[1]-2 || target[1] >= source[1] || target[0] < source[0] || target[0] > source[0] || target[0] != source[0]) {
							throw new CheckersException("Invalid position");	
						}else{
							board.getBoard()[source[1]][source[0]] = null;
							placePiece(target[1], target[0], "WHITE");
						}
					}else if(currentTurn > 1) {
						if (target[1] < source[1]-1 || target[1] >= source[1] || target[0] > source[0] +1 || target[0] < source[0] -1) {
							throw new CheckersException("invalid position");
						}else {
							if (board.getBoard()[target[1]][target[0]].getColor() == Color.WHITE) {
								throw new CheckersException("Ocuppied position!");
							} 
							if(board.getBoard()[target[1]][target[0]].getColor() == Color.BLACK) {
								board.getBoard()[source[1]][source[0]] = null;
								placePiece(target[1], target[0], "WHITE");
								capturedPieces[1] += 1;
							}
							if(board.getBoard()[target[1]][target[0]] == null){
								board.getBoard()[source[1]][source[0]] = null;
								placePiece(target[1], target[0], "WHITE");
							}

						}
					}

				}else if (turn.equals("BLACK")) {
					throw new CheckersException("This piece isnt yours!");
				}
			}else if (board.getBoard()[source[1]][source[0]].getType().equals("0 ")) {			
				if (turn.equals("BLACK")) {
					if (currentTurn == 2 && source[1] == 2 || source[1] == 1) {
						if ( target[1] > source[1]+2 || target[1] <= source[1] || target[1] < source[1]-1 || target[0] != source[0]) {
							throw new CheckersException("Invalid position");	
						}else{
							board.getBoard()[source[1]][source[0]] = null;
							placePiece(target[1], target[0], "BLACK");
						}
					}else if(currentTurn > 1) {
						if (target[1] < source[1]-1 ||target[1] > source[1]+1|| target[1] <= source[1] || target[0] < source[0] -1 || target[0] > source[0] +1) {
							throw new CheckersException("invalid position");
						}else {
							if (board.getBoard()[target[1]][target[0]].getColor() == Color.BLACK) {
								throw new CheckersException("Ocuppied position!");
							}
							if(board.getBoard()[target[1]][target[0]].getColor() == Color.WHITE) {
								board.getBoard()[source[1]][source[0]] = null;
								placePiece(target[1], target[0], "BLACK");
								capturedPieces[0] += 1;
							}
							if (board.getBoard()[target[1]][target[0]] == null){
								board.getBoard()[source[1]][source[0]] = null;
								placePiece(target[1], target[0], "BLACK");
						}
						}
					}
				}else if (turn.equals("WHITE")) {
					throw new CheckersException("This piece isn't yours!");
				}
			}

		}
		catch(Exception e) {
			throw new CheckersException(e.getMessage());
			
		}				
	}
	
	public void capturedPieces() {
		
	}

	public String currentTurn(int n) {
		if (n % 2 != 0) {
			return "WHITE";
			
		}else if (n % 2 == 0) {
			return "BLACK";	
		}
		return null;
	}
		
	
}
