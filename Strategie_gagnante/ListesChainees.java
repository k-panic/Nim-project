class Maille<T>	{
	public T value;
	public Maille<T> next;

	public Maille(T x, Maille<T> l)	{
		this.value= x;
		this.next= l;
	}

	public String toString()	{
		return this.value+" ";
	}
}

class LC<T>	{

	public Maille<T> head;

	public LC()	{
		this.head= null;
	}

	public void addhead(T x)	{

		Maille<T> m= new Maille<T>(x,this.head);
		this.head= m;
	}

	public T elemhead()	{

			return this.head.value;

	}

	public boolean estListeVide()	{

		return this.head== null;
	}

	public boolean isIn(T x)	{

		Maille<T> current= this.head;

		while(current != null)	{
			if(current.value.equals(x))
				return true;

			current= current.next;
		}
		return false;
	}

	public LC<T> delete1Oc(T x)	{

		LC<T> l= this;boolean find;
		if(!l.isIn(x))	return l;

		Maille<T> current= l.head, prev= null;
		find= false;
		while(current!= null && !current.value.equals(x))	{

			prev= current;
			current= current.next;
		}

		if(current!= null)	{
			if(prev!=null)	prev.next= current.next;
			
		}
		return l;


	}

	public LC<T> deleteAll(T x)	{

		while(this.isIn(x))	delete1Oc(x);
		return this;
	}

	public int longListe()	{
		Maille<T> current= this.head;
		int t=0;
		while(current!=null)	{
			t++;
			current= current.next;
		}
		return t;
	}

	public Maille<T> maillonAleatoire(int i)	{
		Maille<T> current=this.head;
		int t=0;
		while(t<i)	{
			current= current.next;
			t++;
		}
		return current;
	}

	public LC<T> copy()	{
		LC<T> l= new LC<T>();
		Maille<T> current= this.head,m;
		l.head= new Maille<T>(this.head.value,null);
		m= l.head;
		while(current.next!=null)	{
			m.next= new Maille<T>(current.next.value,null);
			current= current.next;
			m=m.next;
		}

		return l;
	}


	public String toString()	{
		String str= "";

		Maille<T> m= this.head;
		while (m!=null) {
			str += m.value+" ";
			m= m.next;
		}

		return str;
	}

}
