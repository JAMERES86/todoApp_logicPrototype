import java.util.Date;

public class Task {

    private int id;
    private String name;
    private Date deadline;
    // Constructor
    public Task(int id, String name) {
        this.id = id;
        this.name = name;
        this.deadline = null;
    }
    public Task(int id, String name, Date deadline) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
    }

    public String toString() {
        return "Task ID: " + id + ", Name: " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}