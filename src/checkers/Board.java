package checkers;


public class Board {
	

	protected Piece[][] board;
	
	public Board() {
		this.board = new Piece[8][8];
	}
	
	public int[] convertPosition(String string) {
		
		int[] convertedInput =  new int[2];
		
		switch(string.charAt(0)) {
			case 'A':
				convertedInput[0] = 0;
				break;
			case 'B':
				convertedInput[0] = 1;
				break;
			case 'C':
				convertedInput[0] = 2;
				break;
			case 'D':
				convertedInput[0] = 3;
				break;
			case 'E':
				convertedInput[0] = 4;
				break;
			case 'F':
				convertedInput[0] = 5;
				break;
			case 'G':
				convertedInput[0] = 6;
				break;
			case 'H':
				convertedInput[0] = 7;
				break;
		}
		
		switch(string.charAt(1)) {
		case '1':
			convertedInput[1] = 0;
			break;
		case '2':
			convertedInput[1] = 1;
			break;
		case '3':
			convertedInput[1] = 2;
			break;
		case '4':
			convertedInput[1] = 3;
			break;
		case '5':
			convertedInput[1] = 4;
			break;
		case '6':
			convertedInput[1] = 5;
			break;
		case '7':
			convertedInput[1] = 6;
			break;
		case '8':
			convertedInput[1] = 7;
			break;

		}	
	return convertedInput;
	}


	public Piece[][] getBoard() {
		return board;
	}

}
