public class StepTracker {

    int TargetSteps = 10000;
    Converter converter = new Converter();
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    static class MonthData {
        int[] daysDate = new int[30];
    }
    void saveCountSteps(int month, int day, int steps) {
        monthToData[month].daysDate[day-1] = steps;
    }
    void statsPerMonth(int month) {
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + monthToData[month].daysDate[i]);
        }

        int sumSteps = 0;
        int maxSteps = 0;
        int avgSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + monthToData[month].daysDate[i];
            avgSteps = sumSteps / 30;
            if ((monthToData[month].daysDate[i]) > maxSteps) {
                maxSteps = monthToData[month].daysDate[i];
            }
        }

        System.out.println("Всего пройдено шагов за месяц - " + sumSteps);
        System.out.println("Максимальное количество шагов за день - " + maxSteps);
        System.out.println("Среднее количество шагов за месяц - " + avgSteps);
        System.out.println("Пройденная дистанция за месяц - " + converter.kilometers(sumSteps) + " км.");
        System.out.println("Сожженые килокалории - " + converter.kiloKal(sumSteps));
    }

    void TrgSteps(int goal) {
        System.out.println("Новая цель по количеству шагов " + goal);
        TargetSteps = goal;
    }

    void bestStepScores(int month) {

        int indexScoreDays = 0;
        int bestScoreDays = 0;

        for (int i= 0; i < monthToData.length; i++) {
            if (monthToData[month].daysDate[i] >= TargetSteps) {
                indexScoreDays++;
            }
            else indexScoreDays = 0;
            if (indexScoreDays > bestScoreDays) {
                bestScoreDays = indexScoreDays;
            }
        } // исхожу из того, что требование "подряд идущих дней, в течение которых..." - это больше 1 дня
        if (bestScoreDays > 1) {
            System.out.println("Лучшая серия по количеству шагов: " + bestScoreDays);
        }
        else
            System.out.println("Лучшая серия по количеству шагов: 0");
    }
}