package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }
    public boolean buy(String manufacturer,String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        int latestYear = Integer.MIN_VALUE;

        for (Car currentCar : data) {
            if (currentCar.getYear() > latestYear) {
                latestYear = currentCar.getYear();
                car = currentCar;
            }
        }
        return car;
    }
    public Car getCar(String manufacturer, String model) {
        Car car = null;

        for (Car car1 : data) {
            if (car1.getManufacturer().equals(manufacturer) && car1.getModel().equals(model)) {
                return car1;
            }
        }
        return car;
    }
    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:\n",this.name));
        for (Car car : data) {
           sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
