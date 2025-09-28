import java.time.LocalDateTime;

/**
 * Represents a stock movement (inbound or outbound) for a drug in the pharmacy.
 * Keeps track of which drug, the movement type, quantity, and the date/time of the movement.
 */
public class StockMovement {

    private Drug drug;                  // The drug involved in this movement
    private MovementType type;          // Type of movement: INBOUND or OUTBOUND
    private int quantity;               // Quantity added or removed
    private LocalDateTime date;         // Timestamp of the movement

    public StockMovement(Drug drug, MovementType type, int quantity) {
        this.drug = drug;
        this.type = type;
        this.quantity = quantity;
        this.date = LocalDateTime.now(); // Record current date and time
    }

    /**
     * Get the movement type.
     *
     * @return INBOUND or OUTBOUND
     */
    public MovementType getType() {
        return type;
    }

    /**
     * Get the date and time when the movement occurred.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Returns a readable string representation of the stock movement.
     */
    @Override
    public String toString() {
        return type + " | " + drug.getName() + " | Qty: " + quantity + " | Date: " + date;
    }
}
