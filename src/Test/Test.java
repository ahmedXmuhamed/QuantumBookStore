package Test;
import Entities.*;
import Inventory.Inventory;
import Services.*;
import Interfaces.*;


import Entities.*;
import Inventory.Inventory;
import Services.*;

public class Test {

    private Inventory inventory;
    private BuyService buyService;

    public Test() {
        ShippingService shippingService = new ShippingService();
        MailService mailService = new MailService();
        inventory = new Inventory();
        buyService = new BuyService(inventory, shippingService, mailService);
    }

    public void addBooks() {
        PaperBook paperBook = new PaperBook("ISBN1", "Head first", 2015, 300, 5);
        EBook eBook = new EBook("ISBN2", "Git book", 2021, 200, "PDF");
        DemoBook demoBook = new DemoBook("ISBN3", "Demo book", 2009, 0);

        inventory.addBook(paperBook);
        inventory.addBook(eBook);
        inventory.addBook(demoBook);

        System.out.println("Books added.");
    }

    public void removeOldBooks() {
        inventory.removeOutdatedBooks(10, 2025);
        System.out.println("Old books removed.");
    }

    public void buyPaperBook() {
        try {
            double amount = buyService.buyBook("ISBN1", 2, "reader@example.com", "123 Book St");
            System.out.println("Bought paper book. Paid: " + amount);
        } catch (Exception e) {
            System.out.println("Error buying paper book: " + e.getMessage());
        }
    }

    public void buyEBook() {
        try {
            double amount = buyService.buyBook("ISBN2", 1, "ebook@example.com", "N/A");
            System.out.println("Bought ebook. Paid: " + amount);
        } catch (Exception e) {
            System.out.println("Error buying ebook: " + e.getMessage());
        }
    }

    public void buyDemoBook() {
        try {
            double amount = buyService.buyBook("ISBN3", 1, "demo@example.com", "N/A");
            System.out.println("Bought demo book. Paid: " + amount);
        } catch (Exception e) {
            System.out.println("Error buying demo book: " + e.getMessage());
        }
    }

    public void printInventory() {
        System.out.println("Current Inventory:");
        for (IBook book : inventory.getAllBooks()) {
            System.out.println("- " + book.getTitle() + " (" + book.getISBN() + ")");
        }
    }
}
