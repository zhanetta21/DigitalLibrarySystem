import io.javalin.Javalin;
import java.util.List;
void main() {
    // Initialize the Javalin server
    var app = Javalin.create().start(8080);

    app.get("/api/books", ctx -> {
        List<Book> books = BookDAO.getAllBooks();
        ctx.json(books);
    });

    System.out.println("Web Service is LIVE at http://localhost:8080/api/books");
}