package main.java.org.example._2024_02_07.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Разберитесь с
 * HTML-кодом и извлеките все ссылки (теги <a>) с их атрибутами href.
 */
public class HtmlLinkExtractor {
    public static List<String> extractLinks(String html) {


        return null;
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
