package test;
import static org.junit.Assert.assertEquals;
import nim.Board;
import nim.GameState;
import nim.HumanPlayer;
import nim.Move;

import org.junit.Assert;
import org.junit.Test;


public class BoardTest {
	
	@Test
	public void verifconstructor()	{
		
		HumanPlayer player1= new HumanPlayer("Barry");
		HumanPlayer player2= new HumanPlayer("Machine");
		
		Board n= new Board(new GameState(6),player1,player2);
		
		boolean total_allum= (n.state.nbAl== 6*6);
		boolean taille_tab= (n.state.board.length==6);
		boolean name_1= (n.player1.name=="Barry");
		boolean name_2= (n.player2.name=="Machine");
		assertEquals(true,total_allum);
		assertEquals(true,taille_tab);
		assertEquals(true,name_1);
		assertEquals(true,name_2);
		
		
	}
	
	@Test
	public void validmove()	{
		
		HumanPlayer player1= new HumanPlayer("Barry");
		HumanPlayer player2= new HumanPlayer("Machine");
		
		Board n= new Board(new GameState(6),player1,player2);
		
		Move l= new Move(3,3);
		Move v= new Move(1,3);
		
		
		
		
		boolean valid= n.validMove(l, n.state.board);
		boolean invalid= n.validMove(v, n.state.board);
		
		Assert.assertTrue("si le move est valide",valid);
		Assert.assertFalse("si le move est invalide", invalid);
	}

}
