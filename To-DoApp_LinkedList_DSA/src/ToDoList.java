import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ToDoList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Task> tasks;

    public ToDoList() {
        this.tasks = new LinkedList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void markTaskAsCompleted(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                task.markAsCompleted();
                break;
            }
        }
    }

    public void sortTasksByPriority() {
        Collections.sort(tasks, Comparator.comparingInt(Task::getPriority));
    }

    public void sortTasksByDueDate() {
        Collections.sort(tasks, Comparator.comparing(Task::getDueDate));
    }

    public Task findTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }

    public void saveTasksToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tasks);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTasksFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            tasks = (List<Task>) ois.readObject();
        }
    }
}
