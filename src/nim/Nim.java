package nim;

/**
 * 
 * @author tp3-gr2
 *
 */

/**
	 * 
	 * programme principale permettant d executer le programme et commencer une partie de NIM avec une strategie gagnante 
	 */
public class Nim	{

	public static void main(String[] args)	{

		
		Board jeu= new Board(new GameState(Console.getSize()),Console.askName(),new HumanPlayer("Machine"));
		
		do	{
			jeu.jouerTour();
		}while(jeu.state.nbAl>1);		
			
			
	}
}
