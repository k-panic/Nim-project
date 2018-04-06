class Board	{

	public GameState state;
	public HumanPlayer player1;
	public HumanPlayer player2;
	Console n= new Console();

	public Board(GameState state, HumanPlayer player1, HumanPlayer player2)	{

		this.state= state;
		this.player1= player1;
		this.player2= player2;
		
	}

	public boolean validMove(Move l, int[] tab)	{
		int total= (tab.length*tab.length);
		if(l.ligne>tab.length || 0>= l.ligne || l.allumettes> tab[l.ligne-1] || l.allumettes>3 || l.allumettes<=0 || (total-l.allumettes<1))	{

			return false;
		}
		return true;
	}

	public void jouerTour()	{
		Move l;
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

			do	{

				l=n.getMove(this.player2.name);
				if(!this.validMove(l,this.state.board))	n.invalidMove(l);

			}while(!this.validMove(l,this.state.board));	
			this.state.supprimer(l);
			if(this.state.nbAl==1)	{n.showWinner(this.player2.name);}
			if(this.state.nbAl==0)	{n.showWinner(this.player1.name);}

	}

	

	public String toString1()	{
		//String str="";

		return "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>> \n Tour de "+this.player1.name+":\n";

		//str+= state.toString();

		 //str;
	}

	public String toString2()	{
		//String str="";

		return "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>> \n Tour de "+this.player2.name+":\n";

		//str+= state.toString();

		 //str;
	}
}