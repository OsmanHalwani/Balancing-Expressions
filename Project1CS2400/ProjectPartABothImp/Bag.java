
public class Bag<T extends Student> implements BagInterface<T> {

	private int numberOfEntries;
	private final int DEFAULT_CAP = 10;
	private int capacity;
	private T[] arrayBag;
	private boolean integrityOK = true;
	private static final int MAX_CAPACITY = 100;
	

	

	public static int getMaxClassSize() {
		return MAX_CAPACITY;
	}

	// Constructor for bag
	public Bag() {
		numberOfEntries = 0;
		capacity = DEFAULT_CAP;
		@SuppressWarnings("unchecked")
		T[] placeholder = (T[]) new Student[capacity];
		arrayBag = placeholder;

	}

	public Bag(int capacity) {
		numberOfEntries = 0;
		if (capacity == 0)
			this.capacity = capacity + 1;
		else
			this.capacity = capacity;
		// look at this
		@SuppressWarnings("unchecked")
		T[] placeholder = (T[]) new Student[capacity];
		arrayBag = placeholder;

	}

	// checking if class room is full
	public boolean isMyClassFull() {
		if (numberOfEntries == this.MAX_CAPACITY)
			return true;
		else
			return false;

	}

	// is this array full
	public boolean isFull() {
		if (numberOfEntries >= capacity)
			return true;
		else
			return false;

	}

	public void increaseSize() {
		checkIntegrity();
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
		T[] placeHolder = (T[]) new Student[newCapacity];
		copyOfArray(placeHolder);

	}

	public void copyOfArray(T[] placeHolder) {
		// setting values of old array into new array
		for (int i = 0; i < numberOfEntries; i++)
			placeHolder[i] = arrayBag[i];
		// setting the new array
		arrayBag = placeHolder;

	}

	public void numOfStudentsInEachLevel() {

		int counterFreshman = 0;
		int counterSoph = 0;
		int counterJunior = 0;
		int counterSenior = 0;
		// delaring counters and making each counter go up if this word appears in bag
		for (int i = 0; i < numberOfEntries; i++) {

			if (arrayBag[i].getLevel().equalsIgnoreCase("freshman"))
				counterFreshman++;

			else if (arrayBag[i].getLevel().equalsIgnoreCase("sophmore"))
				counterSoph++;

			else if (arrayBag[i].getLevel().equalsIgnoreCase("junior"))
				counterJunior++;

			else if (arrayBag[i].getLevel().equalsIgnoreCase("senior"))
				counterSenior++;

		}

		System.out.println("Freshman: " + counterFreshman + "\nSophmore: " + counterSoph + "\nJunior: " + counterJunior
				+ "\nSenior: " + counterSenior);

	}

	public T[] getArrayBag() {
		return arrayBag;
	}

	public void setArrayBag(T[] arrayBag) {
		this.arrayBag = arrayBag;
	}

	public int getCurrentSize() {
		checkIntegrity();
		return numberOfEntries;
	}

	public boolean isEmpty() {

		return numberOfEntries == 0;
	}

	public boolean add(T newEntry) {
		boolean same = true;
		checkIntegrity();
		if (isFull())
			increaseSize();
		// making sure that no id is repeated in my bag that is no duplicates
		for (int i = 0; i < numberOfEntries && same; i++)
			if (newEntry.getStudentID() == arrayBag[i].getStudentID())
				same = false;
		// if no duplicates then add my entry
		if (same) {
			arrayBag[numberOfEntries] = newEntry;
			numberOfEntries++;
			return true;
		}
		return false;
	}

	public T remove() {

		@SuppressWarnings("unchecked")
		T temp = (T) new Student(arrayBag[numberOfEntries - 1]); // getting student at end of bag
		this.removeEntry(numberOfEntries - 1);// removing last entry
		return temp;
	}

	public int getIndexOfEntry(T anEntry) {
		int i = 0;

		// if first entry is true
		if (arrayBag[0].getStudentID() == anEntry.getStudentID())
			return 0;

		// checking other entries if true return the index
		// if the object is not present return -1
		while (arrayBag[i].getStudentID() != anEntry.getStudentID() && i < numberOfEntries - 1) {
			i++;
			if (arrayBag[i].getStudentID() == anEntry.getStudentID())
				return i;

		}
		return -1;

	}

	public boolean remove(T anEntry) {
		checkIntegrity();
		int index;
		if (!isEmpty()) { // checking if empty
			index = getIndexOfEntry(anEntry); // getting index of the entry
			T result = removeEntry(index); // removing index
			return anEntry.equals(result); // Returning my boolean
		}
		return false;

	}

	public void moveElements(int index) {

		this.arrayBag[index] = arrayBag[numberOfEntries];

	}

	public void clear() {

		while (!isEmpty())
			remove();

	}

	// no need for this method because each student instance only occurs once
	/*
	 * public int getFrequencyOf(T anEntry) {
	 * 
	 * return 0; }
	 */
	// Purpose: Checks if an element is in my list

	public boolean contains(T anEntry) {
		for (int i = 0; i < numberOfEntries; i++)// running in array
			if (arrayBag[i].getStudentID() == anEntry.getStudentID())// comparing ids
				return true;

		return false;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Student[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++) {
			result[i] = arrayBag[i];
		}
		return result;
	}

	public void checkIntegrity() {
		if (!integrityOK)
			throw new SecurityException("ArrayBag Object is corrupt");
	}

	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	public void setNumberOfEntries(int numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}

	public T removeEntry(int index) {
		// This method will remove a specified index
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			T Entry = (T) new Student(arrayBag[index]); // getting student at given index
			arrayBag[index] = null; // removing data
			removeGap(index);
			numberOfEntries--;
			return Entry;
		} else
			return null;
	}

	public void removeGap(int index) {

		arrayBag[index] = arrayBag[numberOfEntries - 1]; // setting my given index to contain the value at the end of my
															// array
		arrayBag[numberOfEntries - 1] = null; // setting the end of my array to null

	}

}
