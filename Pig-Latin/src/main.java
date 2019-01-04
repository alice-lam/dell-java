import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		System.out.println("Hello. What word would you like to translate to pig latin?");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		String result = parseWord(input);
		System.out.println(result);
		reader.close();
	}
	public static String parseWord(String input) {
		char[] vowels = {'a','e','i','o','u'};
		char firstLetter = input.charAt(0);
		
		//First letter is a vowel
		for (int i= 0; i<vowels.length; i++) {
			if (firstLetter == vowels[i]) {
				return input + "yay";
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
}