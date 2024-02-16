package src._2024_02_07Pattern.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Найдите все слова, которые начинаются
 * с гласной буквы и заканчиваются согласной.
 */
public class VowelConsonantWords {
    public static List<String> findVowelConsonantWords(String input) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[aeiouAEIOU][a-zA-Z]*[^aeiouAEIOU\\W]\\b");
        Matcher matcher = pattern.matcher(input);

        matcher.results()
                .map(MatchResult::group)
                .forEach(words::add);
        return words;
    }

    public static void main(String[] args) {
        String text = "Apple, orange, and banana are fruits. Dog, cat, and bird are animals.";
        List<String> vowelConsonantWords = findVowelConsonantWords(text);

        for (String word : vowelConsonantWords) {
            System.out.println(word);
        }
    }
}
