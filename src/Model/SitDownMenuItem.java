package Model;

/**
 * Menu Item objects for a sit down restaurant/food Vendor
 * @author ambd1
 */
public class SitDownMenuItem {
    private String name;
    private String description;
    private String timeToPrepare;
    private double price;

    /**
     * Constructor with attributes for sit down menu items
     * @param name String containing name of the menu item
     * @param description String containing a short description of the menu item
     * @param timeToPrepare String containing the approx. time to prepare a menu item
     */
    public SitDownMenuItem(String name, String description, String timeToPrepare, double price){
        this.name = name;
        this.description = description;
        this.timeToPrepare = timeToPrepare;
        this.price = price;
    }

    /**
     * retrieves the name of a SitDownMenuItem object
     * @return a String containing the name of the SitDownMenuItem object
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of a SitDownMenuItem object
     * @param name String containing the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * retrieves the description of a SitDownMenuItem object
     * @return a String containing the description of the SitDownMenuItem object
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description of a SitDownMenuItem object
     * @param description String containing the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * retrieves the approx. time needed to prepare of a SitDownMenuItem object
     * @return a String containing the approx. time needed to prepare of the SitDownMenuItem object
     */
    public String getTimeToPrepare() {
        return timeToPrepare;
    }

    /**
     * sets the approx. time needed to prepare of a SitDownMenuItem object
     * @param timeToPrepare String containing the approx. time needed to prepare of a SitDownMenuItem object to be set
     */
    public void setTimeToPrepare(String timeToPrepare) {
        this.timeToPrepare = timeToPrepare;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Prints the information contained in a sit down menu item object as a string
     * @return this information contained in a sit down menu item as readable text
     */
    @Override
    public String toString() {
        return "SitDownMenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", timeToPrepare='" + timeToPrepare + '\'' +
                ", price=" + price +
                '}';
    }
}
