package org.example;

public class Main {
    private static int PARKING_CAPACITY = 5;
    // Интервал генерации автомобилей в миллисекундах
    private static final int GENERATION_INTERVAL = 2000; // Интервал генерации автомобилей

    public static void main(String[] args) {
        // Создаем объект Parking с заданной вместимостью
        Parking parking = new Parking(PARKING_CAPACITY);
        //Scanner scanner = new Scanner(System.in); // Сканер для ввода (не используется в текущем коде)

        // Создание отдельного потока для генерирования автомобилей
        Thread carGenerator = new Thread(() -> {
            try {
                int carCount = 0; // Счетчик сгенерированных автомобилей
                while (true) {
                    new Car(parking).start(); // Создаем и запускаем новый поток Car
                    carCount++;
                    //System.out.println("Сгенерирован автомобиль №" + carCount); // Информация о сгенерированных автомобилях
                    Thread.sleep(GENERATION_INTERVAL); // Ожидаем перед созданием следующего автомобиля
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Восстанавливаем прерывание потока
            }
        });

        carGenerator.start(); // Запускаем поток генерации автомобилей

        // Ожидание ввода для завершения программы
        //System.out.println("Нажмите 'Enter' для остановки генерации автомобилей...");
        //scanner.nextLine(); // Чтение строки для остановки
        //carGenerator.interrupt(); // Останавливаем поток генератора
        //scanner.close(); // Закрываем сканер
        //System.out.println("Генерация автомобилей остановлена."); // Сообщение об остановке генерации
    }
}