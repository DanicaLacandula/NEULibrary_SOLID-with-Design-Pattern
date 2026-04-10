package neu.library.interfaces;

/**
 * Root abstraction for all library resources.
 * Follows DIP: high-level modules depend on this abstraction, not concrete types.
 */
public interface LibraryResource {
    String getTitle();
}