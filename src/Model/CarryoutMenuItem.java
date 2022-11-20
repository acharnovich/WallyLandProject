package Model;

/**
 * Menu Item Objects available for carryout food vendors
 * @author ambd1
 */
public class CarryoutMenuItem {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;

    /**
     * Creates a new carryout menu item
     * @param name String containing the name of the menu item
     * @param description String containing a description of the menu item
     * @param price double containing the price of the menu item
     * @param quantity integer that holds the quantity available of a menu item
     */
    public CarryoutMenuItem(String name, String description, Double price, Integer quantity){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * retrieves the name of a carryout menu item
     * @return a String containing the name of a carryout menu item object
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of a carryout menu item
     * @param name String containing the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * retrieves the description of a carryout menu item
     * @return a String containing the description of a carryout menu item object
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description of a carryout menu item
     * @param description String containing the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * retrieves the price per item of a carryout menu item
     * @return a double containing the price of a carryout menu item object
     */
    public Double getPrice() {
        return price;
    }

    /**
     * sets the price per item of a carryout menu item
     * @param price Double containing the price to be set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * retrieves the quantity in stock of a carryout menu item
     * @return an integer containing the quantity of a carryout menu item object
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * sets the quantity available of a carryout menu item
     * @param quantity Integer containing the quantity available to be set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Prints the information contained in a carryout menu item object as a string
     * @return this information contained in a carryout menu item as readable text
     */
    @Override
    public String toString() {
        return "CarryoutMenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
