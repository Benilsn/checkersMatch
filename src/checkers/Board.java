package checkers;


public class Board {
	
	private int row;
	private int column;
	
	private Position position;
	protected Piece[][] board;
	
	public Board() {
		this.board = new Piece[8][8];
	}
	
	
	public void removePiece(int row, int column) {
		board[row][column] = null;
	}
	
	
	public Piece[][] getBoard() {
		return board;
	}
	
	
	


	
	
	
	
	
	

}
