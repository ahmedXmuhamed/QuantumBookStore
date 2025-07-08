package Entities;
import Interfaces.*;

public class DemoBook implements IBook {
    private String isbn;
    private String title;
    private int publishYear;
    private double price;

    public DemoBook(String isbn, String title, int publishYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;

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



    @Override
    public boolean canBePurchased() {
        return false; // Showcase books are not for sale
    }


}