package nim;
/**
 * 
 * @author tp3-gr2
 *
 */

/**
 * 
 * represente un coup (une ligne et un  nombre d allumettes).
 *
 */
public class Move	{

	public int ligne;
	public int allumettes;

	/**
	 * 
	 * @param m represente la ligne choisie par un joueur
	 * @param n represente le nombre d allumettes 
	 */
	public Move(int m, int n)	{
		this.ligne= m;
		this.allumettes= n;
	}
}
