
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
		this.grid[3][3].setStatus(Status.PLAYER_TWO);
		this.grid[3][4].setStatus(Status.PLAYER_ONE);
		this.grid[4][3].setStatus(Status.PLAYER_ONE);
		this.grid[4][4].setStatus(Status.PLAYER_TWO);
    }
	
    public void printBoard() {
    	
    	System.out.print("    ");
    	for(int i= FIRST_COL+1; i <= LAST_COL+1;i++){
    		System.out.print("|"+i);
    	}
    	System.out.println("|");
    	
    	for(int i= FIRST_COL; i <= LAST_COL;i++){
    		System.out.print("|"+(i+1)+"| |");
    		for(int j = FIRST_LINE; j <= LAST_LINE; j++){		
					switch(this.grid[i][j].getStatus()){
						case EMPTY:  System.out.print("-|");break;
						case PLAYER_ONE: System.out.print("X|");break;
						case PLAYER_TWO: System.out.print("0|");break;
						default: break;
					}					
				}
    			System.out.println("");
			}
    }
}
