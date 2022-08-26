package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder: ");
        String holder = sc.nextLine();

        System.out.print("Is there na initial deposit (y/n)? ");
        char response = sc.next().charAt(0);

        Account acc;
        if (response == 'y') {
            System.out.print("Enter initial deposit value: ");
            double balance = sc.nextDouble();
            acc = new Account(number, holder, balance);
        }
        else {
            acc = new Account(number, holder);
        }
        System.out.println("\nAccount data:");
        System.out.println(acc);

        System.out.print("Enter a deposit value: ");
        double value = sc.nextDouble();
        System.out.println("Updated account data:");
        acc.deposit(value);
        System.out.println(acc);
        System.out.println();

        System.out.print("Enter a withdraw value: ");
        value = sc.nextDouble();
        acc.withdrawn(value);
        System.out.println("Updated account data:");
        System.out.println(acc);

        sc.close();
    }
}
