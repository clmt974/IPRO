public class ConnectFour extends GameBoard {

	public ConnectFour(Player[] players) {
		super(players);
		WIDTH = 7;
		HEIGHT = 6;
		FIRST_COL = 0;
		LAST_COL = WIDTH - 1;
		FIRST_LINE = 0;
		LAST_LINE = HEIGHT - 1;
		grid = new Square[HEIGHT][WIDTH];
		// Génération d'un nombre alétoire (0 ou 1) pour choisir le joueur
		// qui commence
		int num = (int) (Math.random() * 2);
		setCurrentPlayer(players[num]);
	}

	public void initBoard() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				this.grid[i][j] = new Square();
				this.grid[i][j].setStatus(Status.EMPTY);
			}
		}
	}

	public void printBoard() {
		String c = "";
		for (int i = FIRST_LINE; i <= LAST_LINE; i++) {
			for (int j = FIRST_COL; j <= LAST_COL; j++) {
				switch (this.grid[i][j].getStatus()) {
				case EMPTY:
					c = "|-";
					break;
				case PLAYER_ONE:
					c = "|X";
					break;
				case PLAYER_TWO:
					c = "|0";
					break;
				default:
					break;
				}

				if (j < LAST_COL)
					System.out.print(c);
				else
					System.out.println(c + "|");
			}
		}
		for (int i = FIRST_COL + 1; i <= LAST_COL + 1; i++) {
			System.out.print("|" + i);
		}
		System.out.print("|\n");
	}

	public boolean isValid(int col) {
		return (col >= FIRST_COL && col <= LAST_COL && this.grid[0][col]
				.getStatus() == Status.EMPTY);
	}

	public Player startGame() {
		this.initBoard();
		int col = 0;
		int row = 0;
		System.out.println("\n\n" + this.getCurrentPlayer().getName()
				+ " commence!\n");
		while (!hasWinner(row, col) && !isFull()) {
			this.printBoard();
			col = getCurrentPlayer().playConnectFour() - 1;
			if (isValid(col)) {
				row = placePiece(col);
				if (!hasWinner(row, col)) {
					nextPlayer();
					setCurrentPlayer(getCurrentPlayer());
				}
			}
		}
		this.printBoard();
		if (isFull())
			return null;

		return getWinner();

	}

	private int placePiece(int col) {
		int i = LAST_LINE;
		boolean isFind = false;
		do {
			if (this.grid[i][col].getStatus() == Status.EMPTY) {
				if (getCurrentPlayer() == getPlayers()[0])
					this.grid[i][col].setStatus(Status.PLAYER_ONE);
				else
					this.grid[i][col].setStatus(Status.PLAYER_TWO);
				isFind = true;
			}
			i--;
		} while (i >= FIRST_LINE && isFind == false);
		return i + 1;
	}

	public boolean hasWinner(int row, int col) {
		boolean ret = false;

		// Verif Diagonale first
		ret = hasWinner(row, col, Direction.FIRST_DIAG_UP);
		if (ret == true)
			return ret;
		// Verif Diagonale Second
		ret = hasWinner(row, col, Direction.SECOND_DIAG_UP);
		if (ret == true)
			return ret;
		// Verif Diagonale Second
		ret = hasWinner(row, col, Direction.VERTICAL_UP);
		if (ret == true)
			return ret;
		// Verif Diagonale Second
		ret = hasWinner(row, col, Direction.HORIZONTAL_LEFT);
		if (ret == true)
			return ret;

		return ret;

	}

	public boolean hasWinner(int row, int col, Direction d) {
		int nbpion = 0;
		Status sToFind = this.grid[row][col].getStatus();
		while (row > FIRST_LINE && row <= LAST_LINE && col > FIRST_COL
				&& col < LAST_COL) {
			row += d.getX();
			col += d.getY();
		}
		// System.out.println("Je commence en " + row + col);

		d = d.getOpposite();
		while (row >= FIRST_LINE && row <= LAST_LINE && col >= FIRST_COL
				&& col <= LAST_COL && sToFind != Status.EMPTY) {
			// System.out.println("verif row : " + row + " col : " + col);
			if (this.grid[row][col].getStatus() == sToFind) {
				nbpion++;
				if (nbpion == 4) {
					return true;
				}
			} else {
				nbpion = 0;
			}

			row += d.getX();
			col += d.getY();
		}
		return false;
	}

	public boolean isFull() {
		for (int j = FIRST_COL; j <= LAST_COL; j++) {
			if (this.grid[0][j].getStatus() == Status.EMPTY) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean hasWinner() {
		// TODO Auto-generated method stub
		return false;
	}

	public Player getWinner(){
		return this.getCurrentPlayer();
	}
	
	public boolean isValid(){
		return true;
	}


}