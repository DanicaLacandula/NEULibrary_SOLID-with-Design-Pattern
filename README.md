# NEULibrary_SOLID-with-Design-Pattern

## Problem Statement

The NEU Library offers various resources: books, theses, capstones, internet access, journals,
and newspapers. In the original design, the `Student` object had methods like `borrowBook(title)`
and `borrowJournal(title)` that directly depended on specific resource types — violating the
**Dependency Inversion Principle (DIP)**.

This made the system brittle: adding a new resource type (e.g., audio books, e-journals) required
modifying the `Student` class itself. The goal of this refactoring is to produce a SOLID-compliant
design that is open to extension without modification.

---

## SOLID Principles Applied

### 1. Single Responsibility Principle (SRP)
- `Student` only stores student identity. All resource operations are delegated to service classes.
- `BorrowingService` handles checkout/return logic only.
- `ReadingService` handles on-site reading session logic only.
- `AccessService` handles online access logic only.
- Each resource class manages only its own data and behaviour.

### 2. Open/Closed Principle (OCP)
- New resource types (`EJournal`, `AudioBook`, etc.) can be added by implementing the relevant
  interface(s) without modifying any existing class.
- `Student`, `BorrowingService`, `ReadingService`, and `AccessService` never need to change
  when new resources are introduced.

### 3. Liskov Substitution Principle (LSP)
- Every class implementing `Borrowable` fulfils the full contract: `borrow()`, `returnItem()`,
  and `isAvailable()` behave consistently across `Book`, `Journal`, `Thesis`, etc.
- `Newspaper` intentionally does NOT implement `Borrowable` — it should not be substituted
  where borrowing is expected.

### 4. Interface Segregation Principle (ISP)
- Three focused interfaces replace one monolithic interface:
  - `Borrowable` — for resources that can be physically borrowed
  - `Readable` — for resources that can be read on-site
  - `Accessible` — for resources with online/digital access
- `Newspaper` only implements `Readable` and is never forced to implement `borrow()`.

### 5. Dependency Inversion Principle (DIP)
- `Student` depends on `Borrowable`, `Readable`, and `Accessible` abstractions — not on
  `Book`, `Journal`, or any concrete resource class.
- All service classes accept abstractions via constructor injection.
- Adding `EJournal` required zero changes to `Student` or any service class.

---