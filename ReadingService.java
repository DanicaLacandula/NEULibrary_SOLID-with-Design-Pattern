package neu.library.services;

import neu.library.interfaces.Readable;

/**
 * ReadingService handles on-site reading sessions.
 * DIP: depends on Readable abstraction.
 * SRP: only responsible for on-site reading workflow.
 */
public class ReadingService {

    private final Readable resource;

    public ReadingService(Readable resource) {
        this.resource = resource;
    }

    public void startReadingSession(String studentName) {
        System.out.println("\n--- Reading Session ---");
        System.out.println(studentName + " is starting a reading session.");
        resource.readOnSite();
        System.out.println("Format: " + resource.getFormat());
    }
}