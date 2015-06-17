
public class Square {
    public Piece piece;

    private Status status;

    public Square(){
    }

    Status getStatus() {
        return this.status;
    }

    void setStatus(Status value) {
        this.status = value;
    }

    Piece getPiece() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.piece;
    }

    void setPiece(Piece value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.piece = value;
    }
    
    public void returnPiece() {
		if (this.getStatus() == Status.PLAYER_ONE) {
			setStatus(Status.PLAYER_TWO);
		} else {
			setStatus(Status.PLAYER_ONE);
		}
	}

}
