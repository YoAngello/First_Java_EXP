package edu.course.lab03.Task5;

import java.util.*;

// ии сказал что Поскольку исходная карта может содержать одинаковые значения для разных ключей (например, {"Иван": 25, "Мария": 25}), при простом обмене ключ 25 перезапишется. Чтобы не терять данные, правильнее всего возвращать Map<V, List<K>> (где каждому значению соответствует список ключей).
public class BezopasniMapUtils {
    public static <K, V> Map<V, List<K>> inverseMapSafe(Map<K, V> sourceMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        if (sourceMap == null) return invertedMap;

        for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
            V newKey = entry.getValue();
            K newValue = entry.getKey();

            // Если такого ключа еще нет в новой карте, создаем для него пустой список
            invertedMap.computeIfAbsent(newKey, k -> new ArrayList<>()).add(newValue);
        }

        return invertedMap;
    }
}
