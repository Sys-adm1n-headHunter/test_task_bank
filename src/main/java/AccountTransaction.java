import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class AccountTransaction implements SavingsAccount {
    private double balance;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    private void addTransactionHistory(String name, char operation, double sum, LocalDate date) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d.MM.uuuu");
        String text = date.format(formatters);

        int count = transactionHistory.size() + 1;
        transactionHistory.add(count + ". " + name + ": " + operation + "" + sum + " руб (" + text + ")");
    }

    public void printTransactionHistory() {
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void deposit(double amount, LocalDate date) {
        if (amount > 0) {
            balance += amount;
            addTransactionHistory("Пополнение", '+', amount, date);
            System.out.println("Счет успешно пополнен на " + amount + " руб.");
        } else {
            System.out.println("Некорректная сумма для пополнения счета!");
        }
    }

    public void withdraw(double amount, LocalDate date) {
        if (balance - amount < 0) {
            System.out.println("Некорректная сумма для снятия со счета!");
            return;
        }
        balance -= amount;
        addTransactionHistory("Снятие", '-', amount, date);
        System.out.println("Со счета снято " + amount + " руб. Баланс: " + balance + " руб.");
    }


    public void checkBalance() {
        System.out.println("Баланс на счете: " + balance + " руб.");
    }

//    Вынес отдельно метод по проверки корректности ввода суммы для зачисления/списания
    public double checkTransactitOperation() {
        double amount;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.println("Некорректная сумма!");
                scanner.nextLine();
            } else if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) {
                    scanner.nextLine();
                    return amount;
                }else {
                    System.out.println("Некорректная сумма!");
                    scanner.nextLine();
                }
            }

        }

    }

}
