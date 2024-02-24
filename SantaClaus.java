package ListPackage;

import utils.Name;

public class SantaClaus {
    private NiceListADT<Name> niceList;
    private AList<Name> naughtyList;
    private AList<GiftListInterface> niceGiftsList;
    // You can use String as the gift type for simplicity; you can change it to a more suitable type.
    
    public SantaClaus() {
        niceList = new NiceList<>();
        naughtyList = new AList<>();
        niceGiftsList = new AList<>();
    }
 


    public void addToNiceList(Name person, String theirGift) {
    	if (niceList.contains(person)){
            int personIndex = niceList.getPosition(person);
            niceGiftsList.get(personIndex).addGift(theirGift);
        }else {
        	GiftListInterface newGiftList = new GiftsList();
            newGiftList.addGift(theirGift);
            niceList.addToNiceList(person, newGiftList);
            niceGiftsList.add(newGiftList);
        }
    }
    public void giveGift(Name person, String gift){
        if (niceList.contains(person)){
            int personIndex = niceList.getPosition(person);
            niceGiftsList.get(personIndex).addGift(gift);
        }
    }

    public void removeFromNiceList(String firstName, String lastName) {
        Name name = new Name(firstName, lastName);
        niceList.removeFromNiceList(name);
        System.out.println(name + " has been removed from the nice list.");
    }

    public void addToNaughtyList(Name name) {
    	naughtyList.add(name);
    }

    public void removeFromNaughtyList(String firstName, String lastName) {
        Name name = new Name(firstName, lastName);
        naughtyList.remove(name);
        System.out.println(name + " has been removed from the naughty list.");
    }

    public void clearNiceList() {
        niceList.clearNiceList();
        System.out.println("The nice list has been cleared.");
    }

    public void clearNaughtyList() {
    	naughtyList.clear();
        System.out.println("The naughty list has been cleared.");
    }

    public void printNiceList() {
        if (niceList.isNiceListEmpty()) {
            System.out.println("The nice list is empty.");
        } else {
        	for (int i = 0; i < niceList.getNiceListSize(); i++){
                Name person = niceList.getName(i);
                GiftListInterface gifts = niceGiftsList.get(i);
                System.out.println(person + ": " + gifts);
            }
        }
    }

    public void printNaughtyList() {
    	for (int i = 0; i < naughtyList.getLength(); i++){
            Name person = naughtyList.get(i);
            System.out.println(person);
        }
    }
    
	
}
