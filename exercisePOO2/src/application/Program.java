package application;

import entities.Product;

import java.util.Scanner;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data:");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity in stock: ");
        int quantity = sc.nextInt();

        Product product = new Product(name, price, quantity);

        System.out.println("Product data: " + product);

        System.out.print("Enter the number of products to be added in stock: ");
        product.addProducts(sc.nextInt());
        System.out.println("Updated data: " + product);

        System.out.println("Enter the number of products to be removed from stock: ");
        product.removeProducts(sc.nextInt());
        System.out.println("Updated data: " + product);

        sc.close();
    }
}
