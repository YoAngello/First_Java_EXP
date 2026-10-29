package edu.course.lab03;

import java.util.Iterator;
import java.util.Scanner;

public class Task02TESTgenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество простых чисел (N): ");

        int N;
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
            if (N <= 0) {
                System.out.println("Ошибка! Число должно быть больше 0. Будет использовано N = 5.");
                N = 5;
            }
        } else {
            System.out.println("Ошибка ввода! Будет выведено 5 чисел по умолчанию.");
            N = 5;
        }
        scanner.close();

        System.out.println("\n--- Генерация " + N + " простых чисел ---");

        // Создаем объект
        Task02PrimesGenerator generator = new Task02PrimesGenerator(N);

        //Вывод в прямом порядке
        System.out.print("Прямой порядок:  ");
        //можно for из-за Iterable
        for (int prime : generator) {
            System.out.print(prime + " ");
        }
        System.out.println(); // Перенос строки

        //Вывод в обратном порядке
        // Используем кастомный reverseIterator через классический цикл while
        System.out.print("Обратный порядок: ");
        Iterator<Integer> reverse = generator.reverseIterator();
        while (reverse.hasNext()) {
            System.out.print(reverse.next() + " ");
        }
        System.out.println();
    }
}
