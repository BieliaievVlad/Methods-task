package app;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    static String product;
    static double price;
    static String measure;
    static int amount;
    static double discount;
    static double payment;
    static double discAmount;
    static double discPayment;
    static Scanner sc;


    public static void main(String[] args) {

        product = "Phone";
        price = 2775.99;
        measure = "pcs";

        showProduct();
        getData();
        calcPayment();
        calcDiscont();
        calcDiscAmount();
        calcDiscPayment();
        getOutput(payment, discAmount, discPayment);
    }

    private static void showProduct() {
        System.out.printf("Product name: %s%nPrice, UAH: %.2f/%S", product, price, measure);
    }

    private static void getData() {
        sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        System.out.print("\nEnter amount of product: ");
        amount = sc.nextInt();
        sc.close();
    }

    private static void calcPayment() {
        payment = price * amount;
    }

    private static void calcDiscont() {
        if (payment > 0 & payment <= 5000) {
            discount = 5;
        } else if (payment > 5000.01 & payment <= 10000) {
            discount = 10;
        } else if (payment > 10000.01) {
            discount = 15;
        }
    }

    private static void calcDiscAmount() {
        discAmount = payment * discount / 100;
    }

    private static void calcDiscPayment() {
        discPayment = payment - discAmount;
    }

    private static void getOutput(double payment, double discAmount, double discPayment) {
        System.out.printf("Payment, UAH: %.2f%n" +
                "Discount, UAH: %.2f%n" +
                "Total, UAH: %.2f", payment, discAmount, discPayment);
    }


}
