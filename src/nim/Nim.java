package nim;

/**
 * 
 * @author  tp3-gr2
 *
 */


	
public class Nim	{
	/**
	 * Classe permettant d executer le jeu
	 */

	public static void main(String[] args)	{

		int nbLignes= Console.getSize();
		HumanPlayer player1= Console.askName(1);
		HumanPlayer player2= Console.askName(2);
		
		Board jeu= new Board(new GameState(nbLignes),player1,player2);
		
		do	{

			jeu.jouerTour();

		}while(jeu.state.nbAl>1);		
			
	}
}
