# Food Guesser

Welcome!

FoodGuesser is a game that models the popular Akinator but with a twist on food. The player is asked a series of questions and the program returns an educated guess of what the program thinks the food item in question is.

**How To Run Food Guesser**
To run Food Guesser, you can clone this repository onto your device. You can then run the main method in Guesser.java (line 226). Food Guesser relies on Macalester College's Graphics Library for the ProgramWindow class, but the library should be implmented already. 

**The Food Guesser Algorithm**


**Future Development Notes**
In Food Guesser's Algorithm, the main focus is to implement an algorithm that efficiently eliminates options for a possible guess until it can guess the most accurate response. Due to time limitations, our program has the following constraints:
* Guesses are limited to 9 options 
* Questions are limited and need to have a pre-defined yesArray and noArray 
* Algorithm may ask irrelevant questions

In the event that there is more time to improve the Food Guesser's Algorithm, we would like to see the following changes: 
* SORTING GUESSES BY FREQUENCY: The possible guesses should be stored in a HashMap or something that can sort the number of times that the possible guesses appear in the question's yesArray. 
* MORE GUESSES AND QUESTIONS: There should be more guesses and questions- this would actually help us determine if our program is efficient (run-time).
* CHANGE OF DATA STRUCTURES: Some data structures (e.g. yesArray and noArrays are String[]) give us limitations that may slow our program down. We would encourage using a different data structure that may be faster to iterate through or run the contains() method.

**Credits & Acknowledgements**
Credits for the Food Guesser Program are provided in the class documentation, but we would like to explicitly credit those in our ReadME as well. Below lists those who we would like to credit for their contributions to the project:
* Food.java (Nina Lin)
* Question.java (Linda Lor)
* Guesser.java (Nina Lin and Linda Lor)
* ProgramWindow.java (Nina Lin and Linda Lor)
* Graphics and UI Design (Linda Lor)
* Food Guesser Algorithm - main designer (Nina Lin) 

We would like to thank our COMP 221 Professor, Lian Duan, for providing support through the creation of the project. Additionally, we appreciate the content she has taught us over the course of the semester regarding algorithms, as this gave inspiration and life to this project. 
