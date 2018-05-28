package nim;
/**
 *cette classe cree un maillon servant de creer une liste chainee
 */
public class Maillon<T>	{
	
	/**
	*
	*T est le type qu on veut utiliser dans notre liste
	*/
	
	public T value;
	public Maillon<T> next;
	

	/**
	 * contructeur de la classe Mailllon
	 * @param x est la valeur du maillon 
	 * @param l est l adresse du maillon suivant 
	 */
	public Maillon(T x, Maillon<T> l)	{
		this.value= x;
		this.next= l;
	}
}
