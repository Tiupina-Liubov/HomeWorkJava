package src._2024_02_07Pattern.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Найдите все домены в строке. Домены имеют формат
 * "example.com" и могут быть встроены в текст в любом месте.
 */
public class DomainFinder {
    public static List<String> findDomains(String input) {
        List<String> domains = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+\\b");
        Matcher matcher = pattern.matcher(input);

        matcher.results()
                .map(MatchResult::group)
                .forEach(domains::add);

        return domains;
    }

    public static void main(String[] args) {
        String text = "Visit example.com for more information. Also, check out google.com";
        List<String> domains = findDomains(text);

        for (String domain : domains) {
            System.out.println(domain);
        }
    }
}
