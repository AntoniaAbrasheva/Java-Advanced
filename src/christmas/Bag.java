package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }
    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                data.remove(present);
                return true;
            }
        }
        return false;
    }
    public Present heaviestPresent() {
        Present present = null;
        double heaviest = Double.MIN_VALUE;

        for (Present currentPresent : data) {
            if (currentPresent.getWeight() > heaviest) {
                heaviest = currentPresent.getWeight();
                present = currentPresent;
            }
        }
        return present;
    }
    public Present getPresent(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:",color)).append(System.lineSeparator());

        for (Present present : data) {
            sb.append(present).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
