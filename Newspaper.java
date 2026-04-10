package neu.library.resources;

import neu.library.interfaces.Readable;

/**
 * Concrete resource: Newspaper.
 * ISP in action: Newspaper only implements Readable, NOT Borrowable.
 * Newspapers are reference material — they cannot be taken out of the library.
 */
public class Newspaper implements Readable {

    private final String title;
    private final String publicationDate;

    public Newspaper(String title, String publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

    @Override
    public String getTitle() { return title + " (" + publicationDate + ")"; }

    @Override
    public void readOnSite() {
        System.out.println("[Newspaper] Reading \"" + title + "\" dated " + publicationDate + " on-site.");
    }

    @Override
    public String getFormat() { return "Broadsheet"; }
}