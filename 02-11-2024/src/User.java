public class User {
    private String username;
    private String password;
    private ToDoList toDoList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.toDoList = new ToDoList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }


}
