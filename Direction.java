public enum Direction{

	VERTICAL_UP (0,-1),
	VERTICAL_DOWN (0,+1),
	
	HORIZONTAL_LEFT (-1,0),
	HORIZONTAL_RIGHT (+1,0),
	
	/* Represente la diagonale '\' */
	FIRST_DIAG_UP (-1,-1),
	FIRST_DIAG_DOWN (+1,+1),
	
	/* Represente la diagonale '/' */
	SECOND_DIAG_UP (+1,-1),
	SECOND_DIAG_DOWN(-1,+1);
	
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

	public Direction getOpposite(){
		if(this == FIRST_DIAG_UP)
			return FIRST_DIAG_DOWN;
		if(this == SECOND_DIAG_UP)
			return SECOND_DIAG_DOWN;
		if(this == FIRST_DIAG_DOWN)
			return FIRST_DIAG_UP;
		if(this == SECOND_DIAG_DOWN)
			return SECOND_DIAG_UP;
		if(this == VERTICAL_UP)
			return VERTICAL_DOWN;
		if(this == VERTICAL_DOWN)
			return VERTICAL_UP;
		if(this == HORIZONTAL_LEFT)
			return HORIZONTAL_RIGHT;
		if(this == HORIZONTAL_RIGHT)
			return HORIZONTAL_LEFT;
		
		//On ne l'atteint jamais
		return this;
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


