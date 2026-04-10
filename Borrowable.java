package neu.library.interfaces;

/**
 * ISP: Segregated interface for borrowable resources only.
 * Not all library resources can be borrowed (e.g., newspapers are read on-site only).
 */
public interface Borrowable extends LibraryResource {
    void borrow(String studentName);
    void returnItem();
    boolean isAvailable();
}