class GameState	{

	public int[] board;
	public int nbAl;
	

	public GameState(int n)	{

		this.board= new int[n];
		for(int i=0; i<board.length;i++)	{
			this.board[i]=2*i+1;
			this.nbAl +=this.board[i];
		}
	}

	public void supprimer(Move l)	{
		
		int t=0;
		while(t<l.allumettes)	{
		
			
			
				if(this.board[l.ligne-1]>0)	{
					this.board[l.ligne-1]--;
					this.nbAl--;
				}

				t++;
				
				
				if(t==l.allumettes)	break;
		
		}
		
	}
		

	

	
}