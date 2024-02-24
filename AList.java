package ListPackage;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;


public class AList<T> implements ListInterface<T> {
	private T[] list;
	private int numberOfEntries;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;
	
	@SuppressWarnings("unchecked")
	public AList( int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		else
			checkCapacity (capacity);
		this.capacity = capacity;
		list = (T[]) new Object[capacity];
		numberOfEntries = 0;
	}
		
	public AList () {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void add(T anEntry) {
		if (anEntry == null) {
			throw new IllegalArgumentException();
		}
		list[numberOfEntries] = anEntry;
		numberOfEntries++;
		ensureCapacity();
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if (newEntry == null) {
			throw new IllegalArgumentException();
		}
		if (newPosition < 0 || newPosition > numberOfEntries) {
			throw new IndexOutOfBoundsException();
		}
		makeRoom (newPosition);
		list[newPosition] = newEntry;
		numberOfEntries ++;
		ensureCapacity();
		
	}

	@Override
	public T remove(int givenPosition) {
		T theEntry;
		if (givenPosition < 0 || givenPosition >= numberOfEntries) {
			throw new IndexOutOfBoundsException("Illegal Position given to remove operation");
		}
		theEntry = list[givenPosition];
		removeGap(givenPosition);
		numberOfEntries--;
		return theEntry;
	}
	
	@Override
    public boolean remove(T anEntry) {
        for (int idx = 0; idx < numberOfEntries; idx++){
            if (anEntry.equals(list[idx])){
                removeGap(idx);
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

	

	@Override
	public void clear() {
	    for (int i = 0; i < numberOfEntries; i++) {
	        list[i] = null;
	    }
	    numberOfEntries = 0;
	}


	@Override
	public T replace(int givenPosition, T newEntry) {
	    if (givenPosition < 0 || givenPosition > numberOfEntries) {
	        throw new IndexOutOfBoundsException();
	    }
	    
	    T originalEntry = list[givenPosition];
	    list[givenPosition] = newEntry;
	    
	    return originalEntry;
	}


	@Override
	public T getEntry(int givenPosition) {
	    if (givenPosition < 0 || givenPosition > numberOfEntries) {
	        throw new IndexOutOfBoundsException("Invalid Index");
	    }
	    return list[givenPosition];
	}


	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)){
			if (anEntry.equals(list[index])) {
				found = true;
			}
			index++;
		} 
		return found;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[numberOfEntries];
		for (int idx = 0; idx < numberOfEntries; idx ++) {
			result[idx] = list[idx];
			
		}
		return result;
	}
	
	private void checkCapacity(int capacity) {
		if(capacity >= MAX_CAPACITY) {
			throw new RejectedExecutionException("Capacity too big");
		}
	}
	
	private void ensureCapacity() {
		if (isFull()) {
			capacity *= 2;
			checkCapacity (capacity); // too big ?
			list = Arrays.copyOf(list, capacity);
		}
	}
	private boolean isFull() {
		return (numberOfEntries == capacity);
	}
	
	private void makeRoom (int newPosition) {
		assert(newPosition >= 0 && newPosition <= numberOfEntries);
		for(int idx = numberOfEntries; idx > newPosition; idx--) {
			list[idx] = list[idx-1];
		}
	}
	
	private void removeGap(int givenPosition) {
		assert (givenPosition >= 0 && givenPosition < numberOfEntries);
		for (int index = givenPosition; index < numberOfEntries; index ++) {
			list[index] = list[index+1];
		}
	}
	public T set(int givenPosition, T newEntry){
        return replace(givenPosition, newEntry);
    }
    public T get(int givenPosition){
        return getEntry(givenPosition);
    }

}
