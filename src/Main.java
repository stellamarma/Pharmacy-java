import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Main class for the Pharmacy System.
 * Provides a console-based menu for managing categories, drugs, stock, and movements.
 */
public class Main {

    /**
     * Main method to run the Pharmacy System.
     * Initializes warehouse, predefined categories and drugs, and handles user interaction.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse(); // Create warehouse to store drugs and categories

        // Predefined categories
        DrugCategory antibiotics = new DrugCategory(1, "Antibiotics", "Antibacterial drugs");
        DrugCategory painkillers = new DrugCategory(2, "Painkillers", "Pain relief drugs");
        warehouse.addCategory(antibiotics);
        warehouse.addCategory(painkillers);

        // Predefined drugs
        Drug amoxicillin = new Drug(1, "Amoxicillin", 10.0, 50, antibiotics);
        Drug paracetamol = new Drug(2, "Paracetamol", 5.0, 100, painkillers);
        warehouse.addDrug(amoxicillin);
        warehouse.addDrug(paracetamol);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Pharmacy System");

        // Main loop for user menu
        while (running) {
            System.out.println("\n=========================");
            System.out.println("1. Add category");
            System.out.println("2. Add drug");
            System.out.println("3. Show all drugs");
            System.out.println("4. Increase stock");
            System.out.println("5. Decrease stock");
            System.out.println("6. Show outbound movements");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1: // Add a new category
                    System.out.print("Category ID: ");
                    int catId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Category name: ");
                    String catName = scanner.nextLine();
                    System.out.print("Description: ");
                    String catDesc = scanner.nextLine();
                    warehouse.addCategory(new DrugCategory(catId, catName, catDesc));
                    System.out.println("Category added!");
                    break;

                case 2: // Add a new drug
                    warehouse.showAllCategories(); // Display categories to select from
                    System.out.print("Choose Category ID for the new drug: ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine();

                    DrugCategory category = warehouse.getCategoryById(categoryId);
                    if (category == null) {
                        System.out.println("Category not found! Create the category first.");
                        break;
                    }

                    System.out.print("Drug ID: ");
                    int drugId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Drug name: ");
                    String drugName = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    warehouse.addDrug(new Drug(drugId, drugName, price, qty, category));
                    System.out.println("Drug added!");
                    break;

                case 3: // Show all drugs
                    warehouse.showAllDrugs();
                    break;

                case 4: // Increase stock of a drug
                    warehouse.showAllDrugs(); // Show drugs to select ID
                    System.out.print("Drug ID to increase stock: ");
                    int incId = scanner.nextInt();
                    System.out.print("Quantity: ");
                    int incQty = scanner.nextInt();
                    Drug incDrug = warehouse.getDrugById(incId);
                    if (incDrug != null) {
                        incDrug.increaseStock(incQty);
                        System.out.println("Stock increased!");
                    } else {
                        System.out.println("Drug not found!");
                    }
                    break;

                case 5: // Decrease stock of a drug
                    warehouse.showAllDrugs(); // Show drugs to select ID
                    System.out.print("Drug ID to decrease stock: ");
                    int decId = scanner.nextInt();
                    System.out.print("Quantity: ");
                    int decQty = scanner.nextInt();
                    Drug decDrug = warehouse.getDrugById(decId);
                    if (decDrug != null) {
                        decDrug.decreaseStock(decQty);
                        System.out.println("Stock decreased!");
                    } else {
                        System.out.println("Drug not found!");
                    }
                    break;

                case 6: // Show outbound movements of a drug
                    warehouse.showAllDrugs(); // Show drugs to select ID
                    System.out.print("Drug ID to show outbound movements: ");
                    int outId = scanner.nextInt();
                    Drug outDrug = warehouse.getDrugById(outId);
                    if (outDrug != null) {
                        LocalDateTime start = LocalDateTime.now().minusDays(1);
                        LocalDateTime end = LocalDateTime.now().plusDays(1);
                        warehouse.showOutboundMovements(outDrug, start, end);
                    } else {
                        System.out.println("Drug not found!");
                    }
                    break;

                case 7: // Exit program
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default: // Invalid input
                    System.out.println("Invalid option!");
            }
        }

        scanner.close(); // Close scanner to prevent resource leak
    }
}
