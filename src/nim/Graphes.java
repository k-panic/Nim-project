package nim;

public class Graphes	{
	
	/**
	 * classe ayant pour attribut une liste de noeuds
	 */
	public LC<Noeud> graphe;
	/**
	 * Constructeur qui cree une liste de noeuds et representant l'etat courant de notre jeu
	 *@param t est le nombre total d allumettes de notre plateau
	 */
	public Graphes(int t)	{
		this.graphe= new LC<Noeud>();
		for(int i=t; i>=1; i--)	{
			if(i==1)	this.graphe.addhead(new Noeud(i));
			if(i==2)	this.graphe.addhead(new Noeud(i,i-1));
			if(i==3)	this.graphe.addhead(new Noeud(i,i-1,i-2));
			if(i>3)	this.graphe.addhead(new Noeud(i,i-1,i-2,i-3));
		}
	} 
	/**
	 * Methode servant creer le noyau de notre graphe
	 */
	public void Noyau()	{
	
		DoublementChainee<Noeud> l= new DoublementChainee<Noeud>();
		l= l.transform(this.graphe);
		int t=0;MaillonDouble<Noeud> courant= l.head;MaillonDouble<Noeud> precedent=null;
		t=courant.info.value;
		if(courant.info.voisins.length==0){courant.info.marque=1; courant=courant.next;}
		while(courant!=null && courant.info.marque==0)	{
			if(search(t,courant.info.voisins))	{
				precedent=courant;
				courant.info.marque=-1;
				courant=courant.next;
			}
			if(courant!=null && !search(t,courant.info.voisins))	{
				while(!search(courant.info.value,precedent.info.voisins) && precedent.info.marque==-1)	{
					precedent=precedent.prev;
				}
				if(precedent.info.marque==1)	{
					
					courant.info.marque=1;
				}
				t= courant.info.value;
				courant= courant.next;
			}
		}
		courant=l.head;

		LC<Noeud> noyau= new LC<Noeud>();
		while(courant!=null)	{
			noyau.addhead(courant.info);
			courant=courant.next;
		}
		this.graphe=noyau;


	}

	/**
	*Methode qui permet de voir la presence d'un entier dans un tableau
	*@param v l entier a rechercher
	*@param t le tableau dans lequel on cherche l entier
	*return un boolean indiquant si v est dans t ou non
	*/

	public static boolean search(int v, int[] t)	{
		for(int i=0; i<t.length; i++)	{
			if(v==t[i])	return true;
		}
		return false;
	}
}

	

	
