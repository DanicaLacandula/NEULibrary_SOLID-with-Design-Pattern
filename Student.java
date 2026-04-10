package neu.library;

import neu.library.interfaces.Accessible;
import neu.library.interfaces.Borrowable;
import neu.library.interfaces.Readable;
import neu.library.services.AccessService;
import neu.library.services.BorrowingService;
import neu.library.services.ReadingService;

/**
 * Student class.
 * SRP: stores student data only — delegates all resource operations to services.
 * DIP: methods accept abstractions, not concrete types.
 */
public class Student {

    private final String name;
    private final String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() { return name; }
    public String getStudentId() { return studentId; }

    public void borrow(Borrowable resource) {
        new BorrowingService(resource).processCheckout(name);
    }

    public void returnResource(Borrowable resource) {
        new BorrowingService(resource).processReturn();
    }

    public void readOnSite(Readable resource) {
        new ReadingService(resource).startReadingSession(name);
    }

    public void accessOnline(Accessible resource) {
        new AccessService(resource).startOnlineSession(name);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id='" + studentId + "'}";
    }
}