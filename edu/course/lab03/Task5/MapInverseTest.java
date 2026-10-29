package edu.course.lab03.Task5;

import java.util.*;

public class MapInverseTest {
    // Метод 1: Простой обмен (Map<V, K>)
    public <K, V> Map<V, K> inverseMapSimple(Map<K, V> sourceMap) {
        Map<V, K> invertedMap = new HashMap<>();
        if (sourceMap != null) {
            for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
                invertedMap.put(entry.getValue(), entry.getKey());
            }
        }
        return invertedMap;
    }

    // Метод 2: Безопасный обмен с группировкой (Map<V, List<K>>)
    public <K, V> Map<V, List<K>> inverseMapSafe(Map<K, V> sourceMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        if (sourceMap != null) {
            for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
                invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                        .add(entry.getKey());
            }
        }
        return invertedMap;
    }

    // Запуск теста
    public void run() {
        System.out.println("=== Тест: Обмен ключей и значений ===");

        // Заполняем тестовую карту (Студент -> Оценка за экзамен)
        Map<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("Алексей", 5);
        studentGrades.put("Дмитрий", 4);
        studentGrades.put("Елена", 5); // Дубликат значения (тоже 5)
        studentGrades.put("Ольга", 3);

        System.out.println("1. Исходная карта (Студент -> Оценка):");
        System.out.println("   " + studentGrades);

        // Демонстрация простого обмена
        Map<Integer, String> simpleResult = inverseMapSimple(studentGrades);
        System.out.println("\n2. Результат простого обмена (Map<Оценка, Студент>):");
        System.out.println("   " + simpleResult);
        System.out.println("   * Примечание: Один из студентов с оценкой 5 пропал из-за перезаписи ключа!");

        // Демонстрация безопасного обмена
        Map<Integer, List<String>> safeResult = inverseMapSafe(studentGrades);
        System.out.println("\n3. Результат безопасного обмена (Map<Оценка, List<Студент>>):");
        System.out.println("   " + safeResult);
        System.out.println("   * Примечание: Все данные сохранены и сгруппированы корректно.");
    }

    public static void main(String[] args) {
        MapInverseTest test = new MapInverseTest();
        test.run();
    }
}
