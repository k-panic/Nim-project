public class Release_2	{

	public static void main(String[] args)	{

		ConsoleIA n= new ConsoleIA();
		BoardIA jeu= new BoardIA(new GameState(n.getSize()),ConsoleIA.askName(),new HumanPlayer("Machine"));
		
		do	{
			jeu.jouerTour();
		}while(jeu.state.nbAl>1);		
			
			
	}
}
