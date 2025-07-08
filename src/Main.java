import Test.Test;

public class Main {
    public static void main(String[] args) {

        Test test = new Test();
        test.addBooks();
        test.removeOldBooks();
        test.buyPaperBook();
        test.buyEBook();
        test.buyDemoBook();
        test.printInventory();

    }
}