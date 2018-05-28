package test;
import nim.Move;

import org.junit.Assert;
import org.junit.Test;



public class MoveTest  {
	
	@Test
	
	public void test()	{
		
		Move m= new Move(1,3);
		
		boolean res= (m.ligne==1 && m.allumettes==3);
		
		Assert.assertEquals(true, res);
	}

}
