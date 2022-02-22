package aquarium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Aquarium {
    private Map<String, Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashMap<>();
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (!this.fishInPool.containsKey(fish.getName()) && getCapacity() > this.fishInPool.size()) {
            this.fishInPool.put(fish.getName(), fish);
        }
    }

    public Fish findFish(String name) {
        if (this.fishInPool.containsKey(name)) {
            return this.fishInPool.get(name);
        }

        return null;
    }

    public boolean remove(String name) {
        //return this.fishInPool.remove(name) != null;

        if (fishInPool.containsKey(name)) {
            fishInPool.remove(name);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Aquarium: %s ^ Size: %d", getName(), getSize())).append(System.lineSeparator());

        for (Fish fish : this.fishInPool.values()) {
            sb.append(fish.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}

