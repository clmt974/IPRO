import java.util.Scanner;


public class BoardGames {
    public static Choice choice;

    public static GameBoard board;

    public Menu menu;
    
    public static Direction dir = Direction.HORIZONTAL_LEFT;

    public static void main(String[] args) {

    	Menu m = new Menu();
    	m.printMenu();
    	choice = m.getChoice();
    	
    	if(choice == Choice.CONNECT_FOUR){
    		Player[] players = new Player[2];
    		Scanner scanner = new Scanner(System.in);    		
    		System.out.println("Entre le nom du joueur 1 :");
    		String name = scanner.next(); 
    		players[0] = new Player(name);
    		System.out.println("Entre le nom du joueur 2 :");
    		name=scanner.next();
    		players[1] = new Player(name);

	    	board = new ConnectFour(players);  
	    	Player winner = board.startGame(); 
	    	if(winner != null)
	    		System.out.println(winner.getName() + " a gagné!");
	    	else
	    		System.out.println("Match nul!");
    	}
    	if(choice == Choice.REVERSI){
    		
    	}
    	if(choice == Choice.FIVE_OR_MORE){
    		System.out.println("Le jeu est en cours de construction, désolé...");
    		System.exit(0);
    	}
    	if(choice == Choice.EXIT){
    		System.out.println("Au revoir!");
    		System.exit(0);
    	}
    	
    
    	/*board = new Reversi(players[0],players[1]);  
    	board.startGame();*/
    	
    	
    	/*board = new Reversi(players[0],players[1]);  
    	board.grid = new Square[board.WIDTH][board.HEIGHT];
    	
    	board.InitBoard();
    	//board.grid[3][2].setStatus(Status.PLAYER_ONE);
    	board.printBoard();
*/
    }

}
