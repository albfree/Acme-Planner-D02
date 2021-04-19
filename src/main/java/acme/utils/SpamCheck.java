package acme.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.customizations.Customization;
import acme.features.administrator.customization.AdministratorCustomizationRepository;

public class SpamCheck {

	@Autowired
	private static AdministratorCustomizationRepository repository;
	
	public static boolean isSpamText(final String textToCheck) {
		boolean result = false;
		Double numSpWordsInText = 0.;
		final Integer numOfWords = textToCheck.split(" ").length;
		final List<Customization> customization = (List<Customization>) SpamCheck.repository.findCustomizations();
		final String spamWords = customization.get(0).getSpamWords();
		final String[] spamWordsArray = spamWords.split(";");
		final List<String> spamWordsList = Arrays.asList(spamWordsArray);
		for (final String sw : spamWordsList) {
			numSpWordsInText = numSpWordsInText + SpamCheck.timesAppearSpamWord(textToCheck.toLowerCase(), sw.toLowerCase(), 0.);
			final Double percentage = numSpWordsInText / numOfWords * 100;
			if (percentage > customization.get(0).getThreshold()) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private static double timesAppearSpamWord(final String textToCheck, final String spamWord, Double numSpWord) {
		if (textToCheck.contains(spamWord)) {
			final Integer index = textToCheck.indexOf(spamWord) + spamWord.length();
			numSpWord += 1;
			return SpamCheck.timesAppearSpamWord(textToCheck.substring(index).trim(), spamWord, numSpWord);
		}
		return numSpWord;
	}
}
