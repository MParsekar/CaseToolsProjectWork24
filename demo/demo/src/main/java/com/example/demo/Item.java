package com.example.demo;

import java.util.Scanner;

public class Item {
    private String name;
    private double totalPrice;
    private int qty;

    public Item(String name, int qty, double unitPrice) {
        this.name = name;
        this.qty = qty;
        this.totalPrice = qty * unitPrice;
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getQty() {
        return qty;
    }

    public static void processPayment(Item item, double amountPaid) {
        if (amountPaid >= item.getTotalPrice()) {
            System.out.println("Payment successful!");
            double change = amountPaid - item.getTotalPrice();
            System.out.println("Change: " + change);
        } else {
            System.out.println("Payment failed. Insufficient funds.");
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String itemName = obj.nextLine();

        System.out.print("Enter item quantity: ");
        int itemQty = obj.nextInt();

        System.out.print("Enter item unit price: ");
        double unitPrice = obj.nextDouble();

        Item item = new Item(itemName, itemQty, unitPrice);

        System.out.println("Item Name: " + item.getName());
        System.out.println("Item Quantity: " + item.getQty());
        System.out.println("Item Total Price: " + item.getTotalPrice());

        System.out.print("Enter amount paid: ");
        double amountPaid = obj.nextDouble();

        processPayment(item, amountPaid);

        obj.close();

    }
}
