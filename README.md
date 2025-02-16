Java Expense Tracker
  A console-based Java application that allows users to manage daily expenses, set budget limits, and generate reports using Object-Oriented Programming (OOP)       principles and design patterns. This project demonstrates file handling, CSV exports, and Singleton Pattern implementation.

Features:

  ✅ Add Expenses – Users can add expenses with amount, category, date, and description.
  
  ✅ View All Expenses – Displays all recorded expenses in a structured format.
  
  ✅ Set Budget Limit – Allows users to define a monthly budget and warns when exceeded.
  
  ✅ Filter by Category – View expenses by specific categories like Food, Transport, Bills, etc.
  
  ✅ Delete Expenses – Remove an expense by ID.
  
  ✅ Export to CSV – Generates a CSV file of all expenses for easy tracking.
  
  ✅ Data Persistence – Stores expenses in a file and loads them automatically on startup.
  
  ✅ Singleton Pattern – Used in ExpenseManager to ensure only one instance manages expenses.


Technologies Used:

  Java (JDK 17+)
  
  Collections Framework (ArrayList)
  
  File Handling (java.io)
  
  Date and Time API (java.time)
  
  Git & GitHub for version control


Project Structure:

  src/
  
  │── Main.java            # Entry point of the application
  
  │── Expense.java         # Expense class with attributes like amount, category, and date
  
  │── Category.java        # Enum to define expense categories
  
  │── ExpenseManager.java  # Singleton class that manages all expenses
  
  │── expenses.txt         # Stores all expenses persistently (generated during runtime)


Installation & Running the Project:

  1. Clone the Repository
  git clone https://github.com/yourusername/Java-Expense-Tracker.git
  cd Java-Expense-Tracker
  
  2. Compile & Run
  javac src/*.java
  java src.Main

How to Use
  Main Menu Options:
  Expense Tracker Menu:
  1. Add Expense
  2. View total expenses
  3. View All Expenses with all information
  4. Set Budget Limit
  5. Generate Monthly Report
  6. Delete a expense
  7. View Expenses by Category
  8. Export Expenses to CSV
  9. Exit


Example Commands:

  Enter 1 → Add an expense
  
  Enter 5 → Delete an expense by ID
  
  Enter 6 → Export expenses to expenses.csv
  
  Example CSV Output:
  
  ID,Amount,Category,Date,Description
  
  1,250.00,FOOD,2025-02-16,Lunch at restaurant
  
  2,1500.00,TRANSPORT,2025-02-17,Flight tickets
  
  3,500.00,SHOPPING,2025-02-18,New shoes

Design Pattern Used:
  Singleton Pattern in ExpenseManager.
  
  Ensures only one instance of ExpenseManager exists.
  
  Prevents accidental multiple instances managing expenses.


Future Enhancements (To-Do):
  
  📌 Add Database Support (MySQL/SQLite) instead of file storage.
  
  📌 Implement Graphical UI (JavaFX or Swing) for better UX.
  
  📌 Add Sorting & Filtering options for expenses.



