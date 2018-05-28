package nim;
import java.util.*;
/**
 * 
 * @author tp3-gr2
 *
 */

/**
 * 
 * la classe console  permet a un joueur humain d interagir avec le programme
 *
 */
public class Console	{

	static Scanner in= new Scanner(System.in);

	/**
	 *  demande au joueur de saisir le nombre de lignes du plateau et retourne cet entier 
	 * @return le nombre saisi par le joueur 
	 */
	public static int getSize()	{
		int n=0;
		do{
			System.out.print("Donner le nombre de lignes du plateau:\n -> ");
			n=in.nextInt();
		}while(n<=1);
		return n;

	}	
	
	/**
	 *  demande au joueur de saisir un coup sous la forme m n ou m est le numero de la ligne et 
	 *  n est le nombre d allumettes a retirer. 
	 *  Cette methode verifie les ereurs qui peuvent arriver pendant la saisie des deux entiers
	 * @param name est le nom du joueur qui joue le coup 
	 * @return renvoie un coup valide 
	 */

	public static Move getMove(String name)	{ 
		Scanner inmove= new Scanner(System.in);
		int [] inputtab;
		System.out.print("Donnez le numero de la ligne suivi du nombre d'allumette: ");
		
		String input=inmove.nextLine();
		input = input.replaceAll("[^\\d.]", " ");
		StringTokenizer st = new StringTokenizer(input);
		int i=0;
		inputtab=new int[st.countTokens()];
		while (st.hasMoreTokens()) {
			
			inputtab[i]=Integer.parseInt(st.nextToken());
			
		 	i++;
		}
		
		
		
		if(inputtab.length <= 1){
			System.out.println("Invalide move");
			return getMove(name);
		}
		
		
		if(inmove == null){
			inmove.close();
		}
		return new Move(inputtab[0],inputtab[1]);
		
	}

	/**
	 *  la methode showBoard est une methode represente une pyramide en se referant sur le nombre se trouvant dans la case i du tableau en parametre
	 *  
	 * @param board tableau dont la case i represente le nombre d'allumettes de la ligne i
	 */
	
	public static void showBoard(int[] board)    { 

        for(int ligne=0; ligne<board.length; ligne++){
        	if(ligne>-1 && ligne<9){
        		System.out.print("Ligne "+(ligne+1)+"  :");
        	}
        	else{
        		System.out.print("Ligne "+(ligne+1)+" :");
        	}
            int nball=board[ligne];
            for(int espace=0;espace<(board.length-ligne+2);espace++){
                System.out.print(" ");
            }
            while(nball !=0){
                System.out.print("|");
                nball--;
            }
            for(int espace=0;espace<=((ligne*2)-board[ligne]);espace++){
            	System.out.print(" ");
            }
            for(int espace=0;espace<(board.length-ligne+2);espace++){
                System.out.print(" ");
            }
            
            if(board[ligne]==0){}
            else if(board[ligne]==1){
            	System.out.print(board[ligne]+"  : Allumette");
            }
            else if(board[ligne]>1 && board[ligne]<10){
            	System.out.print(board[ligne]+"  : Allumettes");
            }
            else{
            	System.out.print(board[ligne]+" : Allumettes");
            }
            System.out.println(); 
        }

    }

	/**
     * @param l est le coup tape
     * Cette methode affiche un message indiquand qu un coup est invalide
     */
	public static void invalidMove(Move l)	{

			System.out.println("Vous ne pouvez pas supprimer "+l.allumettes+" allumettes sur la ligne "+l.ligne);

	}
	
	/** 
	 * la methode askName permet de saisir le nom du joeur 
	 * @return un joueur de type HumanPlayer() dont le nom est la chaine de caractere saisie par l'utilisateur
	 */

	public static HumanPlayer askName()	{

		System.out.print("Donnez votre nom:\n--> ");

		return new HumanPlayer(in.next());
	}

	/**
	 * cette methode se contente d afficher un message indiquant que le joueur donne en parametre est le gagnant de la partie
	 * @param name represente le nom du joueur 
	 */
	public static void showWinner(String name)	{

		System.out.println("Le gagnant de cette partie est: "+name);

	}




	
}
