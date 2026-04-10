package neu.library.resources;

import neu.library.interfaces.Borrowable;
import neu.library.interfaces.Readable;

/**
 * Concrete resource: Thesis / Capstone.
 * Available for on-site reading and short-term borrowing with special permission.
 */
public class Thesis implements Borrowable, Readable {

    private final String title;
    private final String author;
    private final int year;
    private boolean available;

    public Thesis(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    @Override
    public String getTitle() { return title + " by " + author + " (" + year + ")"; }

    @Override
    public void borrow(String studentName) {
        if (!available) {
            System.out.println("[Thesis] \"" + title + "\" is currently checked out.");
            return;
        }
        available = false;
        System.out.println("[Thesis] \"" + title + "\" borrowed (with special permission) by " + studentName + ".");
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("[Thesis] \"" + title + "\" returned.");
    }

    @Override
    public boolean isAvailable() { return available; }

    @Override
    public void readOnSite() {
        System.out.println("[Thesis] Reading \"" + title + "\" on-site in the thesis archive.");
    }

    @Override
    public String getFormat() { return "Bound Thesis"; }
}