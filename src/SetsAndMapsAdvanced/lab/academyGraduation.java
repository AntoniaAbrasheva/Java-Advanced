package SetsAndMapsAdvanced.lab;

import java.text.DecimalFormat;
import java.util.*;

public class academyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> studentsScoresMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine()
                            .split("\\s+")).mapToDouble(Double::parseDouble)
                             .toArray();
            double allScores = 0;
            int count = 0;

            for (int j = 0; j < scores.length; j++) {
                count++;

                allScores += scores[j];


            }

            double average = allScores / count;
            String df = new DecimalFormat("0.################################").format(average);

            studentsScoresMap.put(name,df);

        }

        studentsScoresMap.entrySet()
                .forEach(student -> System.out.printf("%s is graduated with %s\n",student.getKey(),student.getValue()));
    }
}
