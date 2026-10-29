package edu.course.lab03;

import java.util.*;


public class Task01Collections {
    public static void run(){
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        int N = 7;

        //Создаем массив нужного размера или предустановленного 7
        System.out.print("Введите размер массива: ");
        if (scanner.hasNextInt()){
            N = scanner.nextInt();
        }
        else {
            System.out.print("Ошибка! Я сделаю массив из 7 чисел.");
        }
        Integer[] array = new Integer[N];
        scanner.close();
        for (int i = 0; i < array.length; i++){
            array[i] = rnd.nextInt(100) + 1;
        }
        System.out.print("Массив:   " + Arrays.toString(array));

        //Делаем список из массива
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < array.length; i++){
            list.add(array[i]);
        }   //List<Integer> list = new ArrayLrray)ist<>(Arrays.asList(a); можно еще так но с интом не сработает
        System.out.print("Список:   " + list);

        //Сортировка по возрастанию через класс утилиту Collections
        Collections.sort(list);
        System.out.println("Отсортированный по возрастанию список: " + list);

        //Сортировка наоборот (просто sort)
        list.sort(Comparator.reverseOrder());
        System.out.println(list);  //устал писать красивый вывод

        //Перемешивание
        Collections.shuffle(list); //класс класс
        System.out.println(list);

        //сдвиг вправо
        Collections.rotate(list,1);
        System.out.println(list);

        //сдвиг влево
        Collections.rotate(list, -1);
        System.out.println(list);

        //только уникальные
        List<Integer> uniqueList = new ArrayList<>(new LinkedHashSet<>(list)); //выбрасываем элементы в множество и обратно
        System.out.println(uniqueList);

        //только повторные
        List<Integer> duplicatesList = new ArrayList<>(list);
        duplicatesList.removeIf(element -> duplicatesList.indexOf(element)
                == duplicatesList.lastIndexOf(element));
        System.out.println(duplicatesList);

        // Получаем массив Integer[]
        Integer[] againArray = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : list){
            counts.merge(num, 1, Integer::sum);
        }
        // Красиво выводим результат
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            System.out.println("Число " + entry.getKey() + " встретилось " + entry.getValue() + " раз(а)");
        }
    }
}
