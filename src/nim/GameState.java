package nim;



/**
 * 
 * @author tp3-gr2
 *
 */

/**
* la  classe GameState represente l etat courant du jeu 
*/
public class GameState	{

	public int[] board;
	public int nbAl;
	
	/**
	 * repreesente l etat courant du jeu.
	 * @param n est la taille du plateau de jeu .
	 */
	public GameState(int n)	{

		this.board= new int[n];
		for(int i=0; i<board.length;i++)	{
			this.board[i]=2*i+1;
			this.nbAl +=this.board[i];
		}
	}

	/**
	 * Methode qui permet de supprimer le coup l dans le plateau de jeu
	 * 
	 * @param l est la ligne dans laquelle on veut supprimer des allumettes
	 */
	public void supprimer(Move l)	{
		
		int t=0;
		while(t<l.allumettes)	{
			if(this.board[l.ligne-1]>0)	{
				this.board[l.ligne-1]--;
				this.nbAl--;
			}
			t++;
			if(t==l.allumettes)	break;
		}
		
	}
		

	

	
}
