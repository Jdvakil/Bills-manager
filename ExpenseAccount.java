/**
 * This is ia class that manages bills. It instantiates an Arraylist consisting
 * of Bill objects and thw adds a new bill or removes the number of bills. It
 * also displays the bills.
 * 
 * @author Jay D Vakil
 * @version 03/09/2020
 */
public class ExpenseAccount extends ArrayList<Bill> {
    private ArrayList<Bill> bills;
    private int count;

    /**
     * Empty constructor to instantiate the expense accounts.
     */
    public ExpenseAccount() {
        bills = new ArrayList<>(10);
        count = 0;
    }

    /**
     * This method adds a new bill to the expense accounts, checks if the new bill
     * is not null.
     * 
     * @param newBill
     */
    public void addBill(Bill newBill) {
        if (newBill != null) {
            bills.insert(newBill, count);
            count++;
        } else {
            throw new IllegalArgumentException("New bill cannot be null");
        }
    }

    /**
     * This method removes a bill if the bill is paid and the user wishes to remove
     * it, cannot remove it the bill to be removed is null or unpaid.
     * 
     * @param removeBill
     */
    public void removeBill(Bill removeBill) {
        if (removeBill != null && !removeBill.isPaid()) {
            bills.remove(bills.indexOf(removeBill));
        } else {
            throw new IllegalArgumentException("Bill to be removed cannot be unpaid or null");
        }
    }

    @Override
    /**
     * This method displays the bills as a string form.
     */
    public String toString() {
        String res = "[ ";
        for (int i = 0; i < bills.size(); i++){
            if(bills.get(i) != null){
                res += bills.get(i) + "\n";
            }
        }
        res += "]";
        return res;
    }
}