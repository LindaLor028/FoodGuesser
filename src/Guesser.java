import java.util.*;

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

    public Guesser(ProgramWindow programWindow) {
        this.programWindow = programWindow;
    }

    public void askQuestion(ArrayList<Question> qList) {
        if (questionList.isEmpty()) {
            populateQList();
        }

        ArrayList<Question> potentialQuestions = qList;  // need to intitalize and check if updated
        Question currQObj = potentialQuestions.get(0);  // need to initialize  and check if updated
        currQObj.setAsked(true);

        String currQ = currQObj.getQuestion();
        System.out.println(currQ);  // Asking the question
        System.out.println("Yes or No?");
        
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("yes")) { // string to lowercase 
            // Accessing an invidiual question this way works..
            String[] currQYesArray = currQObj.getYesArray(); 

            // System.out.println("moving forward with query..."); 
            addYesArrayIntoPotentialAnswers(currQYesArray);
            potentialQuestions = findMatchYes(potentialQuestions, currQYesArray);
            
        }
        else if (input.equalsIgnoreCase("no")){ // if user responds no
            // System.out.println("Lame..");

            String[] currQNoArray = currQObj.getNoArray();
            removeValuesFromPotentialAnswers(currQObj.getYesArray());

            // System.out.println("moving forward with query..."); 

            potentialQuestions = findMatchNo(potentialQuestions, currQNoArray);

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
                        // System.out.println("Is it " + potentialAnswers.get(0) + "?");
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

        

        // System.out.println(potentialQuestions.get(0).getQuestion());
        // for (String food: potentialAnswers) {
        //     System.out.println(food);
        // }
    
       // scanner.close();
    }

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
                // System.out.println("Removing " + value + " from potentialAnswers");
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
     *
     */
    public ArrayList<Question> findMatchYes(ArrayList<Question> potentialQuestions, String[] currQYesArray) {
        ArrayList<Question> newPotential = new ArrayList<>();
        for (Question q : potentialQuestions) {
            if (!q.isAsked() && checkContains(currQYesArray, q.getYesArray())) {
                newPotential.add(q);
            }
        }

        return newPotential;
    }

    /**
     *
     */
    public ArrayList<Question> findMatchNo(ArrayList<Question> potentialQuestions, String[] currQNoArray) {
        ArrayList<Question> newPotential = new ArrayList<>();
        for (Question q : potentialQuestions) {
            if (!q.isAsked() && checkContains(currQNoArray, q.getYesArray())) {
                newPotential.add(q);
            }
        }

        return newPotential;
    }

    /**
     * Checks if values in array's noArray exist in compareArray's yesArray
     * AT THIS POINT, WE ASSUME THAT THE USER HAS ANSWERED YES TO THE QUESTION
     * @param {*} array 
     * @param {*} compareArray 
     */
    public boolean checkContains(String[] array, String[] compareArray) {
        for (String currObj : array){
            for (String otherObj : compareArray) {
                // System.out.println("Comparing "+  currObj + " and  " + otherObj);
                if (currObj.equals(otherObj)) {
                    return true;
                }
            }     
        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ProgramWindow programWindow = new ProgramWindow();
        Guesser app = new Guesser(programWindow);
        app.askQuestion(questionList);
    }
}
