import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class ExpenseManager {
    private final List<Expense> expenses;
    private double budgetLimit;
    private final String FILE_NAME = "expenses.txt";

    private static ExpenseManager instance;



    private ExpenseManager() {
        expenses = new ArrayList<>();
        loadExpensesFromFile();
    }

    public static ExpenseManager getInstance(){
        if(instance == null){
            instance = new ExpenseManager();
        }
        return instance;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpensesToFile();
    }

    public void viewExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }
    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setBudgetLimit(double budgetLimit){
        this.budgetLimit= budgetLimit;
    }

    public double getBudgetLimit(){
        return budgetLimit;
    }

    public double getTotalExpenses(){
        double total=0;
        for(Expense e: expenses){
            total+=e.getAmount();
        }
        return total;
    }

    public boolean isBudgetExceeded(){
        return getTotalExpenses() > budgetLimit;
    }

    private void saveExpensesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.println(expense.getId() + "," + expense.getAmount() + "," +
                        expense.getCategory() + "," + expense.getDate() + "," +
                        expense.getDescription());
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    // File loading method
    private void loadExpensesFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Expense expense = new Expense(
                        Integer.parseInt(parts[0]),
                        Double.parseDouble(parts[1]),
                        Category.valueOf(parts[2]),
                        LocalDate.parse(parts[3]),
                        parts[4]
                );
                expenses.add(expense);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }

    public void generateMonthlyReport(int year, Month month) {
        Map<Category, Double> report = new HashMap<>();

        for (Expense expense : expenses) {
            if (expense.getDate().getYear() == year && expense.getDate().getMonth() == month) {
                report.put(expense.getCategory(), report.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
            }
        }

        System.out.println("Expense Report for " + month + " " + year + ":");
        for (Map.Entry<Category, Double> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void deleteExpense(int id) {
        boolean removed = expenses.removeIf(expense -> expense.getId() == id);
        if (removed) {
            System.out.println("Expense with ID " + id + " deleted successfully.");
            saveExpensesToFile();
        } else {
            System.out.println("Expense with ID " + id + " not found.");
        }
    }

    public void exportExpensesToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Amount,Category,Date,Description\n");
            for (Expense expense : expenses) {
                writer.append(String.valueOf(expense.getId())).append(",").append(String.valueOf(expense.getAmount())).append(",").append(String.valueOf(expense.getCategory())).append(",").append(String.valueOf(expense.getDate())).append(",").append(expense.getDescription()).append("\n");
            }
            System.out.println("Expenses exported successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("Error exporting to CSV: " + e.getMessage());
        }
    }
}
