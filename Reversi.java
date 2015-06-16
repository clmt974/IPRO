
public class Reversi extends GameBoard {

	public Reversi(Player p1, Player p2) {
		super(p1, p2);
		WIDTH=8;
    	HEIGHT=8;
    	FIRST_COL=0;
    	LAST_COL=WIDTH -1;
    	FIRST_LINE=0;
    	LAST_LINE=HEIGHT-1;
    	grid = new Square[HEIGHT][WIDTH];
    	}
	
	
	public void InitBoard() {
		for(int i= 0; i < HEIGHT;i++){
			for(int j = 0; j < WIDTH; j++){
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
    	
    	for(int i= FIRST_LINE; i <= LAST_LINE;i++){
    		System.out.print("|"+(i+1)+"| |");
    		for(int j = FIRST_COL; j <= LAST_COL; j++){		
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
    
    public boolean isValid(int row, int col) {
    	int i, j;
    	for (Direction D : Direction.values()) {
    		i=row; j=col;
		while (FIRST_LINE <= i && i <= LAST_LINE &&
				FIRST_COL <= j && j <= LAST_COL &&
				grid[i][j].getStatus() != Status.EMPTY) {
			
		}
		}
    	return super.isValid();
    }
    
}
