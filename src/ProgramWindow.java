import java.util.ArrayList;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;


/**
 * The ProgramWindow class is written by Linda Lor and Nina Lin on 4/30/2023. This class represents the graphics window of our program. 
 * It relies on Macalester College's Graphics Library to perform. 
 */
public class ProgramWindow {
    
    private CanvasWindow canvas;

    public final static int DEFAULT_WIDTH = 400;
    public final static int DEFAULT_HEIGHT = 500;
    private ArrayList<Image> images = new ArrayList<Image>();

    private String[] imgPaths = {"milktea.png", "orangejuice.png", "soda.png", "cake.png", "icecream.png", "macaron.png", "chilli.png", "chowder.png", "wildricesoup.png" };
    private String[] foodNames = {"Milk Tea", "Orange Juice", "Soda", "Cake", "Ice Cream", "Macaron", "Chilli", "Chowder", "Wild Rice Soup"};
    private ArrayList<Food> foods = new ArrayList<Food>();

    /**
     * Constructor
     */
    public ProgramWindow() {
        canvas = new CanvasWindow("ProgramWindow", DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setUpUI();
        canvas.draw();
    }

    /**
     * This method sets up the basic UI of the window. 
     */
    private void setUpUI() {
        Image title = new Image("gametitle.png");
        title.setCenter(380, 80);
        title.setMaxHeight(50);
        canvas.add(title);

        Image instructions = new Image("instructions.png");
        instructions.setCenter(380, 130);
        instructions.setMaxHeight(30.0);
        canvas.add(instructions);

        for (int i = 0; i < 3; i ++) {
            Image image = new Image(imgPaths[i]);
            foods.add(new Food(foodNames[i], image));
            canvas.add(image);
            image.setPosition(40+ i*110, 150);
            image.setMaxHeight(100.0);
            images.add(image);
        }
        for (int i = 3; i < 6; i ++) {
            Image image = new Image(imgPaths[i]);
            foods.add(new Food(foodNames[i], image));
            canvas.add(image);
            int originalX = i - 3;
            image.setPosition(40 + originalX*110, 260);
            image.setMaxHeight(100.0);
            images.add(image);
        }
        for (int i = 6; i < 9; i ++) {
            Image image = new Image(imgPaths[i]);
            foods.add(new Food(foodNames[i], image));
            canvas.add(image);
            int originalX = i - 6;
            image.setPosition(40 + originalX*110, 370);
            image.setMaxHeight(100.0);
            images.add(image);
        }
    }

    /**
     * This method returns the foods array that is associated in this class. 
     * @return
     */
    public ArrayList<Food> getFoodArray() {
        return foods;
    }

    /**
     * This method "scribbles" on the canvas based on the x and y coordinates that are 
     * pushed in the parameter. 
     * @param x
     * @param y
     */
    public void scribble(double x, double y) {
        Image image = new Image("scribble.png");
        canvas.add(image);
        image.setPosition(x, y);
        image.setMaxHeight(100.0);
        canvas.draw();
    }
    
}
