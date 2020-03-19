
public interface BagInterface<T> {

	public int getCurrentSize();
	
	public boolean isEmpty();
	
	public boolean add(T newEntry);
	
	public T remove();
	
	public boolean remove(T anEntry);
	
	public void clear();
	/// no need for this method because each student instance only occurs once
	//public int getFrequencyOf(T anEntry);
	
	public void increaseSize();
	
	public boolean contains(T anEntry);
	
	public T[] toArray();
	
	public T[] getArrayBag();
	
	public void copyOfArray(T[] placeHolder);
	
	public int getIndexOfEntry(T anEntry);
	
	public T removeEntry(int index);
		
	
}
