package neu.library.resources;

import neu.library.interfaces.Borrowable;
import neu.library.interfaces.Readable;

/**
 * Concrete resource: Journal.
 * Journals can be borrowed short-term and read on-site.
 */
public class Journal implements Borrowable, Readable {

    private final String title;
    private final int issueNumber;
    private boolean available;

    public Journal(String title, int issueNumber) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.available = true;
    }

    @Override
    public String getTitle() { return title + " (Issue " + issueNumber + ")"; }

    @Override
    public void borrow(String studentName) {
        if (!available) {
            System.out.println("[Journal] \"" + title + "\" issue " + issueNumber + " is unavailable.");
            return;
        }
        available = false;
        System.out.println("[Journal] \"" + title + "\" issue " + issueNumber + " borrowed by " + studentName + ".");
    }

    @Override
    public void returnItem() {
        available = true;
        System.out.println("[Journal] \"" + title + "\" issue " + issueNumber + " returned.");
    }

    @Override
    public boolean isAvailable() { return available; }

    @Override
    public void readOnSite() {
        System.out.println("[Journal] Reading \"" + title + "\" issue " + issueNumber + " on-site.");
    }

    @Override
    public String getFormat() { return "Print Journal"; }
}