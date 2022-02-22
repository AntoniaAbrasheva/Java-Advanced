package DefiningClasses.exercise.test;

public class Cat {

    //mandatory
    private String name;
    private int age;
    private String breed;

    //optional
    private String furColor;
    private String eyesColor;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getFurColor() {
        return furColor;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;

    }

    public Cat(String name,int age,String breed,String furColor,String eyesColor) {
        this(name,age,breed);
        this.furColor = furColor;
        this.eyesColor = eyesColor;

    }

    public Cat(String name,int age,String breed,String eyesColor) {
        this(name,age,breed);
        this.eyesColor = eyesColor;


    }




    }




