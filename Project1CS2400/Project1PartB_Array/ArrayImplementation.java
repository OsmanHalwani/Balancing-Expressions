package ArrayListImpForProjectB;

public class ArrayImplementation<T> implements Stack<T> {

	public T[] array;
	private int numberOfEntries;
	private int capacity;

	@SuppressWarnings("unchecked")
	public ArrayImplementation() {

		numberOfEntries = 0;
		capacity = 10;
		array = (T[]) new Character[capacity];

	}

	
	
	@SuppressWarnings("unchecked")
	public ArrayImplementation(int size) {
		capacity = size;
		numberOfEntries = 0;
		array = (T[]) new Character[capacity];
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	@Override
	public void push(T newEntry) {
		if (isFull()) {
			increaseSize();

		}
		array[numberOfEntries] = newEntry;
		numberOfEntries++;
	}

	
	
	@Override
	public T pop() {
		T data = null;
		if(!isEmpty()) {
			data = array[numberOfEntries-1];
			array[numberOfEntries-1] = null;
			numberOfEntries--;
		}
		return data;
	}

	@Override
	public T peek() {
		T data = null;
		if(!isEmpty())
			data = array[numberOfEntries-1];
		return data;
	}

	@Override
	public boolean isEmpty() {

		return numberOfEntries == 0;

	}

	@Override
	public void clear() {
		while(numberOfEntries!=0) 
			pop();
		

	}

	public boolean isFull() {
		if (numberOfEntries >= array.length)
			return true;
		else
			return false;

	}

	public void increaseSize() {

		int newCapacity;
		// Method : increaseSize
		// Purpose : this method increases the size of an array
		if (capacity == 1)
			newCapacity = capacity * 6;

		else if (capacity == 2)
			newCapacity = capacity * 4;

		else
			newCapacity = capacity * 2; // increasing capacity
		// declaring a placeholder array
		@SuppressWarnings("unchecked")
		T[] placeHolder = (T[]) new Character[newCapacity];
		copyOfArray(placeHolder);

	}

	public void copyOfArray(T[] placeHolder) {
		// setting values of old array into new array
		for (int i = 0; i < numberOfEntries; i++)
			placeHolder[i] = array[i];
		// setting the new array
		array = placeHolder;

	}

}
