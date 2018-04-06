public class Main	{

	public static void main(String[] args)	{

		Console n= new Console();
		
		Board jeu= new Board(new GameState(n.getSize()),Console.askName(1),Console.askName(2));
		
		do	{

			jeu.jouerTour();

		}while(jeu.state.nbAl>1);		
			
	}
}