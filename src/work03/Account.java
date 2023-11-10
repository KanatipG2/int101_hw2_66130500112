package work03;

import work01.Utilitor;
import work02.Person;

public class Account {
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
        this.balance = 0.0;

        long result = Utilitor.computeIsbn10(nextNo);
        while (result==10) {
            nextNo++;
            result = Utilitor.computeIsbn10(nextNo);
        }
        no = 10 * nextNo + result;
        nextNo++;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        balance += Utilitor.testPositive(amount);
        return balance;
    }
    public double withdraw(double amount) {
        balance -= Utilitor.testPositive(amount);
        return Utilitor.testPositive(balance);
    }

    public void transfer(double amount, Account account) {
        if (account == null) {
            throw new IllegalArgumentException();
        }
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return String.format("Account(%s,%f)", no, balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Account account)) {
            return false;
        }

        return no == account.getNo() && owner.equals(account.getOwner()) && balance == account.getBalance();
    }
}
