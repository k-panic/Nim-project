
import java.util.*;

class Noeud	{
	public int value;
	public int[] voisins;
	public boolean kerf;

	public Noeud(int value,boolean b)	{
		this.value= value;
		this.voisins= new int[0];
		this.kerf= b;
		//this.voisins[0]= link;
	}

	public Noeud(int value, int link, boolean b)	{
		this.value= value;
		this.voisins= new int[1];
		this.voisins[0]= link;
		this.kerf= b;
	}

	public Noeud(int value, int link1, int link2,boolean b)	{
		this.value= value;
		this.voisins= new int[2];
		this.voisins[0]= link1;
		this.voisins[1]= link2;
		this.kerf= b;
	}

	public Noeud(int value, int link1, int link2, int link3,boolean b)	{
		this.value= value;
		this.voisins= new int[3];
		this.voisins[0]= link1;
		this.voisins[1]= link2;
		this.voisins[2]= link3;
		this.kerf= b;
	}
	public static LC<Noeud> Noyau(LC<Noeud> l)	{
		LC<Noeud> noeuds= new LC<Noeud>();
		Maille<Noeud> current= l.head;
		int p=0;
		while(p<l.longListe())	{
			noeuds.addhead(l.maillonAleatoire(p).value);
			p+=4;
		}
		return noeuds;
	}

	public String toString()	{
		String str="";
		str+="["+this.value+";";
		for(int i=0; i<this.voisins.length; i++)	{
			if(i<this.voisins.length-1)
			str+= this.voisins[i]+",";
		else
			str+=this.voisins[i]+"";

		}
		str+=" | "+this.kerf+" ]";
		return str;
	}

}

class Graphe	{
	public LC<Noeud> graphe;

	public Graphe()	{
		this.graphe= new LC<Noeud>();
	} 

	public void Noyau()	{

		LC<Noeud> ker= Noeud.Noyau(this.graphe);
		//System.out.println(ker);
		Maille<Noeud> current= ker.head;
		Maille<Noeud> current1;

		while(current!= null)	{
			current1= this.graphe.head;
			while(current1!=null)	{
				if(current.value.value==current1.value.value)	current1.value.kerf=true;
				current1= current1.next;
			}
			current= current.next;
		}
	}
}

	

	
