import java.util.ArrayList;
import java.util.List;

/**
 * Represents a drug in the pharmacy system.
 * Keeps track of its stock, category, price, and stock movements.
 */
public class Drug {

    private int id;                          // Unique identifier for the drug
    private String name;                     // Name of the drug
    private double price;                    // Price per unit
    private int stock;                       // Current stock quantity
    private DrugCategory category;           // Category to which the drug belongs
    private List<StockMovement> movements = new ArrayList<>(); // List of stock movements (inbound/outbound)

    public Drug(int id, String name, double price, int stock, DrugCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;

        // Automatically add this drug to the category's drug list
        category.addDrug(this);
    }

    /**
     * Get the unique ID of the drug.
     */
    public int getId() {
        return id;
    }

    /**
     * Increase the stock by a specified quantity.
     * Records this as an INBOUND stock movement.
     *
     * @param qty Quantity to add
     */
    public void increaseStock(int qty) {
        stock += qty;
        movements.add(new StockMovement(this, MovementType.INBOUND, qty));
    }

    /**
     * Decrease the stock by a specified quantity.
     * If there is insufficient stock, prints a warning.
     * Records this as an OUTBOUND stock movement.
     *
     * @param qty Quantity to remove
     */
    public void decreaseStock(int qty) {
        if(qty > stock) {
            System.out.println("Ανεπαρκές απόθεμα!"); // Warning: insufficient stock
            return;
        }
        stock -= qty;
        movements.add(new StockMovement(this, MovementType.OUTBOUND, qty));
    }

    /**
     * Returns the list of all stock movements for this drug.

     */
    public List<StockMovement> getMovements() {
        return movements;
    }

    /**
     * Get the name of the drug.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the current stock quantity.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Get the category of the drug.
     */
    public DrugCategory getCategory() {
        return category;
    }

    /**
     * Returns a readable string representation of the drug,
     * including name, stock quantity, and category name.
     *
     * @return string representation of the drug
     */
    @Override
    public String toString() {
        return name + " | Stock: " + stock + " | Category: " + category.getName();
    }
}
