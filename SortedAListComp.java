package ListPackage;

public class SortedAListComp <T extends Comparable <? super T>> implements SortedListInterface <T>{
    private AList<T> list;
    public SortedAListComp(){
        list = new AList<>();
    }

    public static void main(String[] args){

    }

    @Override
    public void addEntry(T newEntry) {
        int pos = getPosition(newEntry);
        if (pos < 0){
            pos = -pos - 1;
        }
        list.add(pos, newEntry);
    }

    @Override
    public boolean removeEntry(T anEntry) {
        int pos = getPosition(anEntry);
        if (pos >=0){
            list.remove(pos);
            return true;
        }
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        int pos = 0;
        int compValue = 0;
        int length = list.getLength();
        while (pos < length) {
            compValue = anEntry.compareTo(list.getEntry(pos));
            if (compValue <= 0)
                break;
            pos++;
        }
        if (pos == length || compValue < 0)
            pos = -1 -pos;
        return pos;
    }

    @Override
    public T getEntry(int givenPosition) {
        return list.getEntry(givenPosition);
    }

    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    @Override
    public T remove(int givenPosition) {
        return list.remove(givenPosition);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int getLength() {
        return list.getLength();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }
}
