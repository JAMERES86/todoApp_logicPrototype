import java.util.Calendar;
import java.util.Date;

public class UnitTests {
    public static void testAddTask() {
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.addTask("Task 1");
        todoLogic.addTask("Task 2");
        todoLogic.addTask("Task 3");
        todoLogic.viewTasksInProgress();
    }
    public static void testEditTask() {
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.addTask("Task 1");
        todoLogic.addTask("Task 2");
        todoLogic.addTask("Task 3");
        todoLogic.editTask_name(1, "Edited Task 2");
        todoLogic.viewTasksInProgress();
    }
    public static void testCompleteTask() {
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.addTask("Task 1");
        todoLogic.addTask("Task 2");
        todoLogic.addTask("Task 3");
        System.out.println("Before:");
        todoLogic.viewTasksInProgress();
        todoLogic.viewCompletedTasks();
        todoLogic.completeTask(0);
        todoLogic.completeTask(1);
        todoLogic.completeTask(2);
        System.out.println("After:");
        todoLogic.viewTasksInProgress();
        todoLogic.viewCompletedTasks();
    }
    public static void testDeleteTask() {
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.addTask("Task 1");
        todoLogic.addTask("Task 2");
        todoLogic.addTask("Task 3");
        System.out.println("Before:");
        todoLogic.viewTasksInProgress();
        todoLogic.deleteTask(0);
        System.out.println("After:");
        todoLogic.viewTasksInProgress();
    }
    public static void testSaveTasksToFile() {
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.addTask("Task 1");
        todoLogic.addTask("Task 2");
        todoLogic.addTask("Task 3");
        todoLogic.completeTask(0);
        todoLogic.saveStatesToFile();
    }
    public static void testLoadTasksFromFile() {
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.loadStatesFromFile();
        todoLogic.viewTasksInProgress();
        todoLogic.viewCompletedTasks();
    }
    public static void testSaveAndLoad() {
        TodoLogic todoLogic_session1 = new TodoLogic();
        todoLogic_session1.addTask("洗澡");
        todoLogic_session1.addTask("洗衣服");
        todoLogic_session1.addTask("报名比赛");
        todoLogic_session1.saveStatesToFile();

        TodoLogic todoLogic_session2 = new TodoLogic();
        todoLogic_session2.loadStatesFromFile();
        todoLogic_session2.viewTasksInProgress();
    }
    public static void testDeadline(){
        TodoLogic todoLogic = new TodoLogic();
        todoLogic.addTask("Task 1", new Date(2025-1900, Calendar.JANUARY, 1));
        todoLogic.viewTasks();
        todoLogic.editTask_deadline(0, new Date(2025-1900, Calendar.JANUARY, 8));
        System.out.println();

        todoLogic.viewTasks();
    }
    public static void main(String[] args) {
        testDeadline();
    }
}
