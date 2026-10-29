package edu.course.lab03.TaskAkt4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tiest {
    // Метод, содержащий логику анализа
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Тест: Частота слов ===");
        System.out.print("Введите текст на английском языке: ");

        String input = scanner.nextLine();

        if (input == null || input.trim().isEmpty()) {
            System.out.println("Ошибка: Введена пустая строка!");
            return;
        }

        // Очистка текста: в нижний регистр и удаление знаков препинания
        String cleanedText = input.toLowerCase().replaceAll("[^a-z ]", "");

        // Разделение по пробелам
        String[] words = cleanedText.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.merge(word, 1, Integer::sum);
            }
        }

        // Вывод результатов
        System.out.println("\nРезультат подсчета частоты слов:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println("  \"" + entry.getKey() + "\" -> встретилось " + entry.getValue() + " раз(а)");
        }
    }

    public static void main(String[] args) {
        // Создаем экземпляр теста и запускаем его
        Tiest test = new Tiest();
        test.run();
    }
}
