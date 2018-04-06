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
			System.out.println(this.state.nbAl);	
			do	{

				l=n.getMove(this.player1.name);
				if(!this.validMove(l,this.state.board))	n.invalidMove(l);

			}while(!this.validMove(l,this.state.board));	
			this.state.supprimer(l);
			if(this.state.nbAl==1)	{n.showWinner(this.player1.name); return;}
			if(this.state.nbAl==0)	{n.showWinner(this.player2.name); return;}

			System.out.println(this.toString2());
			n.showBoard(this.state.board);
			System.out.println(this.state.nbAl);
			l=this.selectMoveMachine((int)( Math.random()*( this.state.board.length-1 - 1 + 1 ) ) + 1);	
			System.out.println("Suppression de "+l.allumettes+" allumettes sur la ligne "+l.ligne);
			this.state.supprimer(l);
			if(this.state.nbAl==1)	{n.showWinner(this.player2.name); return;}
			if(this.state.nbAl==0)	{n.showWinner(this.player1.name); return;}
			

	}
	
	public Move selectMoveMachine(int j)	{
		
		Graphe mongraphe= new Graphe();
		int t= this.state.nbAl;
		Move m= new Move(1,1);
		for(int i=t; i>0; i--)	{
			if(i==1)	mongraphe.graphe.addhead(new Noeud(i,false));
			if(i==2)	mongraphe.graphe.addhead(new Noeud(i,i-1,false));
			if(i==3)	mongraphe.graphe.addhead(new Noeud(i,i-1,i-2,false));
			if(i>3)	mongraphe.graphe.addhead(new Noeud(i,i-1,i-2,i-3,false));
		}
		mongraphe.Noyau();
		LC<Noeud> inverse= new LC<Noeud>();
		Maille<Noeud> yo= mongraphe.graphe.head;
		while(yo!=null)	{
			inverse.addhead(yo.value);
			yo=yo.next;
		}
		System.out.println(inverse);
		Maille<Noeud> current= inverse.head;
		int max;
		int v=0;
		while(current!= null)	{

			if(current.value.kerf && v==0)	{
				while(this.state.board[j]==0 && j>(this.state.board.length/2)+1)	{
					j--;
				}
				while(this.state.board[j]==0 && j<=(this.state.board.length/2)+1)	{
					j++;
				}
				m= new Move(j+1,(int)( Math.random()*( 3- 1 + 1 ) + 1));
			}
			if(current.value.kerf && v!=0)	{
				max=3;
				if(v>max)	v=max;
				while(this.state.board[j]==0  || j>this.state.board.length-1 || j<0 )	{
					j=(int)( Math.random()*( (this.state.board.length-1)- 1 + 1 ) + 1);
				}
				
				while(this.state.board[j]<v && this.state.board[j]!=0 && v>=1)	{
					v--;
				}
				m= new Move(j+1,v);
			return m;
			}
			v++;
			current=current.next;
		}
		return m;
			
	}		

	

	public String toString1()	{

		return "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>> \n Tour de "+this.player1.name+":\n";

	}

	public String toString2()	{
		
		return "<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>> \n Tour de "+this.player2.name+":\n";

	}
}
