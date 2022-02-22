package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        boolean isSold = false;
        Parrot foundParrot = null;
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(true);
                foundParrot = parrot;
                isSold = true;
            }
            if (isSold) {
                break;
            }
        }
        data.remove(foundParrot);
        return foundParrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                soldParrots.add(parrot);
            }
        }
        data.removeAll(soldParrots);
        return soldParrots;
    }
    public int count() {
        return data.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:",name)).append(System.lineSeparator());
        for (Parrot parrot : data) {
            sb.append(parrot).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
