/**
 * Represents the type of a stock movement for a drug.
 *
 * INBOUND  -> stock is added to the warehouse (e.g., new delivery)
 * OUTBOUND -> stock is removed from the warehouse (e.g., sale or dispatch)
 */
public enum MovementType {
    INBOUND,
    OUTBOUND
}
