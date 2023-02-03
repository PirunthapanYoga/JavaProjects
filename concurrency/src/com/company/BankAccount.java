package com.company;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private long balance;
    public BankAccount(long balance) {
        this.balance = balance;
    }
    static synchronized void transferFrom(BankAccount source,
                             BankAccount dest, long amount) {
        source.balance -= amount;
        dest.balance += amount;
    }
    public synchronized long balance() {
        return balance;
    }
}
