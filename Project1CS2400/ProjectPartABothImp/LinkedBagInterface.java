
public interface LinkedBagInterface<T> {

public int getCurrentSize();
	
	public boolean isEmpty();
	
	public boolean add(T newEntry);
	
	public T remove();
	
	public boolean remove(T anEntry);
	
	public void clear();
	/// no need for this method because each student instance only occurs once
	//public int getFrequencyOf(T anEntry);

	
	public boolean contains(T anEntry);
	
	public T[] toArray();

	
	
	
	public T removeEntry(int index);
		
}
