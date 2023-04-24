// initialize questions 
var beverageQ = new Question({question : "Is the food a beverage?",
                  yesArray : ["Boba", "Smoothie"],
                  noArray : ["Spaghetti", "Hot Dog", "Pizza", "Chilli", "Icecream", "Chips"]});  

var dessertQ = new Question({question : "Is the food a dessert?",
                  yesArray : ["Boba", "Smoothie", "Icecream"],
                  noArray : ["Spaghetti", "Hot Dog", "Pizza", "Chilli", "Chips"]});  

var soupQ = new Question({question : "Is the food a soup?",
                  yesArray : ["Chilli"],
                  noArray : ["Spaghetti", "Hot Dog", "Pizza", "Chilli", "Icecream", "Chips", "Boba", "Smoothie"]});  
//////

function askQuestion(){
    answer = "";
    userResponse = document.getElementById("etOpening").value;
    // console.log(beverageQ.getQuestion()); 
    const input = prompt(beverageQ.getQuestion());

    if (input == "Yes" || input == "yes") {
        const array = beverageQ.getYesArray();

        console.log("moving forward with query..."); 
        if (checkContains(dessertQ.getNoArray())) {
            console.log("Contains!");
        }
        
    }
    else {
        console.log("Lame..");
    }

}

/**
 * Checks if values in array's noArray exist in compareArray's yesArray
 * AT THIS POINT, WE ASSUME THAT THE USER HAS ANSWERED YES TO THE QUESTION
 * @param {*} array 
 * @param {*} compareArray 
 */
function checkContains(array, compareArray) {
    for (item in array) {
        for (comparer in compareArray) {
            if (item == comparer){
                return false;
            }
        }
    }
    return true;
}
                  