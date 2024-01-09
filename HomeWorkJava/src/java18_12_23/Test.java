package src.java18_12_23;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("Создайте функциональный интерфейс StringLength с методом getLength, который принимает строку и возвращает её длину.\n" +
                "Напишите метод, который принимает строку и StringLength интерфейс и выводит длину строки.\n");
        System.out.println(lengthString(String::length, "String"));

        System.out.println("Создайте функциональный интерфейс NumberOperation с методом operate, который принимает два целых числа и возвращает целое число.\n" +
                "Напишите методы для выполнения базовых арифметических операций (сложение, вычитание, умножение, деление) с использованием этого интерфейса.\n");
        System.out.println(add(Integer::sum, 4, 6));

        System.out.println(sub((a, b) -> a - b, 4, 5));

        System.out.println(div((a, b) -> a / b, 6, 3));

        System.out.println(multi((a, b) -> a * b, 4, 5));

        System.out.println("+Создайте функциональный интерфейс SafeDivision с методом divide, который безопасно делит два числа и возвращает Optional<Double>.\n" +
                "Реализуйте метод, который делит два числа с использованием SafeDivision, обрабатывая случай деления на ноль.\n");
        SafeDivision safeDivide = (a, b) -> b == 0 ? Optional.empty() : Optional.of(a / b);
        System.out.println("Результат: " + safeDivision(safeDivide, 20, 0).orElse(Double.NaN));

        System.out.println("Создайте функциональный интерфейс UpperCaseConverter с методом convert, который преобразует строку в верхний регистр.\n" +
                "Напишите метод, который принимает строку и UpperCaseConverter интерфейс, и преобразует её в верхний регистр.\n");
        System.out.println(upperCase(str -> str.toUpperCase(Locale.ROOT), "tan"));

        System.out.println("Создайте функциональный интерфейс Logger с методом log, который принимает строку и выводит её в консоль.\n" +
                "Напишите метод, который использует Logger для логирования различных сообщений.\n");
        logger(System.out::println, "hallo");

        System.out.println("Создайте функциональный интерфейс ArrayTransformer с методом transform, который принимает массив\n" +
                "целых чисел и выполняет операцию возведения каждого элемента в квадрат.\n" +
                "Напишите метод, который принимает массив и ArrayTransformer, и изменяет массив, возведя каждый его элемент в квадрат.\n");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        squaring(Test::squarings, numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println("Создайте функциональный интерфейс TextAnalyzer с методом analyze, который принимает текст и анализирует его, возвращая результат анализа.\n" +
                "Напишите метод, который принимает строку и TextAnalyzer, и подсчитывает количество уникальных слов в тексте.\n");
        int couchUniqueWords = numberUniqueWords(Test::wordsTheirNumber, "Hallo. How are you? You. you");
        System.out.println(couchUniqueWords);

        System.out.println("Создайте функциональный интерфейс NumberProcessor с методом process, который выполняет операцию над массивом чисел.\n" +
                "Напишите метод, который принимает массив чисел и NumberProcessor, и возвращает массив после умножения каждого элемента на -1\n");
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


    public static int wordsTheirNumber(String text){
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

