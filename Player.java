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
    
    public int[] playReversi(){
    	int[] t = new int[2];
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("saisir les coordonnées de la case ou jouer : ");
    	
    	String str = sc.nextLine();
    	t[0] = (int) str.charAt(0)-16;
    	t[1] = (int) str.charAt(1)-16;
    	
    	return t;
    }
    

}
