package nim;
/**
 * 
 * @author tp3-gr2
 *
 */

/**
	 * 
	 * classe permettante d'executer les autres classes du jeu
	 */
public class Nim	{
	
	/**
	 * 
	 * programme principale du jeu permettant de lancer le jeu 
	 */
	public static void main(String[] args)	{

		Board jeu= new Board(new GameState(Console.getSize()),Console.askName(),new HumanPlayer("Machine"));
		
		do	{
			jeu.jouerTour();
		}while(jeu.state.nbAl>1);		
			
			
	}
}
