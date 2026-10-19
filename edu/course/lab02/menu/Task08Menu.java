package edu.course.lab02.menu;

import java.util.Scanner;
import edu.course.lab02.numbers.Task01Integers;
import edu.course.lab02.numbers.Task02Floats;
import edu.course.lab02.numbers.Task03Bitwise;
import edu.course.lab02.strings.Task04Text;
import edu.course.lab02.arrays.Task05Arrays;
import edu.course.lab02.arrays.Task06Matrices;
import edu.course.lab02.util.Task07Methods;

public class Task08Menu {
    public void run() {
        // Используем стандартный System.in с кодировкой UTF-8
        Scanner scanner = new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8);
        int choice;
        do {
            printHelpMenu();
            System.out.print("Введите номер задания (или 0 для выхода): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: Введите корректное целое число.\n");
                scanner.next(); // очистка буфера некорректного ввода
                choice = -1;
                continue;
            }

            choice = scanner.nextInt();

            // Современный switch-выражение (стрелочный синтаксис)
            switch (choice) {
                case 1 -> new Task01Integers().run();
                case 2 -> new Task02Floats().run();
                case 3 -> new Task03Bitwise().run();
                case 4 -> new Task04Text().run();
                case 5 -> new Task05Arrays().run();
                case 6 -> new Task06Matrices().run();
                case 7 -> new Task07Methods().run();
                case 0 -> System.out.println("Выход из программы. До свидания!");
                default -> System.out.println("Задание с таким номером не существует. Попробуйте еще раз.\n");
            }

        } while (choice != 0);
    }

    private void printHelpMenu() {
        // Использование текстового блока Java (Текстовые блоки доступны с Java 15+)
        String menuText = """
            ==================================================
                       ЛАБОРАТОРНАЯ РАБОТА №1 (МЕНЮ)
            ==================================================
            1. Целочисленные ловушки (Типы, переполнения)
            2. Вещественная арифметика (Double, Точность)
            3. Побитовые операции (&, |, ^, сдвиги)
            4. Обработка текста (Строки, Палиндромы, Шифр)
            5. Одномерные массивы (Сортировка вставками)
            6. Многомерные массивы (Матрицы)
            7. Методы и передача аргументов (Varargs, Степень)
            0. Выход
            ==================================================
            """;
        System.out.print(menuText);
    }
}
