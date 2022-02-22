package DefiningClasses.exercise.catLady;

public class Cat {
    private String breed;
    private String name;
    private double size;

    public Cat(String breed, String name, double size) {
        this.breed = breed;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",breed,name,size);
    }
}
