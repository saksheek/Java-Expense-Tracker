import java.time.LocalDate;

public class Expense {
    private final int id;
    private final double amount;
    private final Category category;
    private final LocalDate date;
    private final String description;

    public Expense(int id, double amount, Category category, LocalDate date, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Expense{id=" + id + ", amount=" + amount + ", category=" + category + ", date=" + date + ", description='" + description + "'}";
    }
}
