package neu.library.interfaces;

/**
 * ISP: Segregated interface for resources accessible online.
 * Enables future e-resources (e-journals, audio books) without touching existing code.
 */
public interface Accessible extends LibraryResource {
    void accessOnline();
    String getAccessUrl();
}