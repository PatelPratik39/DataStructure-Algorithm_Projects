import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private boolean isCompleted;
    private int priority;
    private LocalDate dueDate;

    public Task(String title, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Method to mark task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Override toString method for meaningful output
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                '}';
    }
}
