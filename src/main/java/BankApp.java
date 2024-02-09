import java.time.LocalDate;
import java.util.Scanner;

public class BankApp extends AccountTransaction {
    private static double amount = 0;
    private boolean isExit = false;

    //   Метод для выбора операции
    public void choosingAnOperation() {
        Scanner scanner = new Scanner(System.in);
        int operationNumber;

        boolean isExit = false;
        System.out.println("Добро пожаловать в приложение \"Банковский счет\"!\n" +
                "1. Пополнить счет\n" +
                "2. Снять деньги\n" +
                "3. Проверить баланс\n" +
                "4. История транзакций\n" +
                "5. Выход\n");


        while (!isExit) {
            System.out.print("Выберите действие (введите номер): ");
            if (scanner.hasNextInt()) {
                operationNumber = scanner.nextInt();
                switch (operationNumber) {
                    case 1:
                        System.out.print("Введите сумму для пополнения: ");
                        deposit(checkTransactitOperation(), LocalDate.now());
                        break;
                    case 2:
                        System.out.print("Введите сумму для снятия: ");
                        withdraw(checkTransactitOperation(), LocalDate.now());
                        break;

                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        printTransactionHistory();
                        break;
                    case 5:
                        System.out.println("До свидания!");
                        isExit = true;
                        break;
                    default:
                        System.out.println("Номер введен некорректно,введите число от 1 до 5 (включительно)!");
                }
            } else {
                System.out.println("Номер введен некорректно,введите число от 1 до 5 (включительно)!");
                scanner.nextLine();
            }
        }
    }
}





