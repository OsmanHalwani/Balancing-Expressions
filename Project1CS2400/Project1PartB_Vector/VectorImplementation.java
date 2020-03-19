package VectorImplementation;
import java.util.EmptyStackException;
import java.util.Vector;

public final class VectorImplementation <T>implements Stack<T> {

	private Vector<T> stack;
	private static final int MAX_CAPACITY = 10000;
	
	
		public VectorImplementation() {
			stack = new Vector<T>();
			stack.setSize(0);
		}
	@Override
	public void push(T newEntry) {
		if(stack.size() != MAX_CAPACITY)
			stack.add(newEntry);
			
	}

	@Override
	public T pop() {
		if(isEmpty())
			throw new EmptyStackException();
		else
			return stack.remove(stack.size()-1);
		
	}

	@Override
	public T peek() {
		
			return stack.lastElement();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		stack.clear();
		// TODO Auto-generated method stub
		
	}
 
	
	
}
