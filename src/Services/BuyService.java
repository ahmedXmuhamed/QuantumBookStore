package Services;
import Inventory.*;
import java.util.ArrayList;
import java.util.List;
import Interfaces.*;
import Entities.*;
public class BuyService {
    private Inventory inventory;
    private ShippingService shippingService=new ShippingService();
    private MailService mailService=new MailService();

    public BuyService(Inventory inventory, ShippingService shippingService, MailService mailService) {
        this.inventory = inventory;
        this.shippingService = shippingService;
        this.mailService = mailService;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        IBook book = inventory.findByISBN(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
        }

        if (!book.canBePurchased()) {
            throw new IllegalStateException("This book cannot be purchased.");
        }

        if (book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            paperBook.reduceQuantity(quantity);
            shippingService.shipPaperBook(paperBook, address);
        } else if (book instanceof EBook) {
            if (quantity > 1) {
                System.out.println("Note: EBooks are digital. Only 1 copy will be sent.");
            }
            EBook ebook = (EBook) book;
            mailService.sendEBook(ebook, email);
        } else {
            throw new IllegalStateException("Unsupported book type for purchasing.");
        }

        return book.getPrice() * quantity;
    }
}

