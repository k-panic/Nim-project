package nim;
public class Noeud	{
	
	/**
	 * Classe servant a creer le noeud d'un graphe
	 */
	public int value;
	public int[] voisins;
	public int marque;
	/**
	 * Constructeur creant un noeud sans voisin 
	* et qui le marque a 0: etat qui signifie qu on ne sait pas si il est dans le noyau ou pas
	 * @param value represente la valeur du noeud dans le cas de notre jeu la situation actuelle
	 */
	public Noeud(int value)	{
		this.value= value;
		this.voisins= new int[0];
		this.marque= 0;
		
	}

	/**
	 * Constructeur creant un noeud avec un seul voisin
	 * @param value represente la valeur du noeud dans le cas de notre jeu la situation actuelle
	 * @param link est le voisin du noeud a creer
	 */
	public Noeud(int value, int link)	{
		this.value= value;
		this.voisins= new int[1];
		this.voisins[0]= link;
		this.marque= 0;
	}
	
	/**
	 * Constructeur creant un noeud avec deux voisins
	 * @param value represente la valeur du noeud dans le cas de notre jeu la situation actuelle
	 * @param link1 est le premier voisin du noeud a creer il representera la situation ou l'on a supprime une seule allumette
	 * @param link2 est le deuxieme voisin du noeud a creer il representera la situation ou l'on a supprime deux allumettes
	 */

	public Noeud(int value, int link1, int link2)	{
		this.value= value;
		this.voisins= new int[2];
		this.voisins[0]= link1;
		this.voisins[1]= link2;
		this.marque= 0;
	}
	
	/**
	 * Constructeur creant un noeud avec trois voisins
	 * @param value value represente la valeur du noeud dans le cas de notre jeu la situation actuelle
	 * @param link1 est le premier voisin du noeud a creer il representera la situation ou l'on a supprime une seule allumette
	 * @param link2 est le deuxieme voisin du noeud a creer il representera la situation ou l'on a supprime deux allumettes
	 * @param link3 est le troisieme voisin du noeud a creer il representera la situation ou l'on a supprime trois allumettes
	 */

	public Noeud(int value, int link1, int link2, int link3)	{
		this.value= value;
		this.voisins= new int[3];
		this.voisins[0]= link1;
		this.voisins[1]= link2;
		this.voisins[2]= link3;
		this.marque= 0;
	}
	
	
	/**
	 * Cette methode represente un graphe dont chaque noeud a ses voisins et a un booleen indiquant si il est dans le noyau ou pas
	 */
	public String toString()	{
		String str="";
		str+="["+this.value+";";
		for(int i=0; i<this.voisins.length; i++)	{
			if(i<this.voisins.length-1)
			str+= this.voisins[i]+",";
		else
			str+=this.voisins[i]+"";

		}
		str+=" | "+this.marque+" ]";
		return str;
	}

}
