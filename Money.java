import java.io.Serializable;

/**
 * This class represents the US dollar in terms of dollars and cents. It allows
 * you to set the dollars and cents using the multiple contructors and mutators.
 * It also checks if two money objects are equal or not.
 * 
 * @author Jay Darshan Vakil
 * @version 03/08/2020
 */
public class Money implements Comparable<Money>, Cloneable, Serializable{
    // instance variables
    private int dollars;
    private int cents;

    /**
     * This is the first constructor of the class. It takes in no arguements and
     * sets the initial dollars and cents to 0.
     */
    public Money() {
        this(0, 0);
    }

    /**
     * This is the second constructor, it takes in a parameter, an amount for
     * dollars and sets the cents to 0.
     * 
     * @param dol The amount of dollars
     */
    public Money(int dol) {
        this.setCents(0);
        this.setDollars(dol);
    }

    /**
     * This is the third constructor, it takes in a dollars and a cents and assigns
     * it to the instance variables.
     * 
     * @param dol  The amount of dollars
     * @param cent The amount of cents
     */
    public Money(int dol, int cent) {
        this.setDollars(dol);
        this.setCents(cent);
    }

    /**
     * This is the last constructor, a copy constructor, it takes in a parameter
     * another Money object and assigns the instance variables from the other class
     * to the instance variables in this class.
     * 
     * @param other The other money object. 
     * 
     * PRECONDITIONS: The user will pass a valid and not null money object.
     * POSTCONDITIONS: The method will successfully copy the data from the other Money object.
     */
    public Money(Money other) {
        if (other != null) {
            this.setCents(other.getCents());
            this.setDollars(other.getDollars());
        } else {
            throw new IllegalArgumentException("Money cannot be null");
        }
    }

    /**
     * This is the getter for the amount of dollars
     * 
     * @return The amount of dollars
     */
    public int getDollars() {
        int tempDol = this.dollars;
        return tempDol;
    }

    /**
     * This is the getter for the number of cents
     * 
     * @return The number of cents
     */
    public int getCents() {
        int tempCent = this.cents;
        return tempCent;
    }

    /**
     * This is the setter for the dollar, it checks if the dollar is positive or
     * not.
     * 
     * @param newDollar The amount of dollars. 
     * 
     * PRECONDITIONS: The user will input an amount of dollar that is 0 or greater than 0.
     * POSTCONDITIONS: The method will set the new amount of dollars to this.dollars.
     */
    public void setDollars(int newDollar) {
        if (newDollar >= 0) {
            this.dollars = newDollar;
        } else {
            throw new IllegalArgumentException(" You cannot have negative dollars");
        }
    }

    /**
     * This is the setter for the cents, it checks if the cents is less then 0 or
     * greater than 99.
     * 
     * @param newCent The amount of cents 
     * 
     * PRECONDITIONS: The user will input an amount of cents that is 0 or greater than 0 and less than 99.
     * POSTCONDITIONS: The method will set the new amount of cents to this.cents.
     */
    public void setCents(int newCent) {
        if (newCent >= 0 && newCent < 100) {
            this.cents = newCent;
        } else {
            throw new IllegalArgumentException("Cents cannot be negative or more than 99");
        }
    }

    public void setMoney(int dol, int cent){
        if(dol >= 0 && cent >= 0 && cent <100){
            this.dollars = dol;
            this.cents = cent;
        } else{
            throw new IllegalArgumentException("Dollars and cents cannot exceed the monetary limits");
        }
    }

    /**
     * This returns the total money.
     * 
     * @return the total money
     */
    public double getMoney() {
        double totalMoney = (this.getCents()) / 100.0;
        totalMoney += this.getDollars();
        return totalMoney;
    }

    /**
     * This adds the new amount of dollar to the original dollars.
     * 
     * @param dol
     */
    public void add(int dol) {
        this.setDollars(this.getDollars() + dol);
    }

    /**
     * This method adds dollars and cents to the original amount of money.
     * 
     * @param dol
     * @param cent
     */
    public void add(int dol, int cent) {
        int tempDol = this.getDollars();
        int tempCent = this.getCents();

        tempDol += dol;
        tempCent += cent;

        if (tempCent >= 100) {
            tempDol++;
            tempCent -= 100;
        }
        this.setDollars(tempDol);
        this.setCents(tempCent);
    }

    /**
     * This method adds a money object to this class.
     * 
     * @param other
     * 
     * PRECONDITIONS: The user will enter a valid Money object
     * POSTCONDITIONS: The method will add two Money together
     */
    public void add(Money other) {
        if (other != null) {
            int tempDol = this.getDollars() + other.getDollars();
            int tempCent = this.getCents() + other.getCents();

            if (tempCent >= 100) {
                tempCent -= 100;
                tempDol++;
            }
            this.setDollars(tempDol);
            this.setCents(tempCent);
        }
    }

    /**
     * This is the equals method for this class. It compares this Money object to another Money object and returns true or false
     * depending if they are equal or not.
     *
     * @param other
     * @return
     * 
     * PRECONDITIONS: The user will pass a valid and not null money object
     * POSTCONDITIONS: The method will check if the two objects are equal or not
     */
    public boolean equals(Money other) {
        boolean res = false;
        if (other != null) {
            if (this.getDollars() == other.getDollars()) {
                if (this.getCents() == other.getCents()) {
                    res = true;
                }
            } else {
                res = false;
            }
        } else {
            throw new IllegalArgumentException("Money cannot be null");
        }

        return res;
    }

    /**
     * This outputs the class into a string.
     */
    @Override
    public String toString() {
        String res = "US$" + this.getMoney();
        return res;
    }

    @Override
    /**
     * This method is like the equal method except it returns 1 or 0.
     * @param o
     * @return
     */
    public int compareTo(Money o) {
        int ret = 0;
        if(this.equals(o)){
            ret = 1;
        }
        return ret;
    }

    @Override
    /**
     * This is the clone method, it copies the data from this class the new object.
     */
    public Money clone(){
        Money temp = null;
        try {
            temp = (Money)super.clone();
        } catch(CloneNotSupportedException e){
			throw new InternalError("Clone failed, please try again...");
        }
        return temp;
    }
}