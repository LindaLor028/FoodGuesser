import java.util.*;

/**
 * The Guesser Class was written by Linda Lor and Nina Lin on 4/30/2023. This class is considered the "main" of this program,
 * and can demonstrate the code in work on the main.
 */
public class Guesser {
    private Question beverageQ = new Question("Is the food a beverage?", new String[]{"Milk Tea", "Orange Juice", "Soda"}, new String[]{"Cake", "Ice Cream", "Macaron", "Chilli", "Chowder", "Wild Rice Soup"});
    private Question dessertQ = new Question("Is the food a dessert?", new String[]{"Cake", "Ice Cream", "Macaron"}, new String[]{"Milk Tea", "Orange Juice", "Soda", "Chilli", "Chowder", "Wild Rice Soup"});
    private Question bakedQ = new Question("Does this food need to be baked?", new String[]{"Cake", "Macaron"}, new String[]{"Ice Cream", "Milk Tea", "Orange Juice", "Soda", "Chilli", "Chowder", "Wild Rice Soup"});
    private Question soupQ = new Question("Is the food a soup?", new String[]{"Chilli", "Chowder", "Wild Rice Soup"}, new String[]{"Milk Tea", "Orange Juice", "Soda", "Cake", "Ice Cream", "Macaron"});
    private Question sweetQ = new Question("Is the food sweet?", new String[]{"Milk Tea", "Cake", "Ice Cream", "Macaron"}, new String[]{"Orange Juice", "Soda", "Chilli", "Chowder", "Wild Rice Soup"});
    private Question carbonQ = new Question("Is this food carbonated?", new String[]{"Soda"}, new String[]{"Milk Tea", "Orange Juice", "Cake", "Ice Cream", "Macaron", "Chilli", "Chowder", "Wild Rice Soup"});
    private Question taiwanQ  = new Question("Does this food originate from Taiwan?", new String[] {"Milk Tea"}, new String[] {"Cake", "Ice Cream", "Macaron", "Chilli", "Chowder", "Wild Rice Soup", "Orange Juice", "Soda"});
    private Question sandwichQ = new Question("Does this food come in the shape of a sandwich?", new String[] {"Macaron"}, new String[] {"Cake", "Ice Cream", "Milk Tea", "Chilli", "Chowder", "Wild Rice Soup", "Orange Juice", "Soda"});
    private Question riceQ = new Question("Does this food have rice in it?", new String[]{"Wild Rice Soup"}, new String[]{"Milk Tea", "Orange Juice", "Soda", "Cake", "Ice Cream", "Macaron", "Chilli", "Chowder"});
    private Question vitcQ = new Question("Is this food high in Vitamin C?", new String[]{"Orange Juice"}, new String[]{"Milk Tea", "Wild Rice Soup", "Soda", "Cake", "Ice Cream", "Macaron", "Chilli", "Chowder"});

    public static ArrayList<Question> questionList =  new ArrayList<>();
    public ArrayList<String> potentialAnswers = new ArrayList<>();
    private int eliminated = 0;

    public Scanner scanner = new Scanner(System.in);

    public ProgramWindow programWindow;


    /**
     * Constructor
     * @param programWindow
     */
    public Guesser(ProgramWindow programWindow) {
        this.programWindow = programWindow;
    }

    /**
     * The populateQList method populates the questionList list. 
     */
    private void populateQList() {
        questionList.add(beverageQ);
        questionList.add(dessertQ);
        questionList.add(soupQ);
        questionList.add(bakedQ);
        questionList.add(taiwanQ);
        questionList.add(vitcQ);
        questionList.add(riceQ);
        questionList.add(sweetQ);
        questionList.add(carbonQ);
        questionList.add(sandwichQ);
    }

    /**
     * The guessPot(ential)Answer method guesses all potential answers in the potentialAnswers
     * array if there exists at least two possible answers in this array. 
     * @param potentialAnswers
     */
    private void guessPotAnswer(ArrayList<String> potentialAnswers) {
        Boolean foundAnswer = false;

        for (String answer : potentialAnswers) {
            System.out.println("Is it " + answer + "?");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                System.out.println("YAY!!");
                foundAnswer = true;
                break;
            }
        }

        if (!foundAnswer) {
            System.out.println("BUMMER...");
        }
    }

    /**
     * The removeValuesFromPotentialAnswers method removes values from the potentialAnswers array. 
     * It also calls the programWindow object's scribble method which scribbles over an image to indicate
     * to the user our algorithm. 
     * @param noArray
     */
    private void removeValuesFromPotentialAnswers(String[] noArray) {
        for (String value : noArray) {
            for (Food food : programWindow.getFoodArray()) {
                if (value.equals(food.getName())) {
                    programWindow.scribble(food.getImage().getX(), food.getImage().getY());
                    eliminated ++;
                }
            }
            if (potentialAnswers.contains(value)) {
                potentialAnswers.remove(value);
            }
        }
    }

    private void addYesArrayIntoPotentialAnswers(String[] yesArray) {
        for (String value : yesArray) {
            if (!potentialAnswers.contains(value)){
                potentialAnswers.add(value);
                System.out.println("Adding " + value + " into potentialAnswers");
            }
        }
    }

    /**
     * The findMatchNo method populates the potentialQuestions based on the currQNoArray and the question's YesArray.
     * @param potentialQuestions
     * @param currQNoArray
     * @return
     */
    public ArrayList<Question> findMatch(ArrayList<Question> potentialQuestions, String[] currQNoArray) {
        ArrayList<Question> newPotential = new ArrayList<>();
        for (Question q : potentialQuestions) {
            if (!q.isAsked() && checkContains(currQNoArray, q.getYesArray())) {
                newPotential.add(q);
            }
        }
        return newPotential;
    }

    /**
     * The checkContains method compares two arrays. If there exists at least one value in array that exists in compareArray, 
     * the method returns true. 
     * @param array
     * @param compareArray
     * @return
     */
    public boolean checkContains(String[] array, String[] compareArray) {
        for (String currObj : array){
            for (String otherObj : compareArray) {
                if (currObj.equals(otherObj)) {
                    return true;
                }
            }     
        }
        return false;
    }

     /**
     * The askQuestion method is the core of the Guesser Class and works recursively- continuously calling askQuestion until
     * it narrows down potential answers.
     * @param qList
     */
    public void askQuestion(ArrayList<Question> qList) {
        if (questionList.isEmpty()) {
            populateQList();
        }

        ArrayList<Question> potentialQuestions = qList;
        Question currQObj = potentialQuestions.get(0);
        currQObj.setAsked(true);

        String currQ = currQObj.getQuestion();
        System.out.println(currQ);
        System.out.println("Yes or No?");
        
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("yes")) { 
            String[] currQYesArray = currQObj.getYesArray(); 
            addYesArrayIntoPotentialAnswers(currQYesArray);
            potentialQuestions = findMatch(potentialQuestions, currQYesArray);
            
        }
        else if (input.equalsIgnoreCase("no")){
            String[] currQNoArray = currQObj.getNoArray();
            removeValuesFromPotentialAnswers(currQObj.getYesArray());
            potentialQuestions = findMatch(potentialQuestions, currQNoArray);

        }
        else {
            System.out.println("Please respond Yes or No.");
            askQuestion(potentialQuestions);
        }

        if (eliminated > 7) {
            System.out.println("Hmm.. I'm not sure what food you picked.");
        }
        else {
            if (potentialAnswers.size() == 1) {
                System.out.println("Is it " + potentialAnswers.get(0) + "?");
                input = scanner.nextLine();
    
                if (input.equalsIgnoreCase("yes")) {
                    System.out.println("YAY!!!!");
                }
                else if (input.equalsIgnoreCase("no")) {
                    System.out.println("BUMMER...");
                }
                else {
                    System.out.println("YOU BROKE IT >:( ");
                }
            }
            else {
                if (potentialQuestions.size() == 0) {
                    if (potentialAnswers.size() > 1) {
                        guessPotAnswer(potentialAnswers);
                    }
                    else {
                        System.out.println("No answers found :( ");
                    }
                }
                else {
                    askQuestion(potentialQuestions);
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ProgramWindow programWindow = new ProgramWindow();
        Guesser app = new Guesser(programWindow);
        app.askQuestion(questionList);
    }
}
