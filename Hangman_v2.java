import java.util.Scanner;

public class Hangman_v2 {

	public static void main(String[] args) {
		int easyLives = 11, mediumLives = 7, hardLives = 5;
		int currentDifficulty;
		
		int numWrongGuesses;
		String wrongLetters;
		String correctLetters;
		int numCorrectChars;
		
		int feedback;
		
		String word;
		char letter = ' ';
		Scanner input = new Scanner(System.in);

		// Initialize variables
		numWrongGuesses = 0;
		wrongLetters = "";
		correctLetters = "";
		numCorrectChars = 0;
		currentDifficulty = hardLives; // todo: replace with code to determine whether it is hard, medium, or easy
		word = "giraffe"; // todo: replace with code that randomizes it based on difficulty
		
		System.out.println("FOR TESTING PURPOSES - The word is: " + word);
		System.out.println("Difficulty level: " + currentDifficulty);
		UpdateStatus(word, letter);
		
		// Loop while there are still lives left and the word is not guessed yet
		while (numWrongGuesses < currentDifficulty && numCorrectChars < word.length()) {
			letter = PlayerInput(input); // Get input
			feedback = checkLetter(word, wrongLetters, correctLetters, letter); // Determine if letter is in word
			
			switch (feedback) { 
				case 0: { // Letter is not in the word
					drawBodyPart(numWrongGuesses, currentDifficulty, easyLives, mediumLives, hardLives);
					wrongLetters += letter;
					numWrongGuesses++;
					break;
				} case 1: { // Letter is in the word
					correctLetters += letter;
					numCorrectChars += UpdateStatus(word, letter);
					break;
				} case 2: { // Letter has already been used
					System.out.println("Already guessed \"" + letter + "\".");
					break;
				} default: {
					break;
				}
			}
		}
		
		// Results
		System.out.println();
		if (numWrongGuesses == currentDifficulty) { // Ran out of lives
			System.out.println("No more tries!");
		} else {
			System.out.println("You guessed all the letters!");
		}
		
		// Debug: print everything
		System.out.println("Word: " + word);
		System.out.println("Wrong Letters: " + wrongLetters);
		System.out.println("Correct Letters: " + correctLetters);
		System.out.println("Letters/Word: " + numCorrectChars + "/" + word.length());
		input.close();
	}
	
	// Draws a body part depending on difficulty.
	private static void drawBodyPart(int numWrongGuesses, int currentDifficulty, int easy, int medium, int hard) {
		numWrongGuesses++;
		System.out.println("Wrong guess!");
		
		if (currentDifficulty == easy) { // 11: Head, face, l.ear, r.ear, torso, l.arm, r.arm, l.hand, r.hand l.leg, r.leg
			switch (numWrongGuesses) {
				case 1: {
					System.out.println("Draw the head.");
					break;
				} case 2: {
					System.out.println("Draw the face.");
					break;
				} case 3: {
					System.out.println("Draw left ear.");
					break;
				} case 4: {
					System.out.println("Draw right ear.");
					break;
				} case 5: {
					System.out.println("Draw the torso.");
					break;
				} case 6: {
					System.out.println("Draw left arm.");
					break;
				} case 7: {
					System.out.println("Draw right arm.");
					break;
				} case 8: {
					System.out.println("Draw left hand.");
					break;
				} case 9: {
					System.out.println("Draw right hand.");
					break;
				} case 10: {
					System.out.println("Draw left leg.");
					break;
				} case 11: {
					System.out.println("Draw right leg.");
					break;
				} default: {
					break;
				}
			}
		} else if (currentDifficulty == medium) { // 7: Head, face, torso, l.arm, r.arm, l.leg, r.leg
			switch (numWrongGuesses) {
				case 1: {
					System.out.println("Draw the head.");
					break;
				} case 2: {
					System.out.println("Draw the face.");
					break;
				} case 3: {
					System.out.println("Draw the torso.");
					break;
				} case 4: {
					System.out.println("Draw left arm.");
					break;
				} case 5: {
					System.out.println("Draw right arm.");
					break;
				} case 6: {
					System.out.println("Draw left leg.");
					break;
				} case 7: {
					System.out.println("Draw right leg.");
					break;
				} default: {
					break;
				}
			}
		} else if (currentDifficulty == hard) { // 5: Head + torso, l.arm, r.arm, l.leg, r.leg
			switch (numWrongGuesses) {
				case 1: {
					System.out.println("Draw the head and torso.");
					break;
				} case 2: {
					System.out.println("Draw left arm.");
					break;
				} case 3: {
					System.out.println("Draw right arm.");
					break;
				} case 4: {
					System.out.println("Draw left leg.");
					break;
				} case 5: {
					System.out.println("Draw right leg.");
					break;
				} default: {
					break;
				}
			}
		} 
	}
	
	// Updates the display of letters.
	// Returns how many times the letter was in the word.
	private static int UpdateStatus(String word, char letter) {
		int hits = 0;
		// Compares letter to each letter in word
		System.out.println("Placeholder code for now, showing where the letters are.");
		for (int position = 0; position < word.length(); position++) {
            if (word.charAt(position) == letter) { // Match
                System.out.print(letter + " "); // Draw
                hits++; // Increment occurrences
            } else { // No match
            	System.out.print("_ "); // Do not draw anything
            }
        }
		System.out.println();
		return hits;
	}
	
	// Returns a status code: 0 = not in word, 1 = in word, 2 = already guessed.
	private static int checkLetter(String word, String wrongLetters, String correctLetters, char letter) {
		if (wrongLetters.indexOf(letter) >= 0 || correctLetters.indexOf(letter) >= 0) { // Letter is in the word but has already been guessed
			return 2;
		}
	      
        if (word.indexOf(letter) < 0) { // Letter is not in the word
            return 0;
        } else { // Letter is in the word
        	return 1;
        }
	}
	
	// Returns a char from player input
	private static char PlayerInput(Scanner input) {
		return input.next().charAt(0);
	}
}
