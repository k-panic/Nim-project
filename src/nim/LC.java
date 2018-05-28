package nim;
/**
 * classe Liste permettant de definir et gerer une liste chainee 
 */
public class LC<T>	{
	

	/**
	 * head represente le maillon de tete de la liste 
	 */
	public Maillon<T> head;
	

	/**
	 * constructeur cree une liste vide
	 */
	public LC()	{
		this.head= null;
		
	}

	/**
	 * permet d ajouter un element en tete 
	 * @param x est l'element à ajouter en tete de la liste
	 */
	public void addhead(T x)	{
		

		Maillon<T> m= new Maillon<T>(x,this.head);
		this.head= m;
	}
	/**
	 * Methode permettant de recuperer l element en tete de liste 
	 * @return l element de tete
	 */
	public T elemhead()	{

			return this.head.value;

	}
	
	/**
	 * Determine la longueur de la liste
	 * @return longueur de la liste 
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
	 * Cette methode ramene a partir d un entier i donné le i-eme maillon de la liste
	 * @param i est l entier representant le numero du maillon a retourner
	 * @return le maillon dont le numero est i
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
	 * Methode toString() affichage d'une liste
	 * 
	 * @return une chaine de caractere representant la liste
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
