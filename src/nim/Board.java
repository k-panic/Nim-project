package nim;



/**
 * 
 * cette classe represente le plateau de jeu et reunit les differents elements d un jeu : 
 *  les joueurs et l etat courant 
 *
 */
public class Board	{

	public GameState state;
	public HumanPlayer player1;
	public HumanPlayer player2;
	static Move l;
	
	/**
	 * 
	 * @param state represente l etat du jeu
	 * @param player1 represente le premier joueur
	 * @param player2 represente le second joueur ordinateur
	 * constructeur qui cree un jeu et gere les differents joueurs
	 **/

	public Board(GameState state, HumanPlayer player1, HumanPlayer player2)	{

		this.state= state;
		this.player1= player1;
		this.player2= player2;
		
	}
	

	/**
	 *  la methode validMove permet de verifier que l utilisateur fasse un move valide
	 *  
	 * @param l  est le coup saisi par l utilisateur
	 * @param tab represente le tableau dont la case i represente le nombre d allumettes de la ligne i de la pyramide
	 * @return retourne un booleen qui indique si le move est valide ou non 
	 */
	public boolean validMove(Move l, int[] tab)	{

		int total= (tab.length*tab.length);
		if(l.ligne>tab.length || 0>=l.ligne || l.allumettes> tab[l.ligne-1] || l.allumettes>3 || l.allumettes<=0 || (total-l.allumettes<1))	{
	
			return false;
		}
		return true;

	}

	/**
	 * Cette methode permet de faire jouer les deux joueurs et verifie s il reste une ou 0 allumette affiche le nom du gagnant
	 * 
	 */
	public void jouerTour()	{
		
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>\nTour de: "+this.player1);
		Console.showBoard(this.state.board);	
		System.out.println("Nombre total d'allumettes: "+this.state.nbAl);	
		do	{

			l=Console.getMove(this.player1.name);
			if(!this.validMove(l,this.state.board))	Console.invalidMove(l);

		}while(!this.validMove(l,this.state.board));	
		this.state.supprimer(l);
		if(this.state.nbAl==1)	{Console.showWinner(this.player1.name); return;}
		if(this.state.nbAl==0)	{Console.showWinner(this.player2.name); return;}

		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>\nTour de: "+this.player2);
		Console.showBoard(this.state.board);
		System.out.println(this.state.nbAl);
		l=this.selectMoveMachine((int)( Math.random()*( this.state.board.length-1 - 1 + 1 ) ) + 1);	
		System.out.println("Suppression de "+l.allumettes+" allumettes sur la ligne "+l.ligne);
		this.state.supprimer(l);
		if(this.state.nbAl==1)	{Console.showWinner(this.player2.name); return;}
		if(this.state.nbAl==0)	{Console.showWinner(this.player1.name); return;}
		
	}
	
	/**
	 * Cette methode permet d indiquer a la machine de selectionner le coup qui lui permet de rentrer dans le noyau du graphe( cree en se basant sur toutes 
	 * les possibilites du jeu) representant
	 * les coups gagnants et s il n ya pas de possibilite d entrer dans le noyau il joue un coup d attente 
	 * @param j represente ligne par defaut sur laquelle il doit retirer
	 * 
	 * @return m represente le coup choisi par l ordinateur
	 */
	
	public Move selectMoveMachine(int j)	{
		
		Graphes legraphe= new Graphes(this.state.nbAl);
		Move m= new Move(1,1);
		legraphe.Noyau();
		//System.out.println(legraphe.graphe);
		Maillon<Noeud> current= legraphe.graphe.head;
		//System.out.println(legraphe.graphe);
		int max;
		int v=0;
		while(current!= null)	{

			if(current.value.marque==1 && v==0)	{
				while(this.state.board[j]==0)	{
					j=(int)( Math.random()*( (this.state.board.length-1)- 1 + 1 ) + 1);
				}
				return new Move(j+1,(int)( Math.random()*( 3- 1 + 1 ) + 1));
			}
			if(current.value.marque==1 && v!=0)	{
				max=3;
				if(v>max)	v=max;
				LC<Integer> possibilities=verify(v,this.state.board); 
				while(possibilities.estListeVide())	{
					v--;
					possibilities=verify(v,this.state.board);
				}
				
				j=possibilities.maillonAleatoire((int)( Math.random()*( possibilities.longListe()))).value;
				return new Move(j+1,v);
			
			}
			v++;
			current=current.next;
		}
		return m;
			
	}
	
	/**
	 * 
	 * Ce sous programme cree une liste des cases du tableau dans lesquelles il est possible de retirer v allumettes
	 * \n Il permet a la suite de verifier s il n ya aucune ligne dans laquelle on peut enlever v on decremente v
	 * @param v represente le nombre d allumettes a retirer
	 * @param tab represente le plateau de jeu
	 * @return une liste des lignes sur lesquelles on peut retirer v allumettes
	 */
	public static LC<Integer> verify(int v,int[] tab)	{
		LC<Integer> list= new LC<Integer>();
		for(int i=0; i<tab.length; i++)	{
			if(tab[i]-v>=0)
				list.addhead(i);
		}
		return list;
	}		

}
