package checkers;

public class UI {


	Board board = new Board();
	
	
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
		for (int r = 0; r < board.getBoard().length;r++) {
			System.out.println();
			for (int c = 0; c < board.getBoard().length; c++) {
				if (board.getBoard()[r][c] == null) {
					System.out.print("- ");
				}else {
					System.out.print(board.getBoard()[r][c].getType());
				}
			
			}
		}
	}
	
	
	public void placePiece(int row, int column, String color) {
		board.getBoard()[row][column] = new Piece(Color.valueOf(color),new Position(row, column));
	}
	
	public void removePiece(int row, int column) {
		board.getBoard()[row][column] = null;
	}
	
	
	
	
	
	
	
	
}
