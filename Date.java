import java.io.Serializable;

/**
 * This class represents a Date with the members day, month and year, it also implements comparable, cloneable and serializable class 
 * to implement the methods compareTo and clone methods.
 * 
 * @author Jay Darshan Vakil
 * @version 03/09/2020
 */
public class Date implements Comparable<Date>, Cloneable, Serializable{

    private int day, month, year;
    /**
     * The empty constructor for the class.
     */
    public Date(){
        this.setDay(1);
        this.setMonth(1);
        this.setYear(2020);
    }

    /**
     * This is the full constructor for the class, it takes in a date in form of its day, month and year.
     * @param d
     * @param m
     * @param y
     */
    public Date(int m, int d, int y){
        this.setDay(d);
        this.setMonth(m);
        this.setYear(y);
    }

    /**
     * This is the copy constructor for the class. it copies the data from another date class.
     * @param other
     */
    public Date(Date other){
        this.setDay(other.getDay());
        this.setMonth(other.getMonth());
        this.setYear(other.getYear());
    }
    /**
     * This is the getter for the month
     * 
     * @return the month.
     * POSTCONDITION: The month will be returned
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * This is the getter for the day 
     * 
     * @return The day
     * POSTCONDITION: The day will be returned
     */
    public int getDay() {
        return this.day;
    }

    /**
     * This is the getter for the year 
     * 
     * @return The year
     * POSTCONDITION: The year will be returned.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * This method sets the day using the limits of the calendar (used 31 days as the max limit).
     * 
     * @param newDay the day to be set
     * 
     * PRECONDITIONS: The user will enter a day within the limits of the calendar
     * POSTCONDITIONS: The method will set the day without crashing.
     */
    public void setDay(int newDay) {
        if (newDay > 0 && newDay <= 31) {
            this.day = newDay;
        } else {
            throw new IllegalArgumentException("Day cannot  go out of the calendar range.");
        }
    }

    /**
     * This is the setter for the month, it validates if the month passed by the user is within 0 and 12.
     * 
     * @param newMonth The month to be set
     * 
     * PRECONDITIONS: The user will enter a valid month.
     * POSTCONDITIONS: The method will set the month without crashing.
     */
    public void setMonth(int newMonth) {
        if (newMonth > 0 && newMonth < 13) {
            this.month = newMonth;
        } else {
            throw new IllegalArgumentException("Month cannot go out of the calendar range");
        }
    }

    /**
     * This method sets the year, it validates if the year is positive or not.
     * 
     * @param newYear The year to be set 
     * 
     * PRECONDITIONS: The user will enter a year that is between 2014 and 2024
     * POSTCONDITIONS: The method will set the year to the given year
     */
    public void setYear(int newYear) {
        if (newYear >= 2014 && newYear <= 2024) {
            this.year = newYear;
        } else {
            throw new IllegalArgumentException("Year cannot be less than 2014 and greater than 2024");
        }
    }

    @Override
    /**
     * This is the equals method, it takes in an object and checks if it equals to this class.
     */
    public boolean equals(Object obj) {
        boolean ret = false;
        if(obj != null && obj instanceof Date){
            if(this.getDay() == ((Date) obj).getDay()){
                if (this.getMonth() == ((Date) obj).getMonth()) {
                    if (this.getYear() == ((Date) obj).getYear()) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    @Override
    /**
     * This method clones the current class and copies its data to the other class.
     */
    public Date clone() {
        Date temp = null;
        try {
            temp = (Date) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Clone failed, please try again.");
        }
        return temp;
    }
    @Override
    /**
     * This is the compareto method, it works like the equals except it returns 1 or 0. 
     */
    public int compareTo(Date o){
        int ret = 0;
        if(this.equals(o)){
			ret = 1;
        }
        return ret;
	}
    
    /**
     * This outputs a date in the form month/day/year
     */
    public String toString(){
        String ret = this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
        return ret;
    }
}