public enum Direction{

	VERTICAL_UP (0,-1),
	VERTICAL_DOWN (0,+1),
	
	HORIZONTAL_LEFT (-1,0),
	HORIZONTAL_RIGHT (+1,0),
	
	/* Represente la diagonale '\' */
	FIRST_DIAG_UP (-1,-1),
	FIRST_DIAG_DONW (+1,+1),
	
	/* Represente la diagonale '/' */
	SECOND_DIAG_UP (+1,-1),
	SECOND_DIAG_DONW(-0,+1);
	
	private int y,x;
	
	private Direction(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public Direction nextDirection(){
		Direction[] vals = values();
		        return vals[(this.ordinal()+1) % vals.length];
	}
	/*
	public String toString(){
		return this.y+" "+this.x;
	}
	*/
}