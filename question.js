class Question {

    asked = false;

    /**
     * ================== 
     * @param {*} param0 
     */
    constructor({question, yesArray, noArray}) {
        this.question = question; 
        this.yesArray = yesArray;
        this.noArray = noArray;

    }

    getQuestion() {
        return this.question;
    }

    /**
     * ==================
     * @returns 
     */
    getYesArray() {
        return this.yesArray;
    }

    /**
     * ==================
     * @returns 
     */
    getNoArray() {
        return this.noArray;
    }

    /**
     * 
     * @param {*} value 
     */
    contains(value){
        return this.yesArray.contains(value);
    }
}