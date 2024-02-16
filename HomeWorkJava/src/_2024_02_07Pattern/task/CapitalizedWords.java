package src._2024_02_07Pattern.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Найдите все слова, которые начинаются с заглавной буквы.
 */

public class CapitalizedWords {
    public static List<String> findCapitalizedWords(String input) {
        List<String> words = new ArrayList<>();
        Pattern pattern= Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
        Matcher matcher= pattern.matcher(input);

        matcher.results()
                .map(MatchResult::group)
                .forEach(words::add);
        return words;
    }

    public static void main(String[] args) {
        String text = "This is a Test sentence with Some Capitalized Words.";
        List<String> capitalizedWords = findCapitalizedWords(text);

        for (String word : capitalizedWords) {
            System.out.println(word);
        }
    }
}
