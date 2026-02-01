public class LibraryUser {
    private String name;
    private int id; // или userId

    public LibraryUser(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getUserId() {
        return id;
    }

    public int getId() {
        return id;
    }
}