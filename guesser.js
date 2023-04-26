// initialize questions 
var beverageQ = new Question({question : "Is the food a beverage?",
                  yesArray : ["Boba", "Smoothie"],
                  noArray : ["Spaghetti", "Hot Dog", "Pizza", "Chilli", "Icecream", "Chips"]});  

var dessertQ = new Question({question : "Is the food a dessert?",
                  yesArray : ["Boba", "Smoothie", "Icecream"],
                  noArray : ["Spaghetti", "Hot Dog", "Pizza", "Chilli", "Chips"]});  

var soupQ = new Question({question : "Is the food a soup?",
                  yesArray : ["Chilli"],
                  noArray : ["Spaghetti", "Hot Dog", "Pizza", "Icecream", "Chips", "Boba", "Smoothie"]});  
//////

function askQuestion(){
    answer = "";
    // userResponse = document.getElementById("etOpening").value;
    // console.log(beverageQ.getQuestion()); 
    const input = prompt(beverageQ.getQuestion());

    if (input.toLowerCase() == "yes") { // string to lowercase 
        const array = beverageQ.getYesArray();

        console.log("moving forward with query..."); 
        if (checkContains(array, soupQ.getYesArray())) {
            console.log("Contains!");
        }
        else {
            // throw out soupQ of the validQ array
            // then ask next thing in the validQ array
        }
        
    }
    else if (input.toLowerCase() == "no"){
        console.log("Lame..");

        // if user responds no
        // check the currentQ.getNoArray()
        // compare it to a otherQ.getYesArray() 
        // if a food in currentQ.getNoArray() is in otherQ.getYesArray().. then we WANT to asked otherQ (KEEP QUESTION)

    }

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
                  