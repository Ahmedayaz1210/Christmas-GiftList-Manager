package ListPackage;
import utils.Node;
abstract class LinkedChainBase<T> {
	private Node<T> head;
	private int numberOfEntries;
	
	public LinkedChainBase() {
		initializeDataFields();
	}
	protected final void initializeDataFields () {
		head = null;
		numberOfEntries = 0;
	}
	
	
	public boolean isEmpty () {
		if (numberOfEntries == 0 ^ head == null) {
			throw new IllegalStateException ("Corrupted chain");
		}
		return head == null;
	}
	
	
	public Object [] toArray() {
		Object [] result = new Object[numberOfEntries];
		Node <T> currNode = head;
		for (int idx = 0; idx < numberOfEntries; idx ++) {
			result[idx] = currNode.getData();
			currNode = currNode.getNext();
		}
		return result;
	}
		
	public int getLength() {
		return numberOfEntries;
	}
	
	public void clear() {
		numberOfEntries = 0;
		head = null;
	}
	
	public T getEntry (int givenPosition) {
		if (givenPosition < 0 || givenPosition >= numberOfEntries)
            throw new IndexOutOfBoundsException("Wrong position for search");
		return getNodeAt(givenPosition).getData();
	}
	
	
	
	protected final void addFirstNode (Node <T> toAdd) {
		toAdd.setNext (head);
		head = toAdd;
		numberOfEntries ++;
	}
	
	protected final void addNodeAfter (Node <T> currNode, Node <T>toAdd) {
		toAdd.setNext (currNode.getNext());
		currNode.setNext (toAdd);
		numberOfEntries ++;
	}
	
	protected Node<T> getNodeAt (int position) {
		if (position < 0 || position >= numberOfEntries) {
			throw new IndexOutOfBoundsException("Searching outside the chain");
		}
		int index = 0;
		Node <T> currNode = head;
		while (index < position) {
			currNode = currNode.getNext();
			index ++;
		}
		return currNode;
	}
	protected final Node <T> getFirstNode()
	{
		return head;
	} 
	
	public T remove (int givenPosition) {
		if (givenPosition < 0 || givenPosition >= numberOfEntries)
            throw new IndexOutOfBoundsException("Wrong position for removing");
		Node <T> toRemove;
		if (givenPosition == 0) {
			toRemove = removeFirstNode();
		}
		else {
			Node <T> prevNode = getNodeAt(givenPosition - 1);
			toRemove = removeNodeAfter(prevNode);
		}
		return toRemove.getData();
	}
	
	protected final Node<T> removeNodeAfter(Node<T> nodeBefore) {
		if (nodeBefore == null || nodeBefore.getNext() == null) {
            throw new IllegalArgumentException("Invalid node or no node after it to remove.");
        }
        
        Node<T> removedNode = nodeBefore.getNext();
        nodeBefore.setNext(removedNode.getNext());
        numberOfEntries--;
        return removedNode;
	}

	protected final Node<T> removeFirstNode() {
        if (head == null) {
            throw new IllegalStateException("The chain is empty, cannot remove the first node.");
        }
        
        Node<T> removedNode = head;
        head = head.getNext();
        numberOfEntries--;
        return removedNode;
    }
	
	
}
