import java.util.Arrays;

/**
 * This class is designed to replicate the interface of an ArrayList. This class
 * is taken from my previous hw, data structures and it has been modified.
 * 
 * @author Jay Darshan Vakil
 * @version 03/09/2020
 */
public class ArrayList<T> {

    private Object[] arrayList;// the output arrayList
    private int numOfElements;// the number of elements

    /**
     * The empty constructor of the class, it takes in no argument and sets the
     * arrayList to an initial length of 1 just so there is enough room to insert
     * and remove elements.
     * 
     */
    public ArrayList() {
        this.arrayList = new Object[1];
        this.numOfElements = 0;
    }

    public ArrayList(int size){
        this.arrayList = new Object[size];
        this.numOfElements = 0;
    }

    /**
     * This is the full constructor of the Arraylist. It takes in an array as
     * arguement and validates if the length of the array is greater than 0.
     * 
     * @param array the array in form of ArrayList.
     */
    public ArrayList(Object[] array) {
        if (array.length > 0) {
            this.arrayList = new Object[array.length];
            this.numOfElements = this.arrayList.length;
            System.arraycopy(array, 0, this.arrayList, 0, this.numOfElements);
        } else {
            throw new IllegalArgumentException("ArrayList length is not valid...");
        }
    }

    /**
     * This is the insert method for the class. It takes in an object to be inserted
     * in the ArrayList and at which index as an arguement. It validates if the
     * object is not null and the index is greater than 0 and lesser than the size.
     * 
     * @param obj   the object to be added to the arrayList
     * @param index the index at which the object is to be added PRECONDITIONS: The
     *              user will insert a valid object at a valid index POSTCONDITIONS:
     *              The object will be added at the desired index successfully.
     */
    public void insert(T obj, int index) {
        if (obj != null && index >= 0 && index < this.size()) {
            // my friend helped me with this if statement and the bitwise operator right
            // shift.
            if (this.numOfElements == this.size()) {
                this.arrayList = Arrays.copyOf(this.arrayList, this.size() + 1);
            }
            System.arraycopy(this.arrayList, index, this.arrayList, index + 1, (this.size() - 1) - index);
            this.arrayList[index] = obj;
        } else {
            throw new IllegalArgumentException("The object is null or the index is out of bounds...");
        }
    }

    /**
     * This method removes an object from the arrayList and returns the removed
     * value. I got help from my friend and online for this method, I went through
     * the steps and understood how and why it works and then wrote it down.
     * 
     * @param index the index of the object to be removed
     * @return the object removed PRECONDITIONS: The user will pass a valid index
     *         withing the range of the array. POSTCONDITIONS: The object at the
     *         given index will be removed and returned.
     */
    public Object remove(int index) {
        T removedObject = null;// if the index is not found
        if (index >= 0 && index < this.size()) {// validation if the index is out of range.
            removedObject = (T) this.arrayList[index];// sets the removed value to a variable to be returned
            this.numOfElements--;// decreases the number of elements as one element is removed
            System.arraycopy(this.arrayList, index + 1, this.arrayList, index, this.numOfElements - index);// copies the
                                                                                                           // array to
                                                                                                           // itself
            // minus the removed element
        } else {
            throw new IllegalArgumentException("Index is out of bounds, please try again...");
        }
        return removedObject;
    }

    /**
     * This method returns the size of the arrayList.
     * 
     * @return
     */
    public int size() {
        return this.arrayList.length;
    }

    /**
     * This method returns the object at a given index.
     * 
     * @param index the index of the object to be returned.
     * @return the object at the given index PRECONDITIONS: The user will enter a
     *         valid index POSTCONDITIONS: The object will be returned
     */
    public Object get(int index) {
        T ret = null;
        if (index >= 0 && index < this.size()) {
            ret = (T) this.arrayList[index];
        }
        return ret;
    }

    /**
     * This method checks if the arrayList is empty.
     * 
     * @return true of false if the arraylist is empty
     */
    public boolean isEmpty() {
        boolean res = false;
        if (this.size() > 0) {
            for (Object object : arrayList) {
                if (object == null) {
                    res = true;
                    break;
                } else {
                    res = false;
                }
            }
        } else {
            res = false;
        }
        return res;
    }

    /**
     * This method returns the index of an object, or -1 if the object is not found.
     * 
     * @param obj the object whose index is returned
     * @return PRECONDITION: The user will enter an object that is not null
     *         POSTCONDITION: The method will return the appropriate index.
     */
    public int indexOf(T obj) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (this.arrayList[i] == obj) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * this method tests if two ArrayLists are equal or not.
     * 
     * @param otherArrayList the other arrayList to be compared and determined if
     *                       they are equal or not
     * @return equal or not. PRECONDITIONS: The user will enter a valid Arraylist
     *         with valid elements POSTCONDITIONS: The method will successfully
     *         check if two arraylists are equal or not
     */
    public boolean equals(ArrayList<T> otherArrayList) {
        boolean res = false;
        if (this.size() == otherArrayList.size()) {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i) == otherArrayList.get(i)) {
                    res = true;
                } else {
                    res = false;
                }
            }
        } else {
            res = false;
        }
        return res;
    }

    /**
     * This is the toString method that outputs the class in a string form.
     */
    @Override
    public String toString() {
        String res = "[ ";
        for (int i = 0; i < this.numOfElements; i++) {
            if (this.arrayList[i] != null) {
                res += this.arrayList[i] + " ";
            }
        }
        res += "]";
        return res;
    }
}