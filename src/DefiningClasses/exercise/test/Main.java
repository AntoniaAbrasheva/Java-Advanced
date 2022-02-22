package DefiningClasses.exercise.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

       List<Cat> catList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String breed = data[2];




            Cat myCat = null;

           if (data.length == 3) {
               myCat = new Cat(name,age,breed);
               catList.add(myCat);

               catList.forEach(cat -> System.out.printf("%s is %d years old cat.She has %s breed.\n",
                       cat.getName(),cat.getAge(),cat.getBreed()));



           } else if (data.length == 4) {
               String eyesColor = data[3];
               myCat = new Cat(name,age,breed,eyesColor);
               catList.add(myCat);
               catList.forEach(cat -> System.out.printf("%s is %d years old cat.She has %s breed and %s eyes.\n",
                       cat.getName(),cat.getAge(),cat.getBreed(),cat.getEyesColor()));


           } else {
               String furColor = data[3];
               String eyesColor = data[4];

               myCat = new Cat(name,age,breed,furColor,eyesColor);
               catList.add(myCat);

               catList.forEach(cat -> System.out.printf("%s is %d years old cat.She has %s breed, %s fur and %s eyes.\n",
                       cat.getName(),cat.getAge(),cat.getBreed(),cat.getFurColor(),cat.getEyesColor()));


           }




        }




    }
}
