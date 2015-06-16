
public class BoardGames {
    public Choice choice;

    public static GameBoard board;

    public Menu menu;
    
    public static Direction dir = Direction.HORIZONTAL_LEFT;

    public static void main(String[] args) {

    	Player[] players = new Player[2];
    	players[0] = new Player("joueur1");
    	players[1] = new Player("joueur2");
    	
    
    	board = new ConnectFour(players);  
    	
    /*
    	board = new Reversi(players[0],players[1]);  
    	*/
    	board.startGame();
    	
    	
    	/*board = new Reversi(players[0],players[1]);  
    	board.grid = new Square[board.WIDTH][board.HEIGHT];
    	
    	board.InitBoard();
    	//board.grid[3][2].setStatus(Status.PLAYER_ONE);
    	board.printBoard();
*/
    }

}
