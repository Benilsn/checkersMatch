package checkers;

public class Piece {
	

	private Color color;
	private String type;
	
	private Position position;
	
	
	public Piece(Color color, Position position) {
		this.color = color;
		this.position = position;
		
		if (color == Color.BLACK) {
			this.type = "0 ";
		}else if(color == Color.WHITE) {
			this.type = "1 ";
		}else {
			this.type = "- ";
		}
	}
	
	public Piece(Position position, String rep) {
		this.position = position;
		this.type = rep;
	}

	public Color getColor() {
		return color;
	}


	public String getType() {
		return type;
	}
	
	public Position getPosition() {
		return position;
	}


	
	
	
	

}
