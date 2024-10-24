package org.example;

import java.util.LinkedList;
import java.util.Queue;

class Parking {
    // Максимальная вместимость парковки
    private final int capacity;
    // Очередь для ожидания автомобилей, которые хотят припарковаться
    private final Queue<Car> waitingQueue = new LinkedList<>();

    // Конструктор класса Parking, устанавливающий вместимость
    public Parking(int capacity) {
        this.capacity = capacity;
    }

    // Метод для парковки машины
    public synchronized void park(Car car) throws InterruptedException {
        // Цикл, который ждет, пока не освободится место на парковке
        while (waitingQueue.size() >= capacity) {
            System.out.println(car.getName() + " ожидает парковки.");
            wait(); // Ждем, пока не освободится место
        }

        // Добавляем машину в очередь
        waitingQueue.add(car);
        System.out.println(car.getName() + " припарковался. Мест занято: " + waitingQueue.size());
    }

    // Метод, который вызывается, когда машина покидает парковку
    public synchronized void leave(Car car) {
        // Удаляем машину из очереди
        waitingQueue.remove(car);
        System.out.println(car.getName() + " покинул парковку. Мест занято: " + waitingQueue.size());
        notifyAll(); // Уведомляем все потоки о том, что место освободилось
    }
}