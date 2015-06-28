public abstract class GameBoard {
	public static int WIDTH;

	public static int HEIGHT;

	public static int FIRST_COL;

	public static int LAST_COL;

	public static int FIRST_LINE;

	public static int LAST_LINE = HEIGHT;

	public Square[][] grid;

	private Player[] players = new Player[2];

	private Player currentPlayer;

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

	public abstract Player startGame();

	public abstract void initBoard();

	public abstract void printBoard();

	public abstract boolean isValid();

	public abstract boolean hasWinner();

	public abstract Player getWinner();

	public void nextPlayer() {
		if (getCurrentPlayer() == getPlayers()[0])
			setCurrentPlayer(getPlayers()[1]);
		else
			setCurrentPlayer(getPlayers()[0]);
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public void setCurrentPlayer(Player value) {
		this.currentPlayer = value;
	}

}
