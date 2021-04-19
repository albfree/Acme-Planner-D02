package acme.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.customisations.Customisation;
import acme.features.administrator.customisation.AdministratorCustomisationRepository;

public class SpamCheck {

	@Autowired
	private static AdministratorCustomisationRepository repository;
	
	public static boolean isSpamText(final String textToCheck) {
		boolean result = false;
		Double numSpWordsInText = 0.;
		Integer numOfWords = textToCheck.split(" ").length;
		List<Customisation> customization = (List<Customisation>) SpamCheck.repository.findCustomisations();
		String spamWords = customization.get(0).getSpamWords();
		String[] spamWordsArray = spamWords.split(";");
		List<String> spamWordsList = Arrays.asList(spamWordsArray);
		for (String sw : spamWordsList) {
			numSpWordsInText = numSpWordsInText + SpamCheck.timesAppearSpamWord(textToCheck.toLowerCase(), sw.toLowerCase(), 0.);
			Double percentage = numSpWordsInText / numOfWords * 100;
			if (percentage > customization.get(0).getThreshold()) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private static double timesAppearSpamWord(final String textToCheck, final String spamWord, Double numSpWord) {
		if (textToCheck.contains(spamWord)) {
			Integer index = textToCheck.indexOf(spamWord) + spamWord.length();
			numSpWord += 1;
			return SpamCheck.timesAppearSpamWord(textToCheck.substring(index).trim(), spamWord, numSpWord);
		}
		return numSpWord;
	}
}
