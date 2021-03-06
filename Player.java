import java.util.Scanner;

public class Player {
	private String name;
	private Status status;

	public Player(String n, Status s) {
		this.name = n;
		this.status = s;
	}

	public int playConnectFour() {
		System.out.println("\n" + this.getName() + " Colonne : ");
		int col = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			String s = scanner.next();
			try {
				col = Integer.parseInt(s);
			} catch (Exception e) {
				System.out.println("Erreur de saisie,recommencez: ");
			}
		} while (col == 0);
		return col;
	
		// scanner.close(); FAIT PLANTER
	}

	public Integer[] playReversi() {
		Integer[] t = new Integer[2];
		Scanner sc = new Scanner(System.in);
		String str = null;
		boolean correct = false;

		if (getSt() == Status.PLAYER_ONE)
			System.out.println("(" + getName() + " X ) > " + "case : ");
		else
			System.out.println("(" + getName() + " O ) > " + "case : ");

		while (!correct) {
			str = sc.nextLine();
			try {
				t[0] = Integer.parseInt("" + ((char) (str.charAt(0) - 17)));
				t[1] = Integer.parseInt("" + ((char) (str.charAt(1) - 1)));

				if (0 < t[0] && t[0] > 7 || 0 < t[1] && t[1] > 7) {
					System.out.println("Erreur de saisie,recommencez: ");

				} else {
					System.out.println("saisie ok");
					correct = true;
				}

			} catch (Exception e) {
				System.out.println("Erreur de saisie,recommencez: ");
			}

			// System.out.println("" + t[0] + " " + t[1]);
		}
		return t;
	}

	public String getName() {
		// Automatically generated method. Please delete this comment before
		// entering specific code.
		return this.name;
	}

	public void setName(String value) {
		// Automatically generated method. Please delete this comment before
		// entering specific code.
		this.name = value;
	}

	public Status getSt() {
		return status;
	}

	public void setSt(Status st) {
		this.status = st;
	}

}
