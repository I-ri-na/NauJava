package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Task5Queue implements Task {

    private final Queue<String> queue = new LinkedList<>();
    private volatile boolean running = false;
    private Thread workerThread;

    public Task5Queue() {
        queue.add("Задача 1");
        queue.add("Задача 2");
        queue.add("Задача 3");
        queue.add("Задача 4");
        queue.add("Задача 5");
    }

    @Override
    public void start() {
        running = true;
        workerThread = new Thread(() -> {
            System.out.println("Обработка очереди запущена...");
            while (running && !queue.isEmpty()) {
                String item = queue.poll();
                System.out.println("Обработано: " + item);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (queue.isEmpty()) {
                System.out.println("Очередь пуста. Обработка завершена.");
            }
        });
        workerThread.start();
        try {
            workerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("Обработка остановлена.");
    }

    public static void main(String[] args) {
        Task5Queue task = new Task5Queue();
        task.start();
        task.stop();
    }
}
