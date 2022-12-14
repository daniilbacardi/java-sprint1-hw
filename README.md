# java-sprint1-hw
First sprint homework

# Консольное приложение «Счётчик шагов и калорий»

### Пользовательский функционал:

1. Консольный интерфейс для управления программой 
2. Ввод и хранение данных о количестве пройденных шагов за несколько месяцев; 
3. Ввод и хранение цели по количеству шагов в день;
4. Ввод пройденного количества шагов за день;
5. Вывод статистики за определённый месяц:

* Количество пройденных шагов по дням:
* Общее количество шагов за месяц;
* Максимальное дневное количество пройденных шагов в месяце;
* Среднее количество шагов за месяц;
* Общая пройденная дистанция за месяц (в км);
* Количество сожжённых килокалорий за месяц;
* Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.

6. Завершение работы приложения по выбору пользователя.

****

**Сохранение количества шагов за день**

Пользователь должен указать номер месяца (с 1 до 12), номер дня (с 1 до 30) и количество шагов, пройденных в этот день. Вводимые значения должны быть неотрицательными. 
Для ускорения прототипирования на данном этапе считается, что в месяце ровно 30 дней. Если за какой-то день статистика не сохранялась, то считаем количество шагов в этот день равным 0.

**Подсчёт и вывод статистики за указанный пользователем месяц**

Данные статистики:
* Количество пройденных шагов по дням в следующем формате:
1 день: 3000, 2 день: 2000...
* Общее количество шагов за месяц;
* Максимальное пройденное количество шагов в месяце;
* Среднее количество шагов;
* Пройденная дистанция (в км);
* Количество сожжённых килокалорий;
* Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.

**Изменение целевого количества шагов**

Данные вводятся пользователем. Допускается только целое положительное значение.

****

### Main Class

Реализован основной цикл приложения: считывание и обработка пользовательских команд и вызов соответствующих методов класса StepTracker.

Пользователь взаимодействует с приложением через консольный интерфейс, который позволяет произвести одно из действий по выбору:  
1. Ввести количество шагов за определённый день;  
2. Напечатать статистику за определённый месяц;  
3. Изменить цель по количеству шагов в день;  
4. Выйти из приложения.

После выбора и исполнения действия, приложение позволяет пользователю ввести следующее действие. Приложение завершается только при вводе пользователем команды выхода. При вводе несуществующей команды выводится сообщение о том, что такой команды нет, после чего приложение возвращается в основное меню и позволяет снова выбрать действие.

### StepTracker Class
Это класс с основной логикой приложения — в нём хранится информация о пройденных шагах, реализована логика по сохранению и изменению количества шагов, а так же рассчитывается статистика.
В памяти приложения хранится следующая информация:  

* Данные о шагах, пройденных в каждый день любого из 12 месяцев. В году 12 месяцев и для удобства считаем, что в каждом ровно 30 дней.
* Целевое количество шагов. При старте приложения устанавливается равным 10 000 в день.

### Converter Class

В этом классе осуществляется преобразование шагов в километры и калории.  
* Для подсчёта дистанции считаем, что один шаг равен 75 см.  
* Для подсчёта количества сожжённых килокалорий считаем, что 1 шаг = 50 калорий, 1 кк = 1 000 калорий.
