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

    // Добавляем именно тот метод, который ищет Java
    public int getUserId() {
        return id;
    }

    // На всякий случай добавим и такой вариант, если где-то используется он
    public int getId() {
        return id;
    }
}