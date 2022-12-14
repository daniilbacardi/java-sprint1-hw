import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("«Счётчик шагов и калорий»");

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker steptracker = new StepTracker();

        while (true) { // обрабатываем варианты выбора пользователя
            if (userInput == 1) {
                int month = inputUserMonth();
                int day = inputUserDay();
                int step = inputUserStep();
                steptracker.saveCountSteps(month, day, step);
              } else if (userInput == 2) {
                int month = inputUserMonth();
                steptracker.statsPerMonth(month);
                steptracker.bestStepScores(month);
             } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов: ");
                int newStepsGoal = scanner.nextInt();
                if (newStepsGoal > 0) {
                    steptracker.TrgSteps(newStepsGoal);
                } else {
                    System.out.println("Цель по количеству шагов должна быть больше 0. Начните сначала.");
                }
            } else if (userInput == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет. Начните сначала.");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя

        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день, в указанный месяц");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");

    }

    private static int inputUserMonth() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер месяца (с 1 по 12):  ");
            int month = scanner.nextInt();
            if ((month < 1) || (month > 12)) {
                System.out.println("Введено некорректное значение месяца. Начните сначала.");
            } else {
                return month-1;
            }
        }
    }

    private static int inputUserDay() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите дату (с 1 по 30): ");
            int day = scanner.nextInt();
            if ((day < 1) || (day > 30)) {
                System.out.println("Введена некорректная дата. Начните сначала.");
            } else {
                return day;
            }
        }
    }

    private static int inputUserStep() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите количество пройденных шагов: ");
            int step = scanner.nextInt();
            if (step < 0) {
                System.out.println("Количество шагов не должно быть отрицательным. Начните сначала.");
            } else {
                return step;
            }
        }
    }
}
