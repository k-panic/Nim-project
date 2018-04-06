import java.util.*;

class ConsoleIA	{

	static Scanner in= new Scanner(System.in);

	

	public int getSize()	{

		System.out.print("Donner le nombre de lignes du plateau:\n -> ");
		return in.nextInt();

	}	

	public  Move getMove(String name)	{ 
		Scanner inmove= new Scanner(System.in);
		int [] inputtab;
		System.out.println("<- Tour du joueur : "+name+"   ->");
		System.out.print("Donnez le numero de la ligne suivi du nombre d'allumette: ");
		
		String input=inmove.nextLine();
		input = input.replaceAll("[^\\d.]", " ");
		StringTokenizer st = new StringTokenizer(input);
		int i=0;
		inputtab=new int[st.countTokens()];
		while (st.hasMoreTokens()) {
			
			inputtab[i]=Integer.parseInt(st.nextToken());
			
		 	i++;
		}
		
		if(inputtab.length <= 1){
			System.out.println("Invalide move");
			return getMove(name);
		}
		
		
		if(inmove == null){
			inmove.close();
		}
		return new Move(inputtab[0],inputtab[1]);

	}

	
	public  void showBoard(int[] board)    { 

        for(int ligne=0; ligne<board.length; ligne++){
        	if(ligne>-1 && ligne<9){
        		System.out.print("Ligne "+(ligne+1)+"  :");
        	}
        	else{
        		System.out.print("Ligne "+(ligne+1)+" :");
        	}
            int nball=board[ligne];
            for(int espace=0;espace<(board.length-ligne+2);espace++){
                System.out.print(" ");
            }
            while(nball !=0){
                System.out.print("|");
                nball--;
            }
            for(int espace=0;espace<=((ligne*2)-board[ligne]);espace++){
            	System.out.print(" ");
            }
            for(int espace=0;espace<(board.length-ligne+2);espace++){
                System.out.print(" ");
            }
            //affiche le nombre d'all restante par ligne//
            if(board[ligne]==0){}
            else if(board[ligne]==1){
            	System.out.print(board[ligne]+"  : Allumette");
            }
            else if(board[ligne]>1 && board[ligne]<10){
            	System.out.print(board[ligne]+"  : Allumettes");
            }
            else{
            	System.out.print(board[ligne]+" : Allumettes");
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
