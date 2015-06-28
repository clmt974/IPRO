
public class Square {
    private Status status;

    public Square(){
    }

    Status getStatus() {
        return this.status;
    }

    void setStatus(Status value) {
        this.status = value;
    }
   
    public void returnPiece() {
		if (this.getStatus() == Status.PLAYER_ONE) {
			setStatus(Status.PLAYER_TWO);
		} else {
			setStatus(Status.PLAYER_ONE);
		}
	}

}
