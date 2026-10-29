package edu.course.lab03.Task5;

import java.util.HashMap;
import java.util.Map;

public class ObichniyMapUtils {
    public static <K, V> Map<V, K> inverseMapSimple(Map<K, V> sourceMap) {
        Map<V, K> invertedMap = new HashMap<>();

        if (sourceMap == null) return invertedMap;

        for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
            // Просто меняем местами: ключ становится значением, значение — ключом
            invertedMap.put(entry.getValue(), entry.getKey());
        }

        return invertedMap;
    }
}
