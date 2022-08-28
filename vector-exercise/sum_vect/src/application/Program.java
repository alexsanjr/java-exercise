package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();

        double[] vect = new  double[n];

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
        }
        System.out.print("VALORES =");
        for (double v : vect) {
            System.out.printf(" %.1f",v);
        }

        double sum = 0.0;
        for (double v : vect) {
            sum += v;
        }
        System.out.printf("%nSOMA = %.2f%n", sum);

        double med = sum / n;

        System.out.printf("MEDIA = %.2f%n", med);

        sc.close();
    }
}
