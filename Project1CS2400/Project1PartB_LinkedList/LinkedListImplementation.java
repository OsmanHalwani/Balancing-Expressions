package linkedListProject1PartB;

public class LinkedListImplementation <T> implements Stack<T> {
	private Node firstNode;
	private int numberOfEntries=0;
	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		 
			@SuppressWarnings("unchecked")
			Node newNode = new Node(newEntry);
			Node currentNode = firstNode;
			if (isEmpty()) { 
				newNode.setNext(firstNode); // setting my new Node to point to the firstNode(aka 2nd node now)
				firstNode = newNode; // make that my classes first Node point to my new Node
				numberOfEntries++;
				//return true;
			}
		
			else {
				newNode.setNext(firstNode); // setting my new Node to point to the firstNode(aka 2nd node now)
				firstNode = newNode; // make that my classes first Node point to my new Node
				numberOfEntries++;
			}
		
		}

	

	@Override
	public T pop() {
		
			
		
		@SuppressWarnings("rawtypes")
        T x;
		if(numberOfEntries == 1) {
			@SuppressWarnings("unchecked")
			T d = (T) firstNode.getData();
			firstNode = null;
			numberOfEntries--;
			return d;
		}
		else {
			  x = (T) firstNode.getData();
			 firstNode = firstNode.getNext();
			 numberOfEntries--;
		}
			
			
		return (T) x;
		
	}
	

	@Override
	public T peek() {
		T d = (T) firstNode.getData();
		
		return d;
	}

	@Override
	public boolean isEmpty() {
		
		return numberOfEntries == 0;
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			pop();
		}
		// TODO Auto-generated method stub
		
	}

}
