public class Question {
    private String question;
    private String[] yesArray, noArray;
    private Boolean asked;

    public Question(String question, String[] yesArray, String[] noArray){
        this.question = question;
        this.yesArray = yesArray;
        this.noArray = noArray;
        asked = false;

    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getYesArray() {
        return this.yesArray;
    }

    public String[] getNoArray() {
        return this.noArray;
    }

    public Boolean isAsked(){
        return asked;
    }

    public void setAsked(Boolean value) {
        this.asked = value;
    }
    
}
