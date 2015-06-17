import java.util.Scanner;


public class Player {
    private String name;
    private Status st;

    public Status getSt() {
		return st;
	}

	public void setSt(Status st) {
		this.st = st;
	}

	public String getName() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.name;
    }

    public void setName(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.name = value;
    }

    public Player(String n, Status s) {
    	this.name = n;
    }

    public int playConnectFour() {
    	System.out.println("\n" + this.getName() + " Colonne : ");
    	int col = 0;
    	Scanner scanner = new Scanner(System.in);
    		do
    		{
    			String s = scanner.next();
    	    	try
    	    	{
    	    		col = Integer.parseInt(s);
    	    	}catch(Exception e)
    	    	{
    	    		System.out.println("Erreur de saisie,recommencez: ");
    	    	}
    		}while(col == 0);
    		return col;
    	
    	//scanner.close(); FAIT PLANTER
    }
    
    public Integer[] playReversi(){
    	Integer[] t = new Integer[2];
    	Scanner sc = new Scanner(System.in);
    	
<<<<<<< HEAD
    	System.out.println("saisir les coordonn�es de la case ou jouer : ");
=======
    	System.out.println("("+getName()+" X ) > "+ "case : ");
>>>>>>> 0a7ca3e8a446ddc65cb25006cc12900ce4fe29bd
    	
    	String str = sc.nextLine();
    	t[0] = Integer.parseInt(""+((char) (str.charAt(0)-17)));
    	t[1] = Integer.parseInt(""+((char) (str.charAt(1)-1)));
    	
    	System.out.println(""+t[0]+" "+t[1]);
    	
    	return t;
    }
    

}
