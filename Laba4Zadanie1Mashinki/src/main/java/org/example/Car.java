package org.example;

import java.util.Random;

class Car extends Thread {
    // Ссылка на объект Parking для работы с парковкой
    private final Parking parking;

    // Конструктор класса Car, принимающий объект Parking
    public Car(Parking parking) {
        this.parking = parking;
    }

    // Основной метод потока
    @Override
    public void run() {
        try {
            // Пытаемся припарковаться
            parking.park(this);
            // Имитация времени, проведенного на парковке
            Random random = new Random();
            Thread.sleep(random.nextInt(15000) + 5000); // Ожидание от 5 до 20 секунд
            // Покидаем парковку
            parking.leave(this);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Обрабатываем прерывание потока
        }
    }
}