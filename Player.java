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
    
    public Integer[] playReversi(){
    	Integer[] t = new Integer[2];
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("saisir les coordonnées de la case ou jouer : ");
    	
    	String str = sc.nextLine();
    	t[0] = Integer.parseInt(""+((char) (str.charAt(0)-17)));
    	t[1] = Integer.parseInt(""+((char) (str.charAt(1)-1)));
    	
    	System.out.println(""+t[0]+" "+t[1]);
    	
    	return t;
    }
    

}
