import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        boolean isContinue = true;
        while (isContinue) {
            showMenu();
            String value = sc.nextLine();
            switch (value) {
                case "0":
                    isContinue = false;
                    break;
                case "1":
                    addTask();
                    break;
                case "2":
                    showTasks();
                    break;
                case "3":
                    delByNumber();
                    break;
                case "4":
                    delByName();
                    break;
                case "5":
                    delByKeyWord();
                    break;
                default:
                    System.out.println("Команда неопределена");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.print("\nВыберите операцию:\n" +
                "0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить дело по ключевому слову\n" +
                "Ваш выбор: ");
    }

    public static void showTasks() {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
        }
    }

    public static void addTask() {
        System.out.print("Введите название задачи: ");
        String value = sc.nextLine();
        tasks.add(tasks.size(), value);
        showTasks();
    }

    public static void delByNumber() {
        System.out.print("Введите номер задачи на удаление: ");
        int value = Integer.parseInt(sc.nextLine()) - 1;
        if (value >= 0 && value < tasks.size()) {
            tasks.remove(value);
            System.out.println("Удалено!");
            showTasks();
        } else {
            System.out.println("Задачи с таким номером не существует...");
        }
    }

    public static void delByName() {
        System.out.print("Введите имя задачи на удаление: ");
        String value = sc.nextLine();
        if (tasks.contains(value)) {
            tasks.remove(value);
            System.out.println("Удалено!");
            showTasks();
        } else {
            System.out.println("Задачи с таким именем не существует...");
        }
    }

    public static void delByKeyWord() {
        System.out.print("Введите ключевое слово задачи на удаление: ");
        String value = sc.nextLine();

        Iterator<String> iter = tasks.iterator();

        int counter = 0;
        while (iter.hasNext()) {

            String task = iter.next();
            if (task.contains(value)) {
                iter.remove();
                counter++;
                System.out.println("Удалено!");
                showTasks();
            }
        }
        if (counter == 0) {
            System.out.println("Задач с таким ключевым словом не существует...");
        }
    }
}
