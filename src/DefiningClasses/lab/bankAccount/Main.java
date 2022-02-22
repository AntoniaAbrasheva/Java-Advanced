package DefiningClasses.lab.bankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer,BankAccount> accounts = new HashMap<>();

        String[] lines = scanner.nextLine().split("\\s+");
        String command = lines[0];

        while (!command.equals("End")) {
            String result = "";

            switch (command) {
                case "Create":

                    BankAccount bankAccount = new BankAccount();
                    accounts.put(bankAccount.getId(),bankAccount);

                    result = String.format("Account ID%d created",bankAccount.getId());
                    break;

                case "Deposit":
                    int accountID = Integer.parseInt(lines[1]);
                    double money = Double.parseDouble(lines[2]);

                    if (accounts.containsKey(accountID)) {

                        BankAccount bankAccountFromMap = accounts.get(accountID);
                        bankAccountFromMap.deposit(money);
                        accounts.put(accountID,bankAccountFromMap);
                        result = String.format("Deposited %.0f to ID%d",money,accountID);

                    } else {
                        result = "Account does not exist";

                    }
                    break;

                case "SetInterest":
                    double interestRate = Double.parseDouble(lines[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;

                case "GetInterest":
                    int accountId = Integer.parseInt(lines[1]);
                    int years = Integer.parseInt(lines[2]);

                    if (accounts.containsKey(accountId)) {
                        BankAccount bankAccount1 = accounts.get(accountId);
                        double totalInterest = bankAccount1.getInterest(years);
                        result = String.format("%.2f",totalInterest);
                    } else {
                        result = "Account does not exist";
                    }
                    break;

            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }


            lines = scanner.nextLine().split("\\s+");
            command = lines[0];

        }


    }
}
