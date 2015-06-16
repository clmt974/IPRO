
public class Reversi extends GameBoard {

	public Reversi(Player p1, Player p2) {
		super(p1, p2);
		WIDTH=8;
    	HEIGHT=8;
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
	
    public void printBoard() {
    	String c = "";
    	for(int i= FIRST_COL; i <= LAST_COL;i++){
    		for(int j = FIRST_LINE; j <= LAST_LINE; j++){		
					switch(this.grid[i][j].getStatus()){
						case EMPTY: c= "|-";break;
						case PLAYER_ONE:c="|X";break;
						case PLAYER_TWO:c="|0";break;
						default: break;
					}
					
					if(j < LAST_LINE)
						System.out.print(c);
					else
						System.out.println(c+"|");
				}
			}
    	
    	for(int i= FIRST_COL+1; i < LAST_COL+1;i++){
    		System.out.print("|"+i);
    	}
    	System.out.print("|");
    }
}
