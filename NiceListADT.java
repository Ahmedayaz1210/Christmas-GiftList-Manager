package ListPackage;

import utils.Name;

public interface NiceListADT<T extends Comparable<T>> {
    /**
     * Adds a person to the nice list with their name and a list of gifts.
     *
     * @param name  The name of the person to add.
     * @param gifts The list of gifts for the person.
     */
    void addToNiceList(Name name, GiftListInterface gifts);

    /**
     * Removes a person from the nice list.
     *
     * @param name The name of the person to remove from the nice list.
     */
    void removeFromNiceList(Name name);

    public Name getName(int givenPosition);
    public int getPosition(Name name);

    /**
     * Checks if a person is on the nice list.
     *
     * @param name The name of the person to check.
     * @return True if the person is on the nice list, false otherwise.
     */
    boolean contains(Name name);

    /**
     * Checks if the nice list is empty.
     *
     * @return True if the nice list is empty, false otherwise.
     */
    boolean isNiceListEmpty();

    /**
     * Clears the nice list, removing all people from it.
     */
    void clearNiceList();

    /**
     * Gets the total number of people on the nice list.
     *
     * @return The number of people on the nice list.
     */
    int getNiceListSize();

	/**
	 * gives the name of people in nice list
	 * @return- an array of people in nice list
	 */

	Name[] getNiceList();
	
	
}

