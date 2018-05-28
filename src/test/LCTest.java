package test;
import static org.junit.Assert.assertEquals;
import nim.LC;

import org.junit.Test;

public class LCTest {

	@Test
	public void test() {
		
		LC<Integer> l= new LC<Integer>();
		l.addhead(1);
		l.addhead(2);
		l.addhead(3);
		l.addhead(4);
		l.addhead(5);
		l.addhead(6);
		l.addhead(7);
		l.addhead(8);
		l.addhead(9);
		l.addhead(10);
		boolean tete= (l.head.value==10);
		boolean elemhead= (l.elemhead()==10);
		boolean taille= (l.longListe()==10);
		boolean valeur= (l.maillonAleatoire(5).value== 5);
		assertEquals(true, tete);
		assertEquals(true, elemhead);
		assertEquals(true, taille);
		assertEquals(true, valeur);
		

	}

}
