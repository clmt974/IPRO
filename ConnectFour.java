
public class ConnectFour extends GameBoard {
	
    public ConnectFour(Player[] players) {
    	super(players);
    	WIDTH=7;
    	HEIGHT=6;
    	FIRST_COL=0;
    	LAST_COL=WIDTH -1;
    	FIRST_LINE=0;
    	LAST_LINE=HEIGHT-1;
    	grid = new Square[HEIGHT][WIDTH];
    	//Génération d'un nombre alétoire (0 ou 1) pour choisir le joueur qui commence
    	int num = (int)(Math.random() * 2);
    	setCurrentPlayer(players[num]);
    }
    
	public void InitBoard() {
		for(int i= 0; i < HEIGHT;i++){
			for(int j = 0; j < WIDTH; j++){
				this.grid[i][j] = new Square();
				this.grid[i][j].setStatus(Status.EMPTY);
			}
		}
    }
	
    public void printBoard() {
    	String c = "";
    	for(int i= FIRST_LINE; i <= LAST_LINE;i++){
    		for(int j = FIRST_COL; j <= LAST_COL; j++){		
					switch(this.grid[i][j].getStatus()){
						case EMPTY: c= "|-";break;
						case PLAYER_ONE:c="|X";break;
						case PLAYER_TWO:c="|0";break;
						default: break;
					}
					
					if(j < LAST_COL)
						System.out.print(c);
					else
						System.out.println(c+"|");
				}
			}
    	for(int i= FIRST_COL+1; i <= LAST_COL+1;i++){
    		System.out.print("|"+i);
    	}
    	System.out.print("|\n");
    }

	public boolean isValid(int col) {
		return (col > FIRST_COL  && col <= LAST_COL+1);
    }
	
    public Player startGame() {
    	this.InitBoard();
    	System.out.println("\n\n" + this.getCurrentPlayer().getName() + " commence!\n");
    	while(!hasWinner()){
    		this.printBoard();
	    	int col = getCurrentPlayer().playConnectFour();
			if(isValid(col)){
				placePiece(col-1);
				if(!hasWinner()){
					nextPlayer();
					setCurrentPlayer(getCurrentPlayer());
				}
			}
		}
    	return this.getCurrentPlayer();
    }

	@Override
	public void nextPlayer() {
		if(getCurrentPlayer() == getPlayers()[0])
			setCurrentPlayer(getPlayers()[1]);
		else
			setCurrentPlayer(getPlayers()[0]);
		
	}
	
	private void placePiece(int col){
		int i = LAST_LINE;
		boolean isFind = false;
		do
		{
			if(this.grid[i][col].getStatus() == Status.EMPTY ){
				if(getCurrentPlayer() == getPlayers()[0])
					this.grid[i][col].setStatus(Status.PLAYER_ONE);
				else
					this.grid[i][col].setStatus(Status.PLAYER_TWO);
				isFind = true;
			}
			i--;
		}while(i >= FIRST_LINE && isFind == false);
	}

	@Override
	public boolean hasWinner() {
		int nbpion;
		Direction d;
		//Verif Horizontal
		
		return false;
	}
}	
