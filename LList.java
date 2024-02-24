package ListPackage;
import utils.Node;
public class LList<T> extends LinkedChainBase<T> implements ListInterface<T> {
	protected Node <T> firstNode;
	private Node <T> lastNode;
	private int numberOfEntries;

	@Override
	public void add(T newEntry) {
		Node <T> newNode = new Node(newEntry);
		if (isEmpty()) {
			firstNode = newNode;
		}else { // Add to end of nonempty list
			lastNode.setNext(newNode); // Make last node reference new node
		} // end if
		lastNode = newNode;
		numberOfEntries++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if((newPosition >= 1)&& (newPosition <= numberOfEntries + 1)) {
			Node <T> newNode = new Node(newEntry);
			if(newPosition == 1) {
				newNode.setNext(firstNode);
				firstNode = newNode;
			}else if (isEmpty()){
				firstNode = newNode;
                lastNode = newNode;
			}else {
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.getNext();
				newNode.setNext(nodeAfter);
				nodeBefore.setNext(newNode);
			}
			numberOfEntries++;
		}else {
			throw new IndexOutOfBoundsException(
				"Illegal poisition given to add operation.");
		}
		
	}
	
	protected Node getNodeAt(int givenPosition)
	{
	// Assertion: (firstNode != null) &&
	// (1 <= givenPosition) && (givenPosition <= numberOfNodes)
		Node currentNode = firstNode;
	 // Traverse the chain to locate the desired node
	 // (skipped if givenPosition is 1)
		for (int counter = 1; counter < givenPosition; counter++) {
			currentNode = currentNode.getNext();
		}
	// Assertion: currentNode != null
	 	return currentNode;
	} // end getNodeAt

	@Override
	public T remove(int givenPosition) {
		T result = null;
		if((givenPosition >=1) && (givenPosition <= numberOfEntries)) {
			if(givenPosition==1) {
				result = firstNode.getData();
				firstNode = firstNode.getNext();
				if (numberOfEntries == 1){
                    lastNode = null;
                }
			}else {
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.getNext();
				result = (T) nodeToRemove.getData(); // Save entry to be removed
				Node nodeAfter = nodeToRemove.getNext();
				nodeBefore.setNext(nodeAfter);
				if (givenPosition == numberOfEntries){
                    lastNode = nodeBefore;
                }
			}
			numberOfEntries--;
			return result;
			
		}else {
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
		}
		
	}
	
	@Override
    public boolean remove(T anEntry) {
        Node <T> prevNode = null, currNode = firstNode;
        while (currNode != null && !anEntry.equals(currNode.getData())){
            prevNode = currNode; currNode = currNode.getNext();
        }
        if (prevNode == null){
            removeFirstNode();
            return true;
        }
        if (currNode != null){
            removeNodeAfter(prevNode);
            return true;
        }
        return false;
    }

	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		 {
			assert !isEmpty();
			Node <T> desiredNode = getNodeAt(givenPosition);
			T originalEntry = desiredNode.getData();
			desiredNode.setData(newEntry);
			return originalEntry;
		 }
		 else {
			 throw new IndexOutOfBoundsException(
					 "Illegal position given to replace operation."); 
		 }
			 
	}

	@Override
	public T getEntry(int givenPosition) {
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		 {
			assert !isEmpty();
			return (T) getNodeAt(givenPosition).getData();
		 }else {
			 throw new IndexOutOfBoundsException(
					 "Illegal position given to replace operation."); 
		 }
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		if(numberOfEntries ==0) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node <T> currentNode = firstNode;
		while(!found && (currentNode!=null)) {
			if(anEntry.equals(currentNode.getData())) {
				found = true;
			}else {
				currentNode = currentNode.getNext();
			}
		}
		return found;
	}

	@Override
	public Object[] toArray() {
		// The cast is safe because the new array contains null entries
		 @SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		Node <T> currentNode = firstNode;
		while ((index < numberOfEntries) && currentNode != null) {
			result[index] = (T) currentNode.getData();
			currentNode = currentNode.getNext();
			index++;
		}
		 return result;
	}

	
}
