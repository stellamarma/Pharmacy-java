import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
 * Represents a warehouse that manages drugs and categories.
 * Keeps track of drugs, their categories, and stock movements.
 */
public class Warehouse {

    private List<DrugCategory> categories = new ArrayList<>(); // List of all categories in the warehouse
    private List<Drug> drugs = new ArrayList<>();             // List of all drugs in the warehouse

    /**
     * Adds a new category to the warehouse.
     *
     * @param category the DrugCategory to add
     */
    public void addCategory(DrugCategory category) {
        categories.add(category);
    }

    /**
     * Adds a new drug to the warehouse.
     *
     * @param drug the Drug to add
     */
    public void addDrug(Drug drug) {
        drugs.add(drug);
    }

    /**
     * Displays all drugs in the warehouse with their stock and category.
     */
    public void showAllDrugs() {
        System.out.println("All Drugs:");
        for (Drug drug : drugs) {
            System.out.println(drug);
        }
    }

    /**
     * Searches for a drug by its unique ID.
     *
     * @param id the ID of the drug
     * @return the Drug if found, otherwise null
     */
    public Drug getDrugById(int id) {
        for (Drug drug : drugs) {
            if (drug.getId() == id) {
                return drug;
            }
        }
        return null;
    }

    /**
     * Searches for a category by its unique ID.
     *
     * @param id the ID of the category
     * @return the DrugCategory if found, otherwise null
     */
    public DrugCategory getCategoryById(int id) {
        for (DrugCategory category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    /**
     * Displays outbound (removal) stock movements of a specific drug within a date range.
     *
     * @param drug  the drug to check movements for
     * @param start start of the date range
     * @param end   end of the date range
     */
    public void showOutboundMovements(Drug drug, LocalDateTime start, LocalDateTime end) {
        System.out.println("Outbound movements for " + drug.getName() + " from " + start + " to " + end + ":");
        for (StockMovement movement : drug.getMovements()) {
            if (movement.getType() == MovementType.OUTBOUND &&
                    !movement.getDate().isBefore(start) &&
                    !movement.getDate().isAfter(end)) {
                System.out.println(movement);
            }
        }
    }

    /**
     * Displays all categories in the warehouse with their ID and name.
     */
    public void showAllCategories() {
        System.out.println("All Categories:");
        for (DrugCategory category : categories) {
            System.out.println("ID: " + category.getId() + " | Name: " + category.getName());
        }
    }
}
