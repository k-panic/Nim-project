package nim;
/**
 * 
 * @author tp3-gr2
 *
 */

/**
 * 
 * cette classe permet de gerer les 
 * differents joueurs humains.
 *
 */
public class HumanPlayer	{

	public String name;
	/**
	 * represent le constructeur de la classe. 
	 * @param name est le nom saisie par le joueur .
	 * 
	 */

	public HumanPlayer(String name)	{

		this.name= name;
		
	}
	
	/**
	   * la methode tostring permet de reourner une chaine de 
	   * de caractere qui est le nom du joueur. 
	   */

	public String toString()	{
		return this.name;
	}
}
