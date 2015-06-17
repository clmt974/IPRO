import java.util.Stack;

public class Reversi extends GameBoard {

	public Reversi(Player p1, Player p2) {
		super(p1, p2);
		WIDTH = 8;
		HEIGHT = 8;
		FIRST_COL = 0;
		LAST_COL = WIDTH - 1;
		FIRST_LINE = 0;
		LAST_LINE = HEIGHT - 1;
		grid = new Square[HEIGHT][WIDTH];
	}

	@Override
	public Player startGame() {
		Status pStatus;
		Integer[] t;
		Stack<Direction> vd = new Stack<Direction>();

		initBoard();

		while (!hasWinner()) {

			if (this.getCurrentPlayer() == getPlayers()[0])
				pStatus = Status.PLAYER_ONE;
			else
				pStatus = Status.PLAYER_TWO;

			printBoard();

			t = getCurrentPlayer().playReversi();
			while ((vd = getValidDirections(t[1], t[0])).isEmpty()) {
				t = getCurrentPlayer().playReversi();
			}
			grid[t[1]][t[0]].setStatus(pStatus);

			while (!vd.empty()) {
				System.out.println(vd.peek());
				returnPieces(t[1], t[0], vd.pop());
			}

			nextPlayer();
		}
		return getCurrentPlayer();
		//return getWinner();
	}

	public void initBoard() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
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
		char c = 'A';
		System.out.print("    ");
		for (int i = FIRST_COL + 1; i <= LAST_COL + 1; i++) {
			System.out.print("|" + (c++));
		}
		System.out.println("|");

		for (int i = FIRST_LINE; i <= LAST_LINE; i++) {
			System.out.print("|" + (i + 1) + "| |");
			for (int j = FIRST_COL; j <= LAST_COL; j++) {
				switch (this.grid[i][j].getStatus()) {
				case EMPTY:
					System.out.print("-|");
					break;
				case PLAYER_ONE:
					System.out.print("X|");
					break;
				case PLAYER_TWO:
					System.out.print("0|");
					break;
				default:
					break;
				}
			}
			System.out.println("");
		}
	}

	public boolean isValid(int row, int col, Direction d) {
		Status pStatus;
		int i = row, j = col;
		
		if (this.getCurrentPlayer() == getPlayers()[0])
			pStatus = Status.PLAYER_ONE;
		else
			pStatus = Status.PLAYER_TWO;

		i += d.getY();
		j += d.getX();

		if (FIRST_LINE <= i && i <= LAST_LINE && FIRST_COL <= j
				&& j <= LAST_COL)
			if (grid[i][j].getStatus() == Status.EMPTY) {
				return false;
			} else if (grid[i][j].getStatus() == pStatus) {
				return false;
			} else {
				i += d.getY();
				j += d.getX();
				while (FIRST_LINE <= i && i <= LAST_LINE && FIRST_COL <= j
						&& j <= LAST_COL) {
					if (grid[i][j].getStatus() == pStatus)
						return true;
					i += d.getY();
					j += d.getX();

				}
			}
		return false;
	}

	public Stack<Direction> getValidDirections(int row, int col) {
		Stack<Direction> s = new Stack<Direction>();

		for (Direction d : Direction.values()) {
			if (isValid(row, col, d)) {
				s.push(d);
			}
		}
		return s;
	}

	@Override
	public void nextPlayer() {
		if (getCurrentPlayer() == getPlayers()[0])
			setCurrentPlayer(getPlayers()[1]);
		else
			setCurrentPlayer(getPlayers()[0]);
	}

	public void returnPieces(int row, int col, Direction d) {
		int i = row, j = col;
		Status pStatus;
		
		if (this.getCurrentPlayer() == getPlayers()[0])
			pStatus = Status.PLAYER_ONE;
		else
			pStatus = Status.PLAYER_TWO;
		
		i += d.getY();
		j += d.getX();

		while (FIRST_LINE <= i && i <= LAST_LINE && FIRST_COL <= j
				&& j <= LAST_COL
				&& grid[i][j].getStatus() != pStatus) {
			grid[i][j].returnPiece();
			i += d.getY();
			j += d.getX();

		}
	}

	@Override
	public boolean hasWinner() {

		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++)
				if (grid[i][j].getStatus() == Status.EMPTY)
					if (getValidDirections(i, j).isEmpty())
						return false;

		return true;
	}
/*
	public Player getWinner() {
		int p1 = 0, p2 = 0;

		for (Square squares[] : grid)
			for (Square square : squares)
				if (square.getStatus() == Status.PLAYER_ONE)
					p1++;
				else if (square.getStatus() == Status.PLAYER_TWO)
					p2++;

		if (p1 > p2) {
			return getPlayers()[0];
		} else if (p2 > p1) {
			return getPlayers()[1];
		} else {
			return null;
		}
	}
*/
}
