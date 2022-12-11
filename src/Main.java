import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        System.out.println("«Счётчик шагов и калорий»");

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker steptracker = new StepTracker();

        while (true) { // обрабатываем вырианты выбора пользователя
            if (userInput == 1) {
                System.out.println("Введите число - номер месяца: 0 - январь, 1 - февраль, " +
                        "2 - март, 3- апрель, 4 - май, 5 - июнь, 6 - июль, 7 - август, 8 - сентябрь, " +
                        "9 - октябрь, 10- ноябрь, 11 - декабрь");
                int month = scanner.nextInt();
                if ((month >= 0) & (month < 12)) {
                    System.out.println("Введите день: ");
                    int day = scanner.nextInt();
                    if ((day >= 1) & (day <= 30)) {
                        System.out.println("Введите количество шагов: ");
                        int step = scanner.nextInt();
                        if (step > 0) {
                            steptracker.saveCountSteps(month, day, step);
                            System.out.println("Значение сохранено!");
                        }
                    } else {
                        System.out.println("Введена некорректная дата. Начните сначала.");
                    }
                } else {
                    System.out.println("Введено некорректное значение месяца. Начните сначала.");
                }
            }

            else if (userInput == 2) {
                System.out.println("Введите месяц - число с 0 (январь) по 11 (декабрь), " +
                        "за который вы хотите получить статистику: ");
                int month = scanner.nextInt();
                if ((month >= 0) & (month < 12)) {
                steptracker.statsPerMonth(month);
                steptracker.bestStepScores(month);
                } else {
                    System.out.println("Вы ввели некорректное значение месяца. Начните сначала.");
                }
            }

            else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов: ");
                int newStepsGoal = scanner.nextInt();
                if (newStepsGoal > 0) {
                    steptracker.TrgSteps(newStepsGoal);
                } else {
                    System.out.println("Цель по количеству шагов должна быть больше 0. Начните сначала.");
                }
            }

            else if (userInput == 4) {
                System.out.println("Выход");
                break;
            }
            else {
                System.out.println("Извините, такой команды пока нет. Начните сначала.");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя

        }
        System.out.println("Программа завершена");
    }

    private static void printMenu () {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день (дни с 1 по 30), в указанный месяц, " +
                "с 0 (январь) по 11 (декабрь)");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");

    }
}