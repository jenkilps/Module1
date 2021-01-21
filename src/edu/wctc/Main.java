package edu.wctc;

import java.util.Scanner;

/*
Method: Main
args: input, score, answer[8],
Description: This method asks a series of preferences for the user to provide their opinion to determine a score. This score will be out into another method to evaluate their personality type.

 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //introduction
        //question bank in an array
        String[] questions = {"Welcome to the Preference Quiz!", "********************************", "Do you prefer mild or spicy?", "Do you prefer tea or coffee?", "Do you prefer breakfast or brunch?", "Do you prefer summer or winter?", "Do you prefer paper or plastic?", "Again? Enter 1 to play again, or any other key to exit."};
        int score = 0; //number keeping track of the users input
        int[] answer = new int[8]; // a array to hold the answers to the personality questions

        //loop to go through questions
        for (int x = 0; x <= questions.length - 1; x++) {
            if (x == 7) { // if this is the question asking to play again move into the result method
                Main.result(score);
            }

            System.out.println(questions[x]);

            if (x > 1) { //if not title or * line
                if (x != 7) { // and not the question asking to play again, then begin asking preferences
                    System.out.println("Enter 0 for the preference on the left");
                    System.out.println("Enter 1 for the preference on the right");
                }
                answer[x] = input.nextInt();

                if (x == 7) { //if the question asking to play again
                    if (answer[7] == 1) { // user says they want to play again, reset all arguments, and go back to beginning of the for loop
                        x = -1;
                        score = 0;
                        answer = new int[8];
                    } else if (answer[7] != 1) { // if user does not want to play again, end program
                        break;
                    }
                } else if (answer[x] == 1) { // add to the score if preference on right
                    score += 1;
                } else if (answer[x] == 0) { // no change to the score if preference on left
                    score += 0;
                } else if (answer[x] != 1 && answer[x] != 0) { // if user puts in any other value than directed, give them warning
                    System.out.println("INCORRECT VALUE");

                }

            }
        }
    }

    /*
    Method: result
    args: score
    Description: This Method takes in the score from the main method and determines the personality type of the user.
    */
    public static void result(int score) {
        if (score < 3) {
            System.out.println("Your Score: " + score);
            System.out.println("You prefer life to be calm and organized");
        } else if (score == 3) {
            System.out.println("Your Score: " + score);
            System.out.println("You prefer life to be spontaneous and active");
        } else {
            System.out.println("Your Score: " + score);
            System.out.println("You prefer a good balance in life");
        }
    }
}
