package neu.library.services;

import neu.library.interfaces.Borrowable;

/**
 * BorrowingService handles checkout logic.
 * DIP: depends on the Borrowable abstraction, not on any concrete resource type.
 * SRP: responsible only for checkout/return workflow.
 */
public class BorrowingService {

    private final Borrowable resource;

    public BorrowingService(Borrowable resource) {
        this.resource = resource;
    }

    public void processCheckout(String studentName) {
        System.out.println("\n--- Checkout ---");
        if (!resource.isAvailable()) {
            System.out.println("Sorry, \"" + resource.getTitle() + "\" is not available right now.");
            return;
        }
        resource.borrow(studentName);
        System.out.println("Checkout complete.");
    }

    public void processReturn() {
        System.out.println("\n--- Return ---");
        resource.returnItem();
        System.out.println("Return complete.");
    }
}