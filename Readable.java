package neu.library.interfaces;

/**
 * ISP: Segregated interface for resources that can be read on-site.
 * Separate from Borrowable so clients aren't forced to implement unneeded methods.
 */
public interface Readable extends LibraryResource {
    void readOnSite();
    String getFormat();
}