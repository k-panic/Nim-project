package test;
import static org.junit.Assert.assertEquals;
import nim.GameState;
import nim.Move;

import org.junit.Test;


public class GameStateTest  {
	
	@Test
	public void verifGameState()	{
		GameState n= new GameState(10);
		//verifie que le constructeur fait un tableau contenant les valeurs voulues
		boolean verifnbAl= true;
		for(int i=0 ; i<n.board.length;i++)	{
			if(n.board[i]!=2*i+1)	verifnbAl= false;
		}
		Move l= new Move(3,3);
		int t=n.board[l.ligne-1];int v=n.nbAl;
		n.supprimer(l);
		//verifie que la suppression est bien faite
		boolean taille_tab= (n.board.length>0);
		boolean taille= (n.board.length==10);
		boolean after_remove= (n.board[l.ligne-1]==t-l.allumettes);
		boolean total_allum_remove= (n.nbAl== v-l.allumettes);
		boolean  total_allum= (v==10*10);
		
		assertEquals(true,verifnbAl);
		assertEquals(true,taille_tab);
		assertEquals(true,taille);
		assertEquals(true,after_remove);
		assertEquals(true,total_allum_remove);
		assertEquals(true,total_allum);
		
		
		
		
		
	}

}
