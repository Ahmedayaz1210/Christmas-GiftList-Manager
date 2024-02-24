package ListPackage;

public interface GiftListInterface {
	void addGift(String gift);
	String toString();
    boolean removeGift(String gift);
    boolean containsGift(String gift);
    int getNumberOfGifts();
    String[] getGifts();
    
}
