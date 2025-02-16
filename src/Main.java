import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager =  ExpenseManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View total expenses");
            System.out.println("3. View All Expenses with all information");
            System.out.println("4. Set Budget Limit");
            System.out.println("5. Generate Monthly Report");
            System.out.println("6. Delete a expense");
            System.out.println("7. Export Expenses to CSV");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter category (FOOD, TRANSPORT, BILLS, ENTERTAINMENT, SHOPPING, OTHER): ");
                    String categoryInput = scanner.nextLine();
                    Category category = Category.valueOf(categoryInput.toUpperCase());

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    LocalDate date = LocalDate.now(); // Current date

                    Expense expense = new Expense(manager.getExpenses().size() + 1, amount, category, date, description);
                    manager.addExpense(expense);

                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    double totalExpense = manager.getTotalExpenses();
                    System.out.println("Your total expenditure till now is: "+totalExpense);
                    break;

                case 3:
                    manager.viewExpenses();
                    if(manager.isBudgetExceeded()){
                        System.out.println("Warning: you have exceeded your budget limit");
                    }
                    break;

                case 4:
                    System.out.println("Enter budget limit:");
                    double limit = scanner.nextDouble();
                    manager.setBudgetLimit(limit);
                    System.out.println("Budget limit set to: "+limit);
                    break;

                case 5:
                    System.out.print("Enter year (e.g., 2025): ");
                    int year = scanner.nextInt();
                    System.out.print("Enter month (e.g., JANUARY, FEBRUARY): ");
                    String monthInput = scanner.next().toUpperCase();
                    manager.generateMonthlyReport(year, Month.valueOf(monthInput));
                    break;

                case 6:
                    System.out.println("Enter an expense ID to delete: ");
                    int id= scanner.nextInt();
                    manager.deleteExpense(id);
                    break;

                case 7:
                    System.out.print("Enter the CSV file path to export (e.g., C:\\\\Users\\\\YourName\\\\Documents\\\\expenses.csv): ");
                    String path = scanner.nextLine();
                    manager.exportExpensesToCSV(path);
                    break;
                    //C:\Users\Sakshee\Documents\ArduinoData\expenses.csv

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
