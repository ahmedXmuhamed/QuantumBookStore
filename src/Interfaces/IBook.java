package Interfaces;

public interface IBook {
    int getPublishYear();
    double getPrice();
    String getISBN();
    String getTitle();

    boolean canBePurchased();

}

