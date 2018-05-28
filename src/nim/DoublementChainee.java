package nim;


public class DoublementChainee<T>	{

	public MaillonDouble<T> head;
	public MaillonDouble<T> tail;

	public DoublementChainee()	{
		this.head= null;
		this.tail= null;
	}
	
	
	
	public DoublementChainee<T> transform(LC<T> t)	{

		DoublementChainee<T> ld= new DoublementChainee<T>();
		MaillonDouble<T> m;
		Maillon<T> current= new Maillon<T>(t.head.value,t.head.next);
		ld.head= new MaillonDouble<T>(null,current.value,null);
		m=ld.head;

		while(current.next!= null)	{
			m.next= new MaillonDouble<T>(m,current.next.value,null);
			m=m.next;
			current= current.next;

		}
		return ld;

	}
}
