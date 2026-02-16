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
        todoLogic.editTask(1, "Edited Task 2");
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
    public static void main(String[] args) {
        testDeleteTask();
    }
}
