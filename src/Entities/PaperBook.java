package Entities;

import  Interfaces.*;

public class PaperBook implements IBook {
    private String isbn;
    private String title;
    private int publishYear;
    private double price;
    private int quantity;


    public PaperBook(String isbn, String title, int publishYear, double price, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
        this.quantity = quantity;

    }

    @Override
    public String getISBN() {
        return isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getPublishYear() {
        return publishYear;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (quantity < amount) {
            throw new IllegalArgumentException("Not enough in the stock.");
        }
        quantity -= amount;
    }


    @Override
    public boolean canBePurchased() {
        return quantity > 0;
    }
}
