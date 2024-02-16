package src._2024_02_07Pattern.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Разберитесь с
 * HTML-кодом и извлеките все ссылки (теги <a>) с их атрибутами href.
 */
public class HtmlLinkExtractor {
    public static List<String> extractLinks(String html) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("<a\\s+[^>]*href=\"([^\"]*)\"[^>]*>");
        Matcher matcher= pattern.matcher(html);

        matcher.results()
                .map(MatchResult::group)
                .forEach(links::add);
        return links;
    }

    public static void main(String[] args) {
        String html = "<a href=\"https://www.example.com\">Example</a> " +
                      "<a href=\"https://www.google.com\">Google</a>";
        List<String> extractedLinks = extractLinks(html);

        for (String link : extractedLinks) {
            System.out.println(link);
        }
    }
}
