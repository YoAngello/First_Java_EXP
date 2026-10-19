package edu.course.lab02;

import edu.course.lab02.menu.Task08Menu;

public class Main {
    public static void main(String[] args) {
        // Точка входа делегирует управление консольному меню (Задание №8)
        Task08Menu menu = new Task08Menu();
        menu.run();
    }
}

