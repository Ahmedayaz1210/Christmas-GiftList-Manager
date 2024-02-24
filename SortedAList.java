package ListPackage;

public class SortedAList<T extends Comparable<? super T>> extends AList<T> implements SortedListInterface<T> {
	
	public SortedAList() {
		super ();
	}
	@Override
	public void addEntry(T newEntry) {
		int newPosition = getPosition (newEntry);
		if (newPosition < 0) {
			newPosition = -newPosition - 1;
		}
		super.add (newPosition, newEntry);
		
	}

	@Override
	public boolean removeEntry(T anEntry) {
		int position = getPosition (anEntry);
		if (position >= 0){
			remove (position);
			return true;
		}
		return false;
	}

	@Override
	public int getPosition(T anEntry) {
		int position = 0;
		int compValue = 0;
		int length = getLength();
		while (position < length ) {
			compValue = anEntry.compareTo (getEntry(position));
			if (compValue <= 0) {
				break;
			}
			position ++;
		}
		if (position == length || compValue < 0)
		position = -1 - position;
		return position;
	}

	@Override
	public boolean contains(T anEntry) {
		int low = 0;
		int high = getLength() - 1;
		int mid;
		int compValue;
		do {
			mid = (low+high)/2;
			compValue = anEntry.compareTo(getEntry(mid));
			if(compValue == 0) {
				return true;
			}else if(compValue > 0) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}while(low <= high);
		return false;
	}
	
	

}
