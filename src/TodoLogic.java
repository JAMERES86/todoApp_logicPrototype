import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TodoLogic {
    private int id_counter = 0;
    private ArrayList<Task> tasks_inProgress;
    private ArrayList<Task> tasks_completed;
    public static class SavedStates {
        public int id_counter = 0;
        public ArrayList<Task> tasks_inProgress;
        public ArrayList<Task> tasks_completed;
        public SavedStates(int id_counter, ArrayList<Task> tasks_inProgress, ArrayList<Task> tasks_completed) {
            this.id_counter = id_counter;
            this.tasks_inProgress = tasks_inProgress;
            this.tasks_completed = tasks_completed;
        }
    }

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

    public static String save_path = "save/data.json";
    // Save tasks to file (Serialize)
    public void saveStatesToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Map<String, Object> data = new HashMap<>();
//        data.put("id_counter", id_counter);
//        data.put("tasks_inProgress", tasks_inProgress);
//        data.put("tasks_completed", tasks_completed);

        SavedStates savedStates = new SavedStates(id_counter, tasks_inProgress, tasks_completed);

        String json = gson.toJson(savedStates);

        try (java.io.FileWriter writer = new java.io.FileWriter(save_path)) {
            writer.write(json);
        } catch (IOException e) {
//            在错误被捕获时，首先需要printStackTrace以允许定位，然后可以提供上下文信息方便debug。
            System.out.println("[TODOist APP] saving states: Error writing to file");
            e.printStackTrace();
        }
    }

    // Load tasks from file
    public void loadStatesFromFile(){
        try {
            //Read String From File
            String content = Files.readString(Path.of(save_path));
            //Deserialize data from String
            Gson gson = new Gson();
            TodoLogic.SavedStates savedStates = gson.fromJson(content, SavedStates.class);
            //Recover data to member variables
            id_counter = savedStates.id_counter;
            tasks_inProgress = savedStates.tasks_inProgress;
            tasks_completed = savedStates.tasks_completed;

        } catch (IOException e) {
            System.out.println("[TODOist APP] loading states: Error reading from file");
            e.printStackTrace();
        }

    }

    // Constructor
    public TodoLogic() {
        tasks_inProgress = new ArrayList<>();
        tasks_completed = new ArrayList<>();
    }
}
