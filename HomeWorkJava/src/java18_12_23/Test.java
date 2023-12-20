package src.java18_12_23;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(lengthString(String::length, "String"));
        System.out.println(add(Integer::sum, 4, 6));
        System.out.println(sub((a, b) -> a - b, 4, 5));
        System.out.println(div((a, b) -> a / b, 6, 3));
        System.out.println(multi((a, b) -> a * b, 4, 5));
        SafeDivision safeDivide = (a, b) -> b == 0 ? Optional.empty() : Optional.of(a / b);// Не понимаю как ето роботаэт
        System.out.println("Результат: " + safeDivision(safeDivide, 20, 0).orElse(Double.NaN));
        System.out.println(upperCase(str -> str.toUpperCase(Locale.ROOT), "tan"));
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        logger(System.out::println, "hallo");
        squaring(Test::squarings, numbers);
        System.out.println(Arrays.toString(numbers));
        int couchUniqueWords = numberUniqueWords(Test::wordsTheirNumber, "Hallo. How are you? You. you");
        System.out.println(couchUniqueWords);
        int[] numbersMulMinus1 = multiplyingEachElementMinus1(Test::multiply, numbers);
        System.out.println(Arrays.toString(numbersMulMinus1));
        multiply(numbersMulMinus1);


    }

    public static void cyclicRotate(ArrayRotator arrayRotator, int[] arrays, int shift) {
        arrayRotator.rotate(arrays);
    }

 //   public static void cyclicShift(int[] arrays, int shift) {
//    }

    public static void squarings(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= numbers[i];
        }
    }

    public static int[] multiply(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            ints[i] *= (-1);
        }
        return ints;
    }

    public static int[] multiplyingEachElementMinus1(NumberOperationArray numberOperation, int[] numbers) {
        return numberOperation.operate(numbers);
    }


    public static int wordsTheirNumber(String text) {
        Map<String, Integer> mapString = new HashMap<>();
        int couch = 0;
        String[] textWord = gettingCollectionWords(text);
        for (String s : textWord) {
            if (mapString.containsKey(s)) {
                int value = mapString.get(s);
                mapString.put(s, value + 1);
            } else {
                mapString.put(s, 1);
            }
        }
        for (int n : mapString.values()) {
            if (n == 1) {
                couch++;
            }
        }
        return couch;
    }

    public static String[] gettingCollectionWords(String text) {
        String regex = "\\p{Punct}";
        String[] textWord = text
                .replaceAll(regex, "")
                .toLowerCase(Locale.ROOT)
                .split("\\s+");
        return textWord;
    }

    public static int numberUniqueWords(TextAnalyzer textAnalyzer, String str) {
        return textAnalyzer.analyze(str);
    }

    public static void squaring(ArrayTransformer arrayTransformer, int[] numbers) {
        arrayTransformer.transform(numbers);
    }

    public static void logger(Logger logger, String str) {
        logger.log(str);
    }

    public static String upperCase(UpperCaseConverter upperCaseConverter, String str) {
        upperCaseConverter.convert(str);
        return str;
    }

    public static Optional<Double> safeDivision(SafeDivision safeDivision, double a, double b) {
        return safeDivision.divide(a, b);
    }

    public static int lengthString(StringLength stringLength, String str) {
        return stringLength.getLength(str);
    }

    public static int add(NumberOperation numberOperation, int a, int b) {
        return numberOperation.operate(a, b);
    }

    public static int sub(NumberOperation numberOperation, int a, int b) {
        return numberOperation.operate(a, b);
    }

    public static int div(NumberOperation numberOperation, int a, int b) {
        return numberOperation.operate(a, b);
    }

    public static int multi(NumberOperation numberOperation, int a, int b) {
        return numberOperation.operate(a, b);
    }
}

