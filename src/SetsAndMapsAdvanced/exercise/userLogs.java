package SetsAndMapsAdvanced.exercise;

import com.sun.source.tree.Tree;

import java.util.*;

public class userLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // user -> { ip -> count }

        TreeMap<String, LinkedHashMap<String,Integer>> data = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] inputParts = input.split("\\s+");
            String ip = inputParts[0].split("=")[1];
            String message = inputParts[1].split("=")[1];
            String username = inputParts[2].split("=")[1];

            if (!data.containsKey(username)) {
                data.put(username, new LinkedHashMap<>());
                data.get(username).put(ip,1);
            } else {
                Map<String,Integer> currentIP = data.get(username);
                if (currentIP.containsKey(ip)) {
                    int currentTimes = currentIP.get(ip);
                    currentIP.put(ip,currentTimes + 1);
                } else {
                    currentIP.put(ip,1);
                }
            }

            input = scanner.nextLine();
        }
       data.entrySet().stream().sorted((f,s) -> f.getKey().compareTo(s.getKey()))
               .forEach(e -> {
                   System.out.println(e.getKey() + ":");
                   List<String> ip = new ArrayList<>();
                   Map<String,Integer>  map = e.getValue();
                   for(Map.Entry<String,Integer> entry : map.entrySet()) {
                       String toAdd = entry.getKey() + " => " + entry.getValue();
                       ip.add(toAdd);
                   }
                   System.out.println(String.join(", ",ip) + ".");
               });

    }
}
