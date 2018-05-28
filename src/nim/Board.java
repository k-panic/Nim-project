package nim;



/**
 * 
 * cette classe represente le plateau de jeu et reunit les differents elements du jeu : 
 *  les joueurs ( humain et ia) et l etat courant 
 *
 */
public class Board	{
	/**
	 * GameState state  represente l'etat du jeu
	 *  HumanPlayer player1  represente le joueur humain
	 *  HumanPlayer player2 represente la machine(IA)
	 * Console n= new Console() permet d'appeller la classe console et de l'utiliser 
	 */

	public GameState state;
	public HumanPlayer player1;
	public HumanPlayer player2;
	static Move l;

	/**
	 * 
	 * @param state represente l'etat du jeu
	 * @param player1 represente le joueur humain
	 * @param player2 represente la machine(IA)
	 */
	public Board(GameState state, HumanPlayer player1, HumanPlayer player2)	{

		this.state= state;
		this.player1= player1;
		this.player2= player2;
		
	}
	
	
	/**
	 *  la methode validMove permet de verifier que l'utilisateur fasse un move valide
	 *  
	 * @param l  est le coup saisi par l'utilisateur
	 * @param tab represente le tableau dont la case i represente le nombre d'allumettes de la ligne i de la pyramide
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
	 * Cette methode permet de faire jouer les deux joueurs et verifie s'il reste une ou 0 allumette affiche le nom du gagnant
	 * 
	 */
	public void jouerTour()	{
		
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>\nTour de: "+this.player1);
		Console.showBoard(this.state.board);		
			do	{

				l=Console.getMove(this.player1.name);
				if(!this.validMove(l,this.state.board))	Console.invalidMove(l);

			}while(!this.validMove(l,this.state.board));	
			this.state.supprimer(l);
			if(this.state.nbAl==1)	{Console.showWinner(this.player1.name); return;}
			if(this.state.nbAl==0)	{Console.showWinner(this.player2.name); return;}
		System.out.println("<<<<<<<<<<<<<<<>>>>>>>>>>>>>\nTour de: "+this.player2);
		Console.showBoard(this.state.board);		

			l=this.selectMoveMachine();	
			System.out.println("Suppression de "+l.allumettes+" allumettes sur la ligne "+l.ligne);
			this.state.supprimer(l);
			if(this.state.nbAl==1)	{Console.showWinner(this.player2.name); return;}
			if(this.state.nbAl==0)	{Console.showWinner(this.player1.name); return;}

	}
	
	/**
	 * Methode qui cree une liste de tous les coups possibles et choisi un coup aleatoire pour l'IA   
	 * @return m le coup qui sera joue par la machine
	 */
	
	public Move selectMoveMachine()	{
		LC<Move> l= new LC<Move>();
		Move m;
		
		int max;
		for(int i=0;i<this.state.board.length; i++)	{
			max=3;
			do{
				m= new Move((i+1),max);
				if(this.validMove(m,this.state.board))
					l.addhead(m);
				max--;
			}while(this.validMove(m,this.state.board) || max>=1);
			
		}

		int k= (int)(Math.random()*l.longListe());
		Maillon<Move> coup= l.maillonAleatoire(k-1);
		m=new Move(coup.value.ligne,coup.value.allumettes);
		
		return m;
			
	}		
}
