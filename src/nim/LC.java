package nim;

/**
*class permettant de creer et de manipuler des listes chainees
*/

public class LC<T>	{

	public Maillon<T> head;

	/**
	*Constructeur qui cree une liste chainee vide
	*/

	public LC()	{
		this.head= null;
	}

	/**
	*Methode qui permet d ajouter une valeur en tete de liste
	*@param x est la valeur a ajouter
	*/
	public void addhead(T x)	{

		Maillon<T> m= new Maillon<T>(x,this.head);
		this.head= m;
	}

	/**
	*Methode qui nous permet d avoir l element en tete de liste
	*@return la valeur du maillon en tete de la liste
	*/
	public T elemhead()	{

			return this.head.value;

	}
	/**
	*Verifie si une liste contient des elements ou non
	*@return le booleen qui indique si une liste est vide ou non
	*/
	public boolean estListeVide()	{

		return this.head== null;
	}
	/**
	*Recherche la valeur x dans la liste
	*@param x est la valeur a chercher dans la liste
	*@return un booleen indiquant si x est dans la liste ou non
	*/
	public boolean isIn(T x)	{

		Maillon<T> current= this.head;

		while(current != null)	{
			if(current.value.equals(x))
				return true;

			current= current.next;
		}
		return false;
	}

	

	/**
	*Calcule la longueur de la liste
	*@return la longeur de la liste
	*/
	public int longListe()	{
		Maillon<T> current= this.head;
		int t=0;
		while(current!=null)	{
			t++;
			current= current.next;
		}
		return t;
	}

	/**
	*Renvoie un maillon de la liste
	*@param i est la position du maillon a retourner
	*@return le maillon a la position i donne en parametre
	*/

	public Maillon<T> maillonAleatoire(int i)	{
		Maillon<T> current=this.head;
		int t=0;
		while(t<i)	{
			current= current.next;
			t++;
		}
		return current;
	}

	

	/**
	*@return une string qui est l'affichage de la liste
	*/
	public String toString()	{
		String str= "";

		Maillon<T> m= this.head;
		while (m!=null) {
			str += m.value+" ";
			m= m.next;
		}

		return str;
	}

}
