package org.example;


/**
 * Класс производителя
 */
public class Seller {

    private CarShowRoom shop;

    public Seller(CarShowRoom shop) {
        this.shop = shop;
    }

    public synchronized void productionCar() {
        try {
            System.out.println("Производитель Toyota начал производство авто");
            Thread.sleep(shop.TIMEOUT);
            shop.getCars().add(new Car());
            System.out.println("Производитель Toyota создал 1 автомобиль");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void sellCar() {
        final String name = Thread.currentThread().getName();
        try {
            System.out.println(name + " зашел в автосалон");
            while (shop.getCars().isEmpty()) {
                System.out.println("Машин нет");
                wait();
            }
            System.out.println(name + " уехал на новеньком авто");
            Thread.sleep(shop.TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shop.setByCount();
        shop.getCars().remove(0);
    }

}
