
public class BoardGames {
    public Choice choice;

    public static GameBoard board;

    public Menu menu;

    public static void main(String[] args) {

    	Player[] players = new Player[2];
    	players[0] = new Player("joueur1");
    	players[1] = new Player("joueur2");
    	
    	board = new ConnectFour(players);  
    	board.grid = new Square[board.WIDTH][board.HEIGHT];
    	board.InitBoard();
    	System.out.println("ok");
    }

}
