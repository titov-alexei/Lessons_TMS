package Leeson7;

public class BankAccount {

    //public String name;
    //не надо public
    //protected - относится к наследованию.
    private String account;
    private int balance;

    public BankAccount(String account, int balance) {
        this.account = account;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public static void test() {
        System.out.println("This is static method class BankAccount");
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawMoney(int value) {
        Boolean notEmpty = checkIsEmpty(value);
        if (notEmpty) {
            balance = balance - value;
        }
    }

    public void topUpBalance(int value) {
        balance = balance + value;
    }

    private Boolean checkIsEmpty(int value){
        if (balance <= 0) return false;
        int result = balance - value;
        if(result < 0) return false;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        if (this.account.equals(((BankAccount) obj).account)) {
            return true;
        } else {
            return false;
        }
    }

    //стоит переопределять hashcode для избежания коллизий
    //если переопределили equals то переопредели hashcode
    @Override
    public int hashCode() {
        return account.hashCode() + balance;
    }
}

