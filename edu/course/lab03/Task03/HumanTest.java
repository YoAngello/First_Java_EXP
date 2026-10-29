package edu.course.lab03.Task03;

import java.util.*;
//runnable чтобы по приколу запихнуть в поток
public class HumanTest implements Runnable{
    @Override
    public void run() {
        // Создаем исходный список людей
        List<Human> humanList = new ArrayList<>(List.of(
                new Human("Иван", "Иванов", 25),
                new Human("Анна", "Петрова", 19),
                new Human("Сергей", "Иванов", 30),
                new Human("Мария", "Сидорова", 25),
                new Human("Иван", "Иванов", 25)
        ));
        System.out.println("--- Выполнение теста множеств ---");

        // 1. HashSet
        Set<Human> hashSet = new HashSet<>(humanList);
        System.out.println("\n1. HashSet:\n" + hashSet);

        // 2. LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humanList);
        System.out.println("\n2. LinkedHashSet:\n" + linkedHashSet);

        // 3. TreeSet (Natural Order)
        Set<Human> treeSetNatural = new TreeSet<>(humanList);
        System.out.println("\n3. TreeSet (по возрасту):\n" + treeSetNatural);

        // 4. TreeSet (по фамилии)
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humanList);
        System.out.println("\n4. TreeSet (по фамилии):\n" + treeSetByLastName);

        // 5. TreeSet (анонимный компаратор по возрасту)
        Set<Human> treeSetByAgeAnonymous = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAgeAnonymous.addAll(humanList);
        System.out.println("\n5. TreeSet (анонимный по возрасту):\n" + treeSetByAgeAnonymous);
    }
}
