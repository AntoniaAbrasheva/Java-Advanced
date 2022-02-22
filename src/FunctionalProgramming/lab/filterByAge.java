package FunctionalProgramming.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class filterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> names = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] lines = scanner.nextLine().split(",\\s+");
            String name = lines[0];
            int age = Integer.parseInt(lines[1]);

            names.put(name,age);

        }

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Integer,Integer> filterPredicate;

          if (condition.equals("younger")) {
              filterPredicate = (personAge,age) -> personAge <= age;
          } else {
              filterPredicate = (personAge,age) -> personAge >= age;

          }

        Consumer<Map.Entry<String,Integer>> printer;

          if (format.equals("age")) {
              printer = person -> System.out.println(person.getValue());
          } else if (format.equals("name")) {
              printer = person -> System.out.println(person.getKey());
          } else {
              printer = person -> System.out.printf("%s - %s\n",person.getKey(),person.getValue());
          }

          names.entrySet()
                  .stream()
                  .filter(person -> filterPredicate.test(person.getValue(),ageLimit))
                  .forEach(printer);
    }
}
