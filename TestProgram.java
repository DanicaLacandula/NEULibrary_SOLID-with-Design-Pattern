package neu.library;

import neu.library.resources.*;
import neu.library.services.*;

/**
 * TestProgram — validates the NEU Library SOLID-compliant refactoring.
 */
public class TestProgram {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("  NEU Library System — SOLID Demo");
        System.out.println("===========================================");

        // --- Students ---
        Student ana     = new Student("Ana Reyes",     "2024-0001");
        Student carlo   = new Student("Carlo Santos",  "2024-0002");
        Student maricel = new Student("Maricel Cruz",  "2024-0003");

        // --- Resources ---
        Book      cleanCode  = new Book("Clean Code", "Robert C. Martin");
        Journal   plosOne    = new Journal("PLOS ONE", 42);
        Newspaper inquirer   = new Newspaper("Philippine Daily Inquirer", "2025-04-09");
        Thesis    thesis     = new Thesis("Microservices in FinTech", "Juan dela Cruz", 2024);
        EJournal  ieeeAccess = new EJournal("IEEE Access", "https://ieeeaccess.ieee.org");

        System.out.println("\n========== TEST 1: Borrow a Book ==========");
        ana.borrow(cleanCode);
        carlo.borrow(cleanCode);   // unavailable

        System.out.println("\n========== TEST 2: Return and Re-borrow ==========");
        ana.returnResource(cleanCode);
        carlo.borrow(cleanCode);   // now available

        System.out.println("\n========== TEST 3: Borrow a Journal ==========");
        maricel.borrow(plosOne);

        System.out.println("\n========== TEST 4: Read on-site (ISP — Newspaper cannot be borrowed) ==========");
        ana.readOnSite(inquirer);
        ana.readOnSite(cleanCode);

        System.out.println("\n========== TEST 5: Thesis borrow + on-site read ==========");
        carlo.borrow(thesis);
        maricel.readOnSite(thesis);

        System.out.println("\n========== TEST 6: EJournal online access (OCP — no existing class modified) ==========");
        ana.accessOnline(ieeeAccess);
        maricel.readOnSite(ieeeAccess);

        System.out.println("\n========== TEST 7: BorrowingService used directly ==========");
        BorrowingService svc = new BorrowingService(thesis);
        svc.processReturn();
        svc.processCheckout("Maria Santos");

        System.out.println("\n========== TEST 8: AccessService used directly ==========");
        new AccessService(ieeeAccess).startOnlineSession("Library Kiosk");

        System.out.println("\n===========================================");
        System.out.println("  All tests completed successfully.");
        System.out.println("===========================================");
    }
}