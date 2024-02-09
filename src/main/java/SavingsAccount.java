import java.time.LocalDate;

public interface SavingsAccount {
    void deposit(double amount, LocalDate date);

    void withdraw(double amount, LocalDate date);
}
