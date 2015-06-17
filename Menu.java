import java.util.Scanner;


public class Menu {
    public String[] playersName = new String[2];

    private Choice choice;

    public void printMenu() {
    	System.out.println("BIENVENUE!\nA quel jeu voulez-vous jouer ?\n1: Puissance 4 \n2: Othello \n3 Five or more (En construction)\n4: Quitter");
    	System.out.print("Votre choix:");   
    	Scanner scanner = new Scanner(System.in);
    	int c = 0;
    	
    	do
    	{
	    	try
	    	{
	    		String s = scanner.next();
	    		c = Integer.parseInt(s);
	    	}catch(Exception e)
	    	{
	    		System.out.println("Erreur de saisie, recommencez : ");
	    	}
    	}while(c <= 0 || c > 4);
    	switch(c){
	    	case 1: setChoice(Choice.CONNECT_FOUR);break;
	    	case 2: setChoice(Choice.REVERSI);break;
	    	case 3: setChoice(Choice.FIVE_OR_MORE);break;
	    	case 4: setChoice(Choice.EXIT);break;
	    	default: System.out.println("Erreur");
    	}
    }

    String[] getPlayersName() {
    	
        return this.playersName;
    }

    void setPlayersName(String[] value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.playersName = value;
    }

    void setChoice(Choice value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.choice = value;
    }
    
    public Choice getChoice(){
    	return this.choice;
    }



}
