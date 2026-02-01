public class EBook extends Book {
    public EBook(String title, String author, String id) {
        super(title, author, id);
    }

    @Override
    public void printInfo() {
        String status = (getBorrowedBy() == null) ? "Available" : "Taken by " + getBorrowedBy().getName();
        System.out.println("[E-Book]  " + getTitle() + " | ID: " + getId() + " | Status: " + status);
    }
}