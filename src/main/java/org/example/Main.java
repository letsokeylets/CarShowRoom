package org.example;

/**
 * Main Class
 */
public class Main {
    public static void main(String[] args) {
        CarShowRoom carShowRoom = new CarShowRoom();
        new Thread(carShowRoom::byCar, "Покупатель 1").start();
        new Thread(carShowRoom::byCar, "Покупатель 2").start();
        new Thread(carShowRoom::byCar, "Покупатель 3").start();
        new Thread(carShowRoom::productionCar, "Продавец").start();
    }
}