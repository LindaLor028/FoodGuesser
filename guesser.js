
//////

function askQuestion(){
    answer = "";
    // userResponse = document.getElementById("etOpening").value;
    // console.log(beverageQ.getQuestion()); 
    // const input = prompt(beverageQ.getQuestion());

    // 1. randomly choose a question from question array
    currQObj = questions.beverageQ;

    // 2. prompt the question
    currQ = currQObj.question;
    const input = prompt(currQ);

    // 3. check answers with other questions
    if (input.toLowerCase() == "yes") { // string to lowercase 
        const array = questions.beverageQ.yesArray;

        console.log("moving forward with query..."); 
        if (checkContains(array, questions.soupQ.yesArray)) {
            console.log("Contains!");
        }
        else {
            // throw out soupQ of the validQ array
            // then ask next thing in the validQ array
        }
        
    }
    else if (input.toLowerCase() == "no"){ // if user responds no
        console.log("Lame..");


        const array = questions.beverageQ.noArray;
        
        // check the currentQ.getNoArray()
        // compare it to a otherQ.getYesArray() 
        // if a food in currentQ.getNoArray() is in otherQ.getYesArray().. then we WANT to asked otherQ (KEEP QUESTION)

    }

}

/**
 *
 */
 function findMatch(potentialQuestions) {
    newPotential = {};

    for (i = 0; i < potentialQuestions; i++){
        for (j = 0; j < compareArray.length; j++) {
            console.log("Comparing "+  array[i] + " and  " + compareArray[j]);
            if (array[i] ===  compareArray[j]) {
                return true;
            }
        }
    }
    return false;
}

/**
 * Checks if values in array's noArray exist in compareArray's yesArray
 * AT THIS POINT, WE ASSUME THAT THE USER HAS ANSWERED YES TO THE QUESTION
 * @param {*} array 
 * @param {*} compareArray 
 */
function checkContains(array, compareArray) {
    for (i = 0; i < array.length; i++){
        for (j = 0; j < compareArray.length; j++) {
            console.log("Comparing "+  array[i] + " and  " + compareArray[j]);
            if (array[i] ===  compareArray[j]) {
                return true;
            }
        }
    }
    return false;
}
                  