/**
 * The Question class was written by Linda Lor on 4/30/2023. This class serves as a 
 * way to represent questions and store the associated yes and no values with them. 
 */
public class Question {
    private String question;
    private String[] yesArray, noArray;
    private Boolean asked;

    /**
     * Constructor
     * @param question
     * @param yesArray
     * @param noArray
     */
    public Question(String question, String[] yesArray, String[] noArray){
        this.question = question;
        this.yesArray = yesArray;
        this.noArray = noArray;
        asked = false;

    }

    /**
     * This method returns the question of the Question object- represented as a String. 
     * @return
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * This method returns the yesArray of the Question object. Therefore,
     * if a user responds yes to this question, the Strings in the yesArray would contain 
     * all possible things that hold true to the question. 
     * @return
     */
    public String[] getYesArray() {
        return this.yesArray;
    }

    /**
     * This method returns the noArray of the Question object. Therefore,
     * if a user responds yes to this question, the Strings in the noArray would contain 
     * all possible things that hold false to the question. 
     * @return
     */
    public String[] getNoArray() {
        return this.noArray;
    }

    /**
     * This method returns true or false; based on whether the Question has been asked or not.
     * @return
     */
    public Boolean isAsked(){
        return asked;
    }

    /**
     * This is a setter method where you can set the question's asked status to true or false. 
     * @param value
     */
    public void setAsked(Boolean value) {
        this.asked = value;
    }
    
}
