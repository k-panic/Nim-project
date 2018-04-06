import java.util.Scanner;

class ConsoleIA	{

	static Scanner in= new Scanner(System.in);

	

	public int getSize()	{

		System.out.print("Donner le nombre de lignes du plateau:\n -> ");
		return in.nextInt();

	}	

	public  Move getMove(String name)	{

		int m,n;
		System.out.print("Donnez le numero de la ligne:\n-->  ");
		m=in.nextInt();
		System.out.print("Donnez le nombre d'allumettes à retirer:\n--> ");
		n=in.nextInt();

		return new Move(m,n);
	}

	
	public  void showBoard(int[] board)	{

		
		int p=2*(board.length-1)+1, j;
		for(int i=0; i<board.length; i++)	{
			j=0;
			System.out.print("Ligne "+(i+1)+":");
			while(j<p-i)	{
				System.out.print(" ");
				j++;
			}
			
			for(int ii=j; ii<j+board[i]; ii++)	{
				System.out.print("|");
				
			}
			System.out.println();

			
		}
	}

	public void invalidMove(Move l)	{

			System.out.println("Vous ne pouvez pas supprimer "+l.allumettes+" allumettes sur la ligne "+l.ligne);

	}

	public static HumanPlayer askName()	{

		System.out.print("Donnez votre nom:\n--> ");

		return new HumanPlayer(in.next());
	}

	public void showWinner(String name)	{

		System.out.println("Le gagnant de cette partie est: "+name);

	}




	
}