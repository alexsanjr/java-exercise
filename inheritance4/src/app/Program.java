package app;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Tax payer #%d data: %n", i);
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures= sc.nextDouble();
                taxPayers.add(new Individual(name, annualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                taxPayers.add(new Company(name,  annualIncome, numberEmployees));
            }
        }
        System.out.println();
        System.out.printf("TAXES PAID: ");

        double total = 0.0;
        for (TaxPayer tp : taxPayers) {
            System.out.println(tp);
            total += tp.tax();
        }
        System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", total));
    }
}
