package Inventory;
import java.util.ArrayList;
import java.util.List;

import Interfaces.*;

public class Inventory {
    private List<IBook> books = new ArrayList<>();

    public void addBook(IBook book) {
        books.add(book);
    }

    public void removeOutdatedBooks(int maxAge, int currentYear) {
        books.removeIf(book -> currentYear - book.getPublishYear() > maxAge);
    }

    public IBook findByISBN(String isbn) {
        for (IBook book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<IBook> getAllBooks() {
        return books;
    }
}

