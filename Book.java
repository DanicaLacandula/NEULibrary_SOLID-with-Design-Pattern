package neu.library.resources;

import neu.library.interfaces.Borrowable;
import neu.library.interfaces.Readable;

/**
 * Concrete resource: Book.
 * SRP: only manages book-specific data and behaviour.
 * OCP: adding a new resource type does not require modifying this class.
 */
public class Book implements Borrowable, Readable {

    private final String title;
    private final String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    @Override
    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    @Override
    public void borrow(String studentName) {
        if (!available) {
            System.out.println("[Book] \"" + title + "\" is currently unavailable.");
            return;
        }
        available = false;
        System.out.println("[Book] \"" + title + "\" borrowed by " + studentName + ".");
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("[Book] \"" + title + "\" has been returned.");
    }

    @Override
    public boolean isAvailable() { return available; }

    @Override
    public void readOnSite() {
        System.out.println("[Book] Reading \"" + title + "\" on-site.");
    }

    @Override
    public String getFormat() { return "Print"; }
}