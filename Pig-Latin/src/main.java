import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		System.out.println("Hello. What would you like to translate to pig latin?");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		String result = "";
		reader.close();
		//if the input is a sentence
		if (input.contains(" ")) {
			result = parseSentence(input);
		}
		//else if input is only a single word
		else{
			result = parseWord(input);
		}
		System.out.println(result);
	}
	
	public static String parseWord(String input) {
		char[] vowels = {'a','e','i','o','u'};
		char firstLetter = input.charAt(0);
		
		//First letter is a vowel
		for (int i= 0; i<vowels.length; i++) {
			if (firstLetter == vowels[i]) {
				return input + chooseEnding();
			}
		}
		
		//First letter is not a vowel, but contains a vowel
		for(int j=0; j<input.length(); j++) {
			for (int i= 0; i<vowels.length; i++) {
				if (input.charAt(j) == vowels[i]) {
					String postVowel= input.substring(j, input.length());
					String subVowel= input.substring(0, j);
					return postVowel + subVowel + "ay";
				}
			}
		}
		
		//if no vowels in the word at all
		return input + "ay";
	}
	
	public static String parseSentence(String input){
		String[] words = input.split(" ");
		String convertedSentence = "";
		for (int i = 0; i<words.length; i++){
			convertedSentence = convertedSentence + parseWord(words[i]) + " ";
		}
		return convertedSentence;
	}
	
	public static String chooseEnding(){
		String wordEnd = "";
		Random r = new Random();
		int randomNum = r.nextInt(3) + 1;
		switch (randomNum) {
		case 1:
			wordEnd = "yay";
			break;
		case 2:
			wordEnd = "way";
			break;
		case 3:
			wordEnd = "ay";
			break;
		}
		return wordEnd;
	}
}