package neu.library.services;

import neu.library.interfaces.Accessible;

/**
 * AccessService handles online resource access.
 * DIP: depends on the Accessible abstraction.
 * SRP: responsible only for online access workflow.
 */
public class AccessService {

    private final Accessible resource;

    public AccessService(Accessible resource) {
        this.resource = resource;
    }

    public void startOnlineSession(String studentName) {
        System.out.println("\n--- Online Access ---");
        System.out.println(studentName + " is accessing a digital resource.");
        resource.accessOnline();
        System.out.println("Access URL: " + resource.getAccessUrl());
    }
}