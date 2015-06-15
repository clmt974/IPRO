
public class ConnectFour extends GameBoard {
	
	public boolean isValid(int col) {
		return false;
    }

    public ConnectFour(Player[] players) {
    	super(players);
    	WIDTH=7;
    	HEIGHT=6;
    	FIRST_COL=0;
    	LAST_COL=WIDTH -1;
    	FIRST_LINE=0;
    	LAST_LINE=HEIGHT-1;
    }
    
	public void InitBoard() {
		for(int i= 0; i < WIDTH;i++){
			for(int j = 0; j < HEIGHT; j++){
				this.grid[i][j] = new Square();
				this.grid[i][j].setStatus(Status.EMPTY);
			}
		}
    }

}	
