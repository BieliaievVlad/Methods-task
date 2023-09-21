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

        getData();
        showProduct();
        handleData();
        getOutput(payment, discAmount, discPayment);
    }

    private static void showProduct() {
        System.out.print("\n-------------------");
        System.out.printf("%nProduct name: %s%nPrice, UAH: %.2f/%S", product, price, measure);
    }

    private static void getData() {
        sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        System.out.print("Enter product name: ");
        product = sc.nextLine();
        System.out.print("Enter product measure value: ");
        measure = sc.nextLine();
        System.out.print("Enter product price value, UAH: ");
        price = sc.nextDouble();
        System.out.print("Enter amount of product: ");
        amount = sc.nextInt();

        sc.close();
    }

    private static void handleData() {
        payment = calcPayment(price, amount);
        discount = calcDiscount(payment);
        discAmount = calcDiscAmount(payment, discount);
        discPayment = calcDiscPayment(payment, discAmount);
    }

     private static double calcPayment(double price, int amount) {
        return price * amount;
    }

    private static double calcDiscount(double payment) {
        if (payment > 0 & payment <= 5000) {
            discount = 5;
        } else if (payment > 5000.01 & payment <= 10000) {
            discount = 10;
        } else if (payment > 10000.01) {
            discount = 15;
        }
        return discount;
    }

    private static double calcDiscAmount(double payment, double discount) {
        return payment * discount / 100;
    }

    private static double calcDiscPayment(double payment, double discAmount) {
        return payment - discAmount;
    }

    private static void getOutput(double pay, double discAmount, double discPay) {

        System.out.printf("%nPayment, UAH: %.2f%n" +
                "Discount, UAH: %.2f%n" +
                "Total, UAH: %.2f", pay, discAmount, discPay);
    }


}
