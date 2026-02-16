import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
void main() {
    TodoLogic todoLogic = new TodoLogic();
    todoLogic.loadStatesFromFile();
    while (true) {
        String text = scanner.nextLine();
        switch ( text){
            case "exit":
                System.out.println("退出程序指令收到，保存中");
                todoLogic.saveStatesToFile();
                return;
        }
    }
}