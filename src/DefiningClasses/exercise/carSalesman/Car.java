package DefiningClasses.exercise.carSalesman;

public class Car {
    private String model;
    private String engineModel;
    private int weight;
    private String color;

    //1. начин -> model, engineModel
    //2. начин -> model, engineModel, weight, color
    //3. начин -> model, engineModel, weight
    //3. начин -> model, engineModel, color

    public Car(String model,String engineModel) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model,String engineModel,int weight,String color) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = color;
    }
    public Car(String model,String engineModel,int weight) {
        this.model = model;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = "n/a";
    }
    public Car(String model,String engineModel,String color) {
        this.model = model;
        this.engineModel = engineModel;
        this.color = color;
        this.weight = 0;
    }

    public String getModel() {
        return model;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
    public static String getFullName() {
        return "Test";
    }
}
