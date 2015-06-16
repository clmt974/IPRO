import java.util.Scanner;


public class Player {
    private String name;

    public String getName() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.name;
    }

    public void setName(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.name = value;
    }

    public Player(String n) {
    	this.name = n;
    }

    public String play() {
    	return"toto";
    }

    public int playConnectFour() {
    	System.out.println("\n" + this.getName() + " Colonne : ");
    	Scanner scanner = new Scanner(System.in);
    	int col = scanner.nextInt();
    	//scanner.close(); FAIT PLANTER
    	return col;
    }

}
