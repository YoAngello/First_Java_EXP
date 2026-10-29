package edu.course.lab03.TaskAkt4;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public void runAnalysis(String text) {
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Текст пуст или равен null.");
            return;
        }

        // 1. Приводим весь текст к нижнему регистру (чтобы слова "Apple" и "apple" были одинаковыми)
        String lowerCaseText = text.toLowerCase();

        // 2. Удаляем знаки препинания, заменяя их на пустую строку, кроме пробелов
        // Регулярное выражение [^a-z ] означает: "всё, что НЕ является латинской буквой или пробелом"
        String cleanedText = lowerCaseText.replaceAll("[^a-z ]", "");

        // 3. Разбиваем строку на отдельные слова по одному или нескольким пробелам (\\s+)
        String[] words = cleanedText.split("\\s+");

        // 4. Используем HashMap для подсчета частоты встречаемости слов
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            // Пропускаем возможные пустые строки, которые могли возникнуть при делении
            if (word.isEmpty()) continue;

            // Метод merge: если слова нет в карте — ставит 1, если есть — суммирует старое значение с 1
            wordCounts.merge(word, 1, Integer::sum);
        }

        // 5. Выводим результаты на консоль
        System.out.println("--- Частота встречаемости слов ---");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
