package nim;
/**
*classe permettant de creer et gerer des maillons
**/
public class Maillon<T>	{

	public T value;
	public Maillon<T> next;
	/**
	*constructeur de maillon
	*@param x est la valeur du maillon
	*@param l est l adresse du maillon suivant
	*/
	public Maillon(T x, Maillon<T> l)	{
		this.value= x;
		this.next= l;
	}

	/**
	*Methode permettant d afficher la valeur d un maillon
	*/
	public String toString()	{
		return this.value+" ";
	}
}