package ListPackage;

public class GiftsList implements GiftListInterface{
	private AList<String> gifts;
	
	public GiftsList(){
		gifts = new AList<>();
	}

	@Override
	public void addGift(String gift) {
		gifts.add(gift);
	}

	@Override
	public boolean removeGift(String gift) {
		return gifts.remove(gift);
	}

	@Override
	public boolean containsGift(String gift) {
		return gifts.contains(gift);
	}

	@Override
	public int getNumberOfGifts() {
		return gifts.getLength();
	}

	@Override
	public String[] getGifts() {
		Object[] gift = gifts.toArray();
		String[] giftStrings = new String[gift.length];
		for (int i = 0; i < gift.length; i++) {
			giftStrings[i] = (String) gift[i];
		}
		return giftStrings;
	}
	
	@Override
    public String toString() {
        String[] giftStrings = getGifts();
        if (giftStrings.length == 0) {
            return "No gifts";
        }
        return String.join(", ", giftStrings);
    }

}
