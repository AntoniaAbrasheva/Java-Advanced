package DefiningClasses.exercise.oppinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] lines = scanner.nextLine().split("\\s+");
            String name = lines[0];
            int age = Integer.parseInt(lines[1]);

            Person person = new Person(name,age);

            if (age > 30) {
                personList.add(person);
            }

        }
        personList.sort(Comparator.comparing(person -> person.getName()));

        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
