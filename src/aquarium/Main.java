package aquarium;

public class Main {
    public static void main(String[] args) {

        Fish fish = new Fish("Goldy", "gold", 4);
        System.out.println(fish);

        Aquarium aquarium = new Aquarium("Ocean", 5, 15);

        aquarium.add(fish);
        aquarium.getFishInPool();

        aquarium.findFish("Goldy");



        System.out.println(aquarium.remove("Goldy"));

        Fish secondFish = new Fish("Dory", "blue", 2);
        Fish thirdFish = new Fish("Nemo", "orange", 5);

        // Add fish
        aquarium.add(secondFish);
        aquarium.add(thirdFish);

        System.out.println(aquarium.report());






    }
}
