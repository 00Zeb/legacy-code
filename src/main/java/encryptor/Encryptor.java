package encryptor;

import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Encryptor {

	
	private AlgorithmLocatorServiceFactoryFacade facade;
	
	public void setFacade(AlgorithmLocatorServiceFactoryFacade facade) {
		this.facade = facade;
	}


	public String cryptWord(String word) {
		// throw expection if its more than one word.
		if (word.contains(" "))
			throw new InvalidParameterException();
		char[] wordArray = word.toCharArray();
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			int charValue = wordArray[i];
			newWord += String.valueOf((char) (charValue + 2));
		}
		return newWord;
	}

	public String cryptWordToNumbers(String word) {
		if (word.contains(" "))
			throw new InvalidParameterException();
		// convert from string to charArray.
		char[] wordArray = word.toCharArray();
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			int charValue = wordArray[i];
			newWord += String.valueOf(charValue + 2);
		}
		return newWord;
	}

	public String cryptWord(String word, String charsToReplace) {
		if (word.contains(" "))
			throw new InvalidParameterException();
		// create all variables
		char[] wordArray = word.toCharArray();
		char[] replacement = charsToReplace.toCharArray();
		char[] result = wordArray.clone();

		for (int i = 0; i < wordArray.length; i++) {
			for (int j = 0; j < replacement.length; j++) {
				if (replacement[j] == wordArray[i]) {
					int charValue = wordArray[i];
					result[i] = (char) (charValue + 2);
				}
			}
		} //end outer
		return String.valueOf(result);
	}

	public String cryptSentence(String sentence) {
		char[] sentenceArray = sentence.toCharArray();
		String newWord = "";
		for (int i = 0; i < sentence.length(); i++) {
			int charValue = sentenceArray[i];
			newWord += String.valueOf((char) (charValue + 2));
		}
		return newWord;
	}

	public String[] getWords(String sentence) {
		return sentence.split(" ");
	}

	/**
	 * To make it easier to read, each word is wrapped in less than and greater
	 * than.
	 * 
	 * @param sentence
	 *            which will be printed to System out.
	 */
	public void printWords(String sentence) {
		String[] words = getWords(sentence);
		for (String word : words) {
			System.out.print("<" + word + ">");
		}
	}

	public String encryptTime() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SSSSSSS");
		doCalculations();
		Date date = getDate();
		String sentence = "the time is " + df.format(date) + " right now";
		return cryptSentence(sentence);
	}
	
	protected Date getDate(){
		return new Date();
	}

	private void doCalculations() {
		//Pretend there is some calculations below..
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
		}
	}
	
	public String encrypt(String text) {
		int encryptEnabled = SystemConfiguration.isEncryptEnabled();
		if(encryptEnabled == 1) {
			return cryptSentence(text);
		}
		else if(encryptEnabled == 2) {
			return text;
		}
		else {
			return null;
		}
	}

	
	public String encryptExternal(String text, String algorithmStr) {
		Algorithm algorithm = facade.getAlgorithm(algorithmStr);
		return algorithm.encrypt(text);
	}
	
	
	
	
	
	
	
	
	
}