package ListPackage;
import utils.Node;

public class LinkedSortedList<T extends Comparable <? super T>> extends LinkedChainBase <T> implements SortedListInterface <T>{

	
	public LinkedSortedList() {
		super();
	}

    @Override
    public void addEntry(T newEntry) {
        Node <T> before = getNodeBefore(newEntry);
        Node <T> toInsert = new Node<>(newEntry);
        if (before == null)
            addFirstNode(toInsert);
        else
            addNodeAfter(before, toInsert);
    }
	
	private Node <T>getNodeBefore(T anEntry)
	{
	 Node <T> currentNode = getNodeAt(0);
	 Node <T> nodeBefore = null;
	 while ( (currentNode != null) &&
	 (anEntry.compareTo(currentNode.getData()) > 0) )
	 {
		 nodeBefore = currentNode;
		 currentNode = currentNode.getNext();
	 } // end while
	 return nodeBefore;
	}

	@Override
    public boolean removeEntry(T anEntry) {
       if (isEmpty())
           return false;
       Node <T> before = getNodeBefore(anEntry);
       if (before == null){
           if (anEntry.equals(getNodeAt(0).getData())){
               removeFirstNode();
               return true;
           }
           return false;
       }
       Node <T> nextNode = before.getNext();
       if (nextNode == null)
           return false;
       if (anEntry.equals(nextNode.getData())){
           removeNodeAfter(before);
           return true;
       }
       return false;
    }


	@Override
    public int getPosition(T anEntry) {
        int position = 0;
        int length = getLength();
        Node <T> currNode = getNodeAt(0);
        int compValue = 0;
        while (position < length){
            compValue = anEntry.compareTo(currNode.getData());
            if (compValue > 0){
                position ++;
                currNode = currNode.getNext();
            }
            else
                break;
        }
        if (position >= length || compValue != 0)
            position = -1 - position;
        return position;
    }

	@Override
    public boolean contains(T anEntry) {
        return false;
    }


}
