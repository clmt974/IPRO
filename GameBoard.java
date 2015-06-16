
public abstract class GameBoard {
    public static int WIDTH;

    public static int HEIGHT;

    public static int FIRST_COL;

    public static int LAST_COL;

    public static int FIRST_LINE;

    public static int LAST_LINE=HEIGHT;

    public Square[][] grid;

    private Player[] players = new Player[2];

    private Player currentPlayer;

    public void printBoard() {
    }

    public void nextPlayer() {
    }

    public Player startGame() {
    	return currentPlayer;
    }

    public boolean hasWinner() {
    	return false;
    }

    public GameBoard(Square[][] grid, Player[] players, Player currentPlayer) {
		super();
		this.grid = grid;
		this.players = players;
		this.currentPlayer = currentPlayer;
	}

	public GameBoard(Player[] players) {
		this.players = players;
		this.currentPlayer = players[0];
    }

    public GameBoard(Player p1, Player p2) {
    	this.players[0] = p1;
    	this.players[1] = p2;
		this.currentPlayer = p1;

	}

	public void initBoard() {
    }

    Player getCurrentPlayer() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.currentPlayer;
    }

    void setCurrentPlayer(Player value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.currentPlayer = value;
    }



    public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public boolean isValid() {
    	return false;
    }

}
