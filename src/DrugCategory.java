import java.util.ArrayList;
import java.util.List;

/**
 * Represents a category of drugs in the pharmacy system.
 * Each category has a unique ID, name, description, and a list of drugs belonging to it.
 */
public class DrugCategory {

    private int id;                // Unique identifier for the category
    private String name;           // Name of the category (e.g., Antibiotics)
    private String description;    // Description of the category
    private List<Drug> drugs = new ArrayList<>(); // List of drugs in this category

    public DrugCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Adds a drug to this category's drug list.
     */
    public void addDrug(Drug drug) {
        drugs.add(drug);
    }

    /**
     * Removes a drug from this category's drug list.

     */
    public void removeDrug(Drug drug) {
        drugs.remove(drug);
    }

    /**
     * Returns the list of drugs in this category.
     */
    public List<Drug> getDrugs() {
        return drugs;
    }

    /**
     * Returns the name of the category.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the unique ID of the category.
     */
    public int getId() {
        return id;
    }
}
