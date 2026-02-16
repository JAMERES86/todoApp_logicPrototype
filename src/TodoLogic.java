import java.util.ArrayList;
import java.util.Iterator;


public class TodoLogic {
    private int id_counter = 0;
    private ArrayList<Task> tasks_inProgress;
    private ArrayList<Task> tasks_completed;

    // Add a task
    public void addTask(String taskName) {
        Task task = new Task(id_counter, taskName);
        tasks_inProgress.add( task);
        id_counter ++;
    }
    // Edit a task
    public void editTask(int taskId, String newTaskName) {
        for (Task task : tasks_inProgress) {
            if (task.getId() == taskId) {
                task.setName(newTaskName);
                break;
            }
        }
    }

    // View tasks in progress
    public void viewTasksInProgress() {
        System.out.println("Tasks in progress:");
        if (tasks_inProgress.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (Task task : tasks_inProgress) {
            System.out.println(task);
        }
    }
    // View completed tasks
    public void viewCompletedTasks() {
        System.out.println("Tasks completed:");
        if (tasks_completed.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (Task task : tasks_completed) {
            System.out.println(task);
        }
    }

    // Complete a task
    public void completeTask(int taskId) {
        Task target_task = null;
        for (Task task : tasks_inProgress) {
            if (task.getId() == taskId) {
                target_task = task;
                break;
            }
        }
        if (target_task==null) {
            System.out.println("Task not found.");
            return;
        }
        tasks_completed.add(target_task);
        tasks_inProgress.remove(target_task);
    }
    // Delete a task
    public void deleteTask(int taskId) {
        //TIP: 使用迭代器来删除元素
        Iterator<Task> iterator = tasks_inProgress.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                iterator.remove();
                break; // 找到并删除后可以退出循环
            }
        }
    }

    // Load tasks from file
    public void loadTasksFromFile() {
    }

    // Save tasks to file
    public void saveTasksToFile() {

    }

    // Constructor
    public TodoLogic() {
        tasks_inProgress = new ArrayList<>();
        tasks_completed = new ArrayList<>();
    }
}
