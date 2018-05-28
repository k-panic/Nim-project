package test;
import nim.Graphes;
import nim.Maillon;
import nim.Noeud;

import org.junit.Assert;
import org.junit.Test;




public class NoyauTest  {
	
	@Test()
	public void testConstructors_and_kernel()	{
		
		Graphes l= new Graphes(12);
		
		
		l.Noyau();boolean verifKer=true;
		Maillon<Noeud> current= l.graphe.head;
		while(current!=null)	{
			if(current.value.value%4-1== 0 && current.value.marque!=1)	verifKer=false;
			current= current.next;
		}
		
		Assert.assertEquals(true, verifKer);
	}

}
