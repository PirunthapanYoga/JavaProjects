package com.company;

class Main {

    public static void main(String[] args) throws InterruptedException {
        BankAccount a = new BankAccount(100);
        BankAccount b = new BankAccount(100);
        Thread aThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++)
                BankAccount.transferFrom(b, a, 100);
        });
        Thread bThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++)
                BankAccount.transferFrom(a, b, 100);
        });
        aThread.start();
        bThread.start();
        aThread.join();
        bThread.join();
        System.out.println(a.balance() + "  -   " + b.balance());
    }
}
