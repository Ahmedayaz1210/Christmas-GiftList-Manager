package ListPackage;

import java.util.Arrays;

import utils.Name;

public class NiceList<T extends Comparable<T>> implements NiceListADT<T> {
    private SortedListInterface<Name> niceList;
    private ListInterface<String> giftsList;
    

    public NiceList() {
        niceList = new SortedAList<>();
        giftsList = new AList<>();
    }

    @Override
    public void addToNiceList(Name name, GiftListInterface gifts) {
    	niceList.addEntry(name);
    	giftsList.add(gifts.toString());
    }

    @Override
    public void removeFromNiceList(Name name) {
        niceList.removeEntry(name);
    }



    @Override
    public boolean contains(Name name) {
        return niceList.contains(name);
    }

    @Override
    public boolean isNiceListEmpty() {
        return niceList.isEmpty();
    }

    @Override
    public void clearNiceList() {
        niceList.clear();
    }

    @Override
    public int getNiceListSize() {
        return niceList.getLength();
    }

	

	@Override
	public Name[] getNiceList() {
		Object[] niceListArray = niceList.toArray();
        Name[] names = Arrays.copyOf(niceListArray, niceListArray.length, Name[].class);
        return names;
	}

	
	@Override
	public int getPosition(Name name) {
		return niceList.getPosition(name);
	}

	@Override
	public Name getName(int givenPosition) {
		return niceList.getEntry(givenPosition);
		
	}

	

	
}
