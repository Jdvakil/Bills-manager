import java.io.Serializable;

/**
 * This class represents a Bill with instances amount, duedate, paiddate, amd
 * originator.
 * 
 * This class is taken from my previous homework and been modified.
 * @author Jay Darshan Vakil
 * @version 03/09/2020
 */
public class Bill implements Comparable<Bill>, Cloneable, Serializable{

    // Instance variables
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;

    /**
     * This is the constructor for the class, it takes in an amount, a duedate, and
     * a originator.
     * 
     * @param amount     The amount of money due
     * @param dueDate    The dueDate of the bill
     * @param originator The originator of the bill
     */
    public Bill(Money amount, Date dueDate, String originator) {
        this.setAmount(amount);
        this.setDueDate(dueDate);
        this.setOriginator(originator);
        this.paidDate = null;
    }

    /**
     * This is the copy constructor for the class, it takes in another bill and
     * copies its members to the current bill
     * 
     * @param other
     */
    public Bill(Bill other) {
        if (other != null) {
            this.amount = new Money(other.getAmount());
            this.dueDate = new Date(other.getDueDate());
            this.paidDate = new Date(other.getPaidDate());
            this.originator = new String(other.getOriginator());
        }
    }

    /**
     * The getter for the amount of money due.
     * 
     * @return
     */
    public Money getAmount() {
        Money tempMoney = new Money(this.amount);
        return tempMoney;
    }

    /**
     * The getter for the due date of the bill
     * 
     * @return
     */
    public Date getDueDate() {
        Date tempDate = new Date(this.dueDate);
        return tempDate;
    }

    /**
     * The getter for the paid date.
     * 
     * @return
     */
    public Date getPaidDate() {
        Date tempDate = new Date(this.paidDate);
        return tempDate;
    }

    /**
     * The getter for the originator
     * 
     * @return
     */
    public String getOriginator() {
        String tempString = new String(this.originator);
        return tempString;
    }

    /**
     * This is the setter for the amount.
     * 
     * @param newAmount The new Money object for amount 
     * 
     * PRECONDITION: The user will enter an amount that adheres to the conditions of that Money object. 
     * POSTCONDITIONS: The method will set the Moneytary amount to amount.
     */
    public void setAmount(Money newAmount) {
        if (newAmount != null) {
            this.amount = new Money(newAmount);
        } else {
            throw new IllegalArgumentException("Money cannot be null");
        }
    }

    /**
     * This method sets a new due date for the bill.
     * 
     * @param newDate The new date for the bill
     *
     * PRECONDITIONS: The user will enter a new date thats not null and adheres to the condition of the Date class.
     * POSTCONDITIONS: The method wiill set a new due date.
     * 
     */
    public void setDueDate(Date newDate) {
        if (newDate != null) {
            this.dueDate = new Date(newDate);
        } else {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }

    /**
     * This method sets the originator.
     * 
     * @param newOriginator the originator
     * 
     * PRECONDITIONS: The user will enter a valid and not empty originator
     * POSTCONDITIONS: The method will set the originator 
     */
    public void setOriginator(String newOriginator) {
        if (newOriginator != null && !newOriginator.isEmpty()) {
            this.originator = new String(newOriginator);
        } else {
            throw new IllegalArgumentException("Originator cannot be empty");
        }
    }

    /**
     * This method sets the new Paid date. It will be set to the due date if no paid date is assigned to prevent the program from crashing.
     *  
     * @param newPaid The new PaidDate
     * 
     * PRECONDITIONS: The user will enter a date that adheres to the Date class conditions
     * POSTCONDITIONS: The method will set the paid date 
     */
    public void setPaid(Date newPaid) {
        if (newPaid.getYear() <= this.getDueDate().getYear() && newPaid.getMonth() <= this.getDueDate().getMonth()
        && newPaid.getDay() <= this.getDueDate().getDay()) {
            this.paidDate = new Date(newPaid);
        } else {
            throw new IllegalArgumentException("The paid date cannot be empty or after the due date");
        }
    }

    /**
     * This method checks if the bill is paid or not. 
     * 
     * @return true if bill is paid, false if outstanding balance
     */
    public boolean isPaid() {
        boolean paid = false;
        Money tempMoney = new Money(this.amount);
        if (tempMoney.getMoney() == 0) {
            paid = true;
        } else {
            paid = false;
        }
        return paid;
    }

    /**
     * This sets the bill to unpaid.
     */
    public void setUnpaid() {
        this.setPaid(null);
    }

    /**
     * This method takes in another Bill object and checks if the two Bills are equal or not.
     * 
     * @param other The other bill object
     * @return true if equals, false if not equal
     */
    public boolean equals(Bill other) {
        boolean res = false;
        Money tempMoney = new Money(this.getAmount());
        Date tempDueDate = new Date(this.getDueDate());
        Date tempPaid = new Date(this.getPaidDate());
        String tempOrig = new String(this.getOriginator());
        if (other != null) {
            if (tempMoney.equals(other.getAmount()) && tempDueDate.equals(other.getDueDate())
                    && tempPaid.equals(other.getPaidDate()) && tempOrig.equals(other.getOriginator())) {
                res = true;
            }
        }
        return res;
    }

    /**
     * This is the toString method, it outputs the class into a string for an informative output.
     */
    @Override
    public String toString() {
        String res = "";
        if (this.isPaid()) {
            res += "Amount due: " + this.getAmount() + ". Pay by: " + this.getDueDate() + ". Originator: " + this.getOriginator()
                    + ". Paid on: " + this.getPaidDate();
        } else {
            res += "Amount due: " + this.getAmount() + ". Pay by: " + this.getDueDate() + ". Originator: " + this.getOriginator()
                    + ". Outstanding balance remain.";
        }
        return res;
    }

    @Override
    public int compareTo(Bill o) {
        int ret = 0;
        if(this.equals(o)){
            ret = 1;
        }
        return ret;
    }

    @Override
    public Bill clone(){
        Bill temp = null;
        try {
            temp = (Bill)super.clone();
        } catch (Exception e) {
            throw new InternalError("Clone failed...");
        }
        return temp;
    }
}