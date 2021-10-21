package org.example;

import java.util.ArrayList;
import java.util.List;

public class CarShowRoom {
    final public int CARS_IN_SHOW_ROOM = 10;
    final public Long TIMEOUT = 2000L;

    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>();
    private int count = 0;

    public int getByCount() {
        return count;
    }

    public void setByCount() {
        count++;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void byCar() {
        while (true) {
            if (getByCount() < CARS_IN_SHOW_ROOM) {
                seller.sellCar();
            } else {
                System.out.println("Продано 10 автомобилей");
                System.exit(0);
            }
        }
    }

    public void productionCar() {
        for (int i = 0; i < CARS_IN_SHOW_ROOM; i++) {
            seller.productionCar();
        }
        System.out.println("Производитель больше не делает авто");
    }
}
