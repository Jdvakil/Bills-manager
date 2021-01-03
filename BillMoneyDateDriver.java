/**
 * This is the driver class, it tests out every single class (Date, Money, Bill)
 * 
 * @author Jay Darshan Vakil
 * @version 02/04/2020
 */
public class BillMoneyDateDriver {
    public static void main(String[] args) {
        System.out.println("Testing Money: \n"); testMoney();
        System.out.println("\nTesting Date: \n"); testDate();
        System.out.println("\nTesting Bill: \n"); testBill();
        System.out.println("\n Testing ArrayList: \n"); testArrayList();
        System.out.println("\n Testing expense accounts: \n"); testExpenseAccounts();
    }

    /**
     * This tests the Date
     */
    private static void testDate() {
        Date d1 = new Date();
        Date d2 = new Date(02, 04, 2020);
        Date d3 = d2.clone();

        System.out.println("Happy new year 2020: " + d1);
        System.out.println("Date: " + d2);
        System.out.println("Today is: " + d3);

        System.out.println("D2 == D3: " + d2.equals(d3));

        d3.setDay(d3.getDay() + 1);
        System.out.println("Tomorrow is: " + d3);

    }

    /**
     * This tests the Money
     */
    private static void testMoney() {
        Money m1 = new Money();
        Money m2 = new Money(10);
        Money m3 = new Money(1, 50);
        Money m4 = m1.clone();

        System.out.println("M1: " + m1);
        System.out.println("M2: " + m2);
        System.out.println("M3: " + m3);
        System.out.println("M4: " + m4);
        m1.add(5, 50);
        System.out.println("New M1: " + m1);
        m3.add(4);
        System.out.println("New M3: " + m3);
        System.out.println("M1 is equal to M3: " + m1.equals(m3));
        m2.add(10, 100);
        System.out.println("New M2: " + m2);
        m4.add(m2);
        System.out.println("New M4: " + m4);
    }

    /**
     * This tests the Bill
     */
    private static void testBill() {
        Date dueDate = new Date(02, 04, 2020);
        Date paidDate = new Date(02, 01, 2020);
        Money amount = new Money(70, 50);
        Bill b = new Bill(amount, dueDate, "Phone bill");
        System.out.println(b);
        b.setPaid(paidDate);
        b.setAmount(new Money());
        System.out.println(b);
        b.setDueDate(new Date(03, 04, 2020));
        b.setAmount(amount);
        System.out.println(b);
        if (b.isPaid()) {
            System.out.println("Good job paying your bill!");
        } else {
            System.out.println("Pay your bills..." + b.getAmount() + " is much is due!");
        }
        b.setPaid(new Date(03, 01, 2020));
        b.setAmount(new Money());
        System.out.println(b);
    }

    private static void testArrayList() {
        Integer[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer[] array2 = { 10, 20, 30, 40, 50, 60 };
        Integer[] array1Copy = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        ArrayList<Integer> arrayList1 = new ArrayList<>(array1);
        ArrayList<Integer> arrayList2 = new ArrayList<>(array2);
        ArrayList<Integer> arrayList3 = new ArrayList<>(array1Copy);

        System.out.println(arrayList2);
        System.out.println("value at index 4: " + arrayList2.get(4));
        System.out.println("Index of 40: " + arrayList2.indexOf(40));
        System.out.println("Size of arrayList2: " + arrayList2.size());

        System.out.println();

        boolean isEmpty = arrayList2.isEmpty();
        if (!isEmpty) {
            System.out.println(arrayList2 + " is not empty");
        }

        System.out.println();

        System.out.println();

        arrayList1.insert(0, 0);
        arrayList1.insert(100, 5);
        boolean equals = arrayList1.equals(arrayList3);
        if (equals) {
            System.out.println(arrayList1 + " is equals to " + arrayList3);
        } else {
            System.out.println(arrayList1 + " is not equals to " + arrayList3);
        }

        System.out.println();

        System.out.println("ArrayList2: " + arrayList2);
        System.out.println(arrayList2.remove(arrayList2.size() - 1) + " is removed");
        System.out.println("ArrayList2: " + arrayList2);
    }

    private static void testExpenseAccounts() {
        ExpenseAccount ea = new ExpenseAccount();
        Date dueDate = new Date(02, 04, 2020);
        Date paidDate = new Date(02, 01, 2020);
        Money amount = new Money(70, 50);
        Bill b = new Bill(amount, dueDate, "Phone bill");
        amount.setMoney(3000, 00);
        Bill b1 = new Bill(amount, dueDate, "Tuition");
        ea.addBill(b);
        ea.addBill(b1);
        b1.setPaid(paidDate);
        System.out.println(ea);
    }

}