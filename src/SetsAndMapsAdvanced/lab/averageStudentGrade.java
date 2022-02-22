package SetsAndMapsAdvanced.lab;

import java.util.*;

public class averageStudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,List<Double>> studentsGradesMap = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];

            double grade = Double.parseDouble(data[1]);

            if (!studentsGradesMap.containsKey(name)) {

                studentsGradesMap.put(name,new ArrayList<>());
                studentsGradesMap.get(name).add(grade);
            } else {
                studentsGradesMap.get(name).add(grade);
            }

        }

        studentsGradesMap.entrySet()
                .forEach(student -> {
                    List<Double> allGrades = student.getValue();
                    double average = allGrades.stream()
                            .mapToDouble(val -> val).average().orElse(0.0);

                    System.out.printf("%s -> %.2f (avg: %2f)\n",
                    student.getKey(),
                    student.getValue().get(0),
                    average);
                });



    }
}
