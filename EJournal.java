package neu.library.resources;

import neu.library.interfaces.Accessible;
import neu.library.interfaces.Readable;

/**
 * Future extension: EJournal (electronic journal).
 * OCP + DIP in action: added without modifying any existing class.
 * Does NOT implement Borrowable — e-journals are accessed online, not physically borrowed.
 */
public class EJournal implements Accessible, Readable {

    private final String title;
    private final String url;

    public EJournal(String title, String url) {
        this.title = title;
        this.url = url;
    }

    @Override
    public String getTitle() { return title + " [E-Journal]"; }

    @Override
    public void accessOnline() {
        System.out.println("[EJournal] Accessing \"" + title + "\" online at: " + url);
    }

    @Override
    public String getAccessUrl() { return url; }

    @Override
    public void readOnSite() {
        System.out.println("[EJournal] Reading \"" + title + "\" on a library terminal.");
    }

    @Override
    public String getFormat() { return "Digital"; }
}