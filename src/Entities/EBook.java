package Entities;
import Interfaces.*;
public class EBook implements IBook {
    private String isbn;
    private String title;
    private int publishYear;
    private double price;
    private String fileType;

    public EBook(String isbn, String title, int publishYear, double price, String fileType) {
        this.isbn = isbn;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
        this.fileType = fileType;
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



    public String getFileType() {
        return fileType;
    }

    @Override
    public boolean canBePurchased() {
        return true; // Always purchasable
    }

}

