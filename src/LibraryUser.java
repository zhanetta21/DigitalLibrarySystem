public class LibraryUser {
    private String name;
    private int userId;

    public LibraryUser(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() { return name; }
    public int getUserId() { return userId; }

    public void setName(String name) { this.name = name; }
    public void setUserId(int userId) { this.userId = userId; }

    public void printInfo() {
        System.out.println("User: " + name + " | ID: " + userId);
    }
}

