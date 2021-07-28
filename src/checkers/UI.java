package checkers;

public class UI {


	Board board = new Board();
	Piece piece = new Piece();
	
	
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
		
		System.out.println("\n    CAPTURED PIECES: \n   BLACK(0)    WHITE(1)\n     [0]         [0]");
	}
	
	
	public void placePiece(int row, int column, String color) {
		board.getBoard()[row][column] = new Piece(Color.valueOf(color),new Position(row, column));
	}

	public void movePiece(int[] source, int[] target, int currentTurn) throws CheckersException {
		String turn = "";
		try {
			if (currentTurn % 2 != 0) {
				turn = "WHITE";
			}
			if (currentTurn % 2 == 0) {
				turn = "BLACK";	
			}
			
			if (board.getBoard()[source[1]][source[0]] == null) {
				throw new CheckersException("Invalid position");
			}
			
			if (board.getBoard()[source[1]][source[0]].getType().equals("1 ")) {
				if (turn.equals("WHITE")) {
					board.getBoard()[source[1]][source[0]] = null;
					placePiece(target[1], target[0], "WHITE");
				}if (turn.equals("BLACK")) {
					throw new CheckersException("This piece isnt yours!");
				}
			}
			
			if (board.getBoard()[source[1]][source[0]].getType().equals("0 ")) {			
				if (turn.equals("BLACK")) {
				board.getBoard()[source[1]][source[0]] = null;
				placePiece(target[1], target[0], "BLACK");
				}else if (turn.equals("WHITE")) {
					throw new CheckersException("This piece isnt yours!");
				}
			}

		}
		catch(Exception e) {
			throw new CheckersException(e.getMessage());
		}				
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
