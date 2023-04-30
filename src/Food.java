import edu.macalester.graphics.Image;

public class Food {
    String name;
    Image imageObj;

    public Food(String name, Image imageObj) {
        this.name = name;
        this.imageObj = imageObj;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return imageObj;
    }

}
