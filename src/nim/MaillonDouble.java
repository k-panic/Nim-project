package nim;

public class MaillonDouble<T>	{
	public MaillonDouble<T>	prev;
	public T info;
	public MaillonDouble<T> next;

	public MaillonDouble(MaillonDouble<T> prev, T info, MaillonDouble<T> next)	{
		this.prev= prev;
		this.info= info;
		this.next= next;
	}

	public String toString()	{
		return this.info+" ";
	}

}