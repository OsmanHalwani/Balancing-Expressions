

public class LinkedBag<T> implements LinkedBagInterface<T> {

	private Node firstNode;
	private int numberOfEntries;
	private int classSize = 30;

	@Override
	public int getCurrentSize() {

		return numberOfEntries;
	}

	public int getClassSize() {
		return classSize;
	}

	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public Node getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
	}

	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	public void setNumberOfEntries(int numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}

	@Override
	public boolean add(T newEntry) {
		boolean same = true;
		@SuppressWarnings("unchecked")
		Node newNode = (Node) new Node((Student) newEntry);
		Node currentNode = firstNode;
		if (isEmpty()) {
			newNode.setNext(firstNode); // setting my new Node to point to the firstNode(aka 2nd node now)
			firstNode = newNode; // make that my classes first Node point to my new Node
			numberOfEntries++;
			return true;
		}
		// checking to see if this entry is already there because no duplicates are
		// allowed
		while (currentNode.getNext() != null && same) {
			if (currentNode.getData().getStudentID() == newNode.getData().getStudentID()) {
				same = false;
			} else
				currentNode = currentNode.getNext();
		}
		if (same) {
			newNode.setNext(firstNode); // setting my new Node to point to the firstNode(aka 2nd node now)
			firstNode = newNode; // make that my classes first Node point to my new Node
			numberOfEntries++;
			return true;
		}
		return false;
	}

	// return true;
	// }

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		T result = null;
		if (firstNode != null) {
			result = (T) firstNode.getData(); // getting data for node to be removed
			firstNode = firstNode.getNext(); // setting my first node to what the original first node pointed to
			numberOfEntries--;

		}

		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		Node aNode = getReferenceTo(anEntry);
		if (aNode != null) {
			aNode.setData(firstNode.getData()); // switching data aka exchanging data
			firstNode = firstNode.getNext(); // removing first node
			numberOfEntries--;
			result = true;

		}
		return result;
	}

	private Node getReferenceTo(T entry) {
		boolean found = false;
		Node currentNode = firstNode;
		Student anEntry = new Student((Student) entry);
		while (!found && (currentNode != null)) {// running a loop to find entry
			if (anEntry.getStudentID() == (currentNode.getData().getStudentID()))
				found = true;
			else
				currentNode = currentNode.getNext(); // if not found move to nextNode
		}
		return currentNode;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while (!isEmpty())
			remove();
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		boolean found = false;
		Node currentNode = firstNode;
		Student entry = new Student((Student) anEntry);
		while (!found && (currentNode != null)) {// running a loop to find entry
			if (entry.getStudentID() == (currentNode.getData().getStudentID()))
				found = true;
			else
				currentNode = currentNode.getNext(); // if not found move to nextNode
		}
		if (found)
			return true;

		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		int i = 0;
		Node currentNode = firstNode;
		T[] placeHolder = (T[]) new Student[numberOfEntries]; // declaring array
		// transfering data into an array
		if (!isEmpty()) {
			while (currentNode != null) {
				placeHolder[i] = (T) currentNode.getData();
				currentNode = currentNode.getNext();
				i++;
			}

		}
		return placeHolder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeEntry(int index) {
		if (!isEmpty()) {
			boolean result = false;
			Node currentNode = firstNode;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.getNext();
			}
			@SuppressWarnings("rawtypes")
			Node returner = currentNode; // saving node in order to return
			currentNode.setData(firstNode.getData()); // switching data aka exchanging data
			firstNode = firstNode.getNext(); // removing first node
			numberOfEntries--;
			result = true;

			return (T) returner;
		}
		return null;

	}

	public void numOfStudentsInEachLevel() {

		int counterFreshman = 0;
		int counterSoph = 0;
		int counterJunior = 0;
		int counterSenior = 0;
		T[] arrayBag = toArray();
		// delaring counters and making each counter go up if this word appears in bag
		for (int i = 0; i < numberOfEntries; i++) {

			if (((Student) arrayBag[i]).getLevel().equalsIgnoreCase("freshman"))
				counterFreshman++;

			else if (((Student) arrayBag[i]).getLevel().equalsIgnoreCase("sophmore"))
				counterSoph++;

			else if (((Student) arrayBag[i]).getLevel().equalsIgnoreCase("junior"))
				counterJunior++;

			else if (((Student) arrayBag[i]).getLevel().equalsIgnoreCase("senior"))
				counterSenior++;

		}

		System.out.println("Freshman: " + counterFreshman + "\nSophmore: " + counterSoph + "\nJunior: " + counterJunior
				+ "\nSenior: " + counterSenior);

	}

	public boolean isMyClassFull() {
		if (numberOfEntries == this.classSize)
			return true;
		else
			return false;

	}
}
