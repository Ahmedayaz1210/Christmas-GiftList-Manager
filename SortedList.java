package ListPackage;
import utils.Node;
public class SortedList<T extends Comparable<? super T>> extends LList<T> implements SortedListInterface<T>
{

	@Override
	public void addEntry(T newEntry) {
		int newPosition = Math.abs(getPosition(newEntry));
		super.add(newPosition, newEntry);
		
	}

	@Override
	public boolean removeEntry(T anEntry) {
		int position = getPosition(anEntry);
        if (position > 0) {
            super.remove(position);
            return true;
        }
        return false;
	}

	@Override
	public int getPosition(T anEntry) {
		int position = 1;
        Node currentNode = firstNode;
        while (currentNode != null && anEntry.compareTo((T) currentNode.getData()) > 0) {
            currentNode = currentNode.getNext();
            position++;
        }
        return position;
	}

	@Override
	public boolean contains(T anEntry) {
		int position = getPosition(anEntry);
        return position > 0;
	}

}
