package src._2024_01_10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Stream {
    public static List<String> filterByLength(List<String> input, int length) {
        return input.stream()
                .filter(str -> str.length() == length)
                .toList();
    }

    public static List<String> toUpperCase(List<String> input) {
        return input.stream()
                .map(String::toUpperCase)
                .toList();
    }

    public static Optional<String> findFirstStartingWith(List<String> input, char letter) {
        return input.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .limit(1l)
                .findFirst();
    }

    public static String joinByComma(List<String> input) {
        if (input.isEmpty()) {
            return " ";
        }
        return String.join(", ", input);
    }

    public static long countContainingChar(List<String> input, char ch) {
        return input.stream()
                .filter(str -> str.contains(String.valueOf(ch)))
                .count();
    }

    public static int sumOfList(List<Integer> input) {
        return input.stream()
                .reduce(Integer::sum).get();
    }

    public static List<Integer> getSquares(List<Integer> input) {
        return input.stream()
                .map(n -> n * n)
                .toList();
    }

    public static List<Integer> filterGreaterThan(List<Integer> input, int minValue) {
        return input.stream()
                .filter(a -> a > minValue)
                .toList();
    }

    public static boolean containsNumber(List<Integer> input, int number) {
        return input.stream()
                .anyMatch(i -> i == number);
    }

    public static Optional<Integer> findMax(List<Integer> input) {
        return input.stream()
                .reduce(Integer::max);
    }

    public static List<String> convertToStringList(List<Character> input) {
        return input.stream()
                .map(String::valueOf)
                .toList();
    }

    public static List<Character> filterByAsciiValue(List<Character> input, int ascii) {
        return input.stream()
                .filter(c -> c != ascii)
                .toList();
    }

    public static boolean areAllUpperCase(List<Character> input) {
        return input.stream()
                .allMatch(Character::isUpperCase);
    }

    public static Optional<Character> findFirstDuplicate(List<Character> input) {
        return input.stream()
                .distinct()
                .filter(el -> input.indexOf(el) != input.lastIndexOf(el))
                .findFirst();
    }

    public static List<Character> reverseList(List<Character> input) {
        return input.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list;
                }));
    }

    public static Optional<Float> findMin(List<Float> input) {
        return input.stream()
                .reduce(Float::min);
    }

    public static List<Float> multiplyBy(List<Float> input, float multiplier) {
        return input.stream()
                .map(f -> (float) Math.pow(f, multiplier)).toList();
    }

    public static List<Float> filterLessThan(List<Float> input, float value) {
        return input.stream()
                .filter(f -> f > value)
                .toList();
    }

    public static boolean containsNegative(List<Float> input) {
        return input.stream()
                .anyMatch(f -> f < 0);
    }

    public static List<Integer> roundNumbers(List<Float> input) {
        return input.stream()
                .map(f -> {
                    if (f > (f.intValue() + 0.5f)) {
                        return f.intValue() + 1;
                    } else {
                        return f.intValue();
                    }
                })
                .toList();
    }

    public static <T> long countUnique(List<T> input) {
        return input.stream()
                .distinct()
                .count();
    }

    public static <T extends Comparable<T>> boolean isSorted(List<T> input) {
        return IntStream.range(0, input.size() - 1)
                .noneMatch(index -> input.get(index).compareTo(input.get(index + 1)) > 0);
    }

    public static <T> Optional<T> getLastElement(List<T> input) {
        return input.stream()
                .reduce((a, b) -> b);
    }

    public static <T> List<T> shuffleList(List<T> input) {
        return input.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            Collections.shuffle(list);
                            return list;
                        }));
    }

    public static <T> Map<T, Long> countFrequency(List<T> input) {
        return input.stream()
                .collect(Collectors.groupingBy((e -> e), Collectors.counting()));
    }
}
