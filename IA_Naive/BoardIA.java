class Maillon<T>	{
	public T value;
	public Maillon<T> next;

	public Maillon(T x, Maillon<T> l)	{
		this.value= x;
		this.next= l;
	}
}

class Liste<T>	{

	public Maillon<T> head;

	public Liste()	{
		this.head= null;
	}

	public void addhead(T x)	{

		Maillon<T> m= new Maillon<T>(x,this.head);
		this.head= m;
	}
	public T elemhead()	{

			return this.head.value;

	}
	
	public int longListe()	{
		Maillon<T> current= this.head;
		int t=0;
		while(current!=null)	{
			t++;
			current= current.next;
		}
		return t;
	}	
	
	public Maillon<T> maillonAleatoire(int i)	{
		Maillon<T> current=this.head;
		int t=0;
		while(t<i)	{
			current= current.next;
			t++;
		}
		return current;
	}


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

class BoardIA	{

	public GameState state;
	public HumanPlayer player1;
	public HumanPlayer player2;
	ConsoleIA n= new ConsoleIA();
	static Move l;

	public BoardIA(GameState state, HumanPlayer player1, HumanPlayer player2)	{

		this.state= state;
		this.player1= player1;
		this.player2= player2;
		
	}
	
	public static String toString(Liste<Move> l)	{
		String str= "";

		Maillon<Move> m= l.head;
		while (m!=null) {
			str += "("+m.value.ligne+","+m.value.allumettes+") ";
			m= m.next;
		}

		return str;
	}

	public boolean validMove(Move l, int[] tab)	{
		int total= (tab.length*tab.length);
		if(l.ligne>tab.length || 0>=l.ligne || l.allumettes> tab[l.ligne-1] || l.allumettes>3 || l.allumettes<=0 || (total-l.allumettes<1))	{
	
			return false;
		}
		return true;
	}

	public void jouerTour()	{
		
		System.out.println(this.toString1());
			n.showBoard(this.state.board);		
			do	{

				l=n.getMove(this.player1.name);
				if(!this.validMove(l,this.state.board))	n.invalidMove(l);

			}while(!this.validMove(l,this.state.board));	
			this.state.supprimer(l);
			if(this.state.nbAl==1)	{n.showWinner(this.player1.name);}
			if(this.state.nbAl==0)	{n.showWinner(this.player2.name);}
			System.out.println(this.toString2());
			n.showBoard(this.state.board);		

			l=this.selectMoveMachine();	
			System.out.println("Suppression de "+l.allumettes+" allumettes sur la ligne "+l.ligne);
			this.state.supprimer(l);
			if(this.state.nbAl==1)	{n.showWinner(this.player2.name);}
			if(this.state.nbAl==0)	{n.showWinner(this.player1.name);}

	}
	
	public Move selectMoveMachine()	{
		Liste<Move> l= new Liste<Move>();
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

		System.out.println(toString(l));

		int k= (int)(Math.random()*l.longListe());
		System.out.println(k);
		Maillon<Move> dep= l.maillonAleatoire(k-1);
		m=new Move(dep.value.ligne,dep.value.allumettes);
		
		System.out.println(l.longListe());
		System.out.println("line: "+m.ligne);
		return m;
			
	}		

	

	public String toString1()	{

		return "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>> \n Tour de "+this.player1.name+":\n";

	}

	public String toString2()	{
		
		return "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>> \n Tour de "+this.player2.name+":\n";

	}
}
