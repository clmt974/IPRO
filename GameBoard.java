
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

    public abstract void nextPlayer() ;

    public abstract Player startGame() ;

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
    }

    public GameBoard(Player p1, Player p2) {
    	this.players[0] = p1;
    	this.players[1] = p2;
	}

	public void InitBoard() {
    }

    Player getCurrentPlayer() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.currentPlayer;
    }

    void setCurrentPlayer(Player value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.currentPlayer = value;
    }

    Player[] getPlayers() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.players;
    }

    void setPlayers(Player[] value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.players = value;
    }

    public abstract boolean isValid(int col);

}
