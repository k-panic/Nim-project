package nim;


/**
 * 
 * cette classe cree un joueur de type HumanPlayer() ayant un nom
 *
 */
public class HumanPlayer	{

	public String name;
	/**
	 * Constructeur de la classe. 
	 * @param name on donne une chaine de caractere en parametre puis cree un nouveau joueur ayant pour nom cette chaine de caractere
	 * 
	 */

	public HumanPlayer(String name)	{

		this.name= name;
		
	}

	/**
	   * la methode tostring retourne une chaine de caractere contenant les informations du joueur. 
	 */
	public String toString()	{
		return this.name;
	}
}
