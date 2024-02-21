public class Credit {
    public static void main(String[] args) {
        CreditCard card = new CreditCard("John Doe", "XYZ Bank", "1234 5678 9012 3456", 15000, 6000);
        System.out.println("Customer: " + card.getCustomer());
        System.out.println("Bank: " + card.getBank());
        System.out.println("Account: " + card.getAccount());
        System.out.println("Limit: " + card.getLimit());
        System.out.println("Balance: " + card.getBalance());

        double chargeAmount = 4000.0;
        if (card.charge(chargeAmount)) {
            System.out.println("Charge of $" + chargeAmount + " successful.");
        } else {
            System.out.println("Charge of $" + chargeAmount + " failed. Exceeds limit.");
        }

        System.out.println("Balance after charge: " + card.getBalance());

        double paymentAmount = 2000.0;
        card.makePayment(paymentAmount);
        System.out.println("Payment of $" + paymentAmount + " made.");
        System.out.println("Balance after payment: " + card.getBalance());
    }
}

class CreditCard {
    private String customer;
    private String bank;
    private String account;
    private int limit;
    private double balance;

    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    public String getCustomer() { return customer; }
    public String getBank() { return bank; }
    public String getAccount() { return account; }
    public int getLimit() { return limit; }
    public double getBalance() { return balance; }

    public boolean charge(double price) {
        if (price + balance > limit) return false;
        balance += price;
        return true;
    }

    public void makePayment(double amount) { balance -= amount; }
}
