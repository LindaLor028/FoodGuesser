import edu.macalester.graphics.Image;

/**
 * The Food Class was written by Nina Lin on 4/30/2023 and serves as a way to represent the food
 * in this program.
 */
public class Food {
    String name;
    Image imageObj;

    /**
     * Constructor
     * @param name
     * @param imageObj
     */
    public Food(String name, Image imageObj) {
        this.name = name;
        this.imageObj = imageObj;
    }

    /**
     * This method returns the name of the Food. 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the image object of the Food. 
     * @return
     */
    public Image getImage() {
        return imageObj;
    }

}
