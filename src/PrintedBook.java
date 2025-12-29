public class PrintedBook extends Book {

        public PrintedBook(String title, String author, String isbn) {
            super(title, author, isbn);
        }

        @Override
        public String getType() {
            return "Printed book";
        }
}
