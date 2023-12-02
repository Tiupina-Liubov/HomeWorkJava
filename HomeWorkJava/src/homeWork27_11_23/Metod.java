package homeWork27_11_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Metod {
    public static void main(String [] args){
    ArrayList<Integer> arrayList = new ArrayList<>();
    int x = 18;
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(1);
    int[] numbers = new int[]{17, 1, 2, 2, 4, 3, 3, 3};
    findPainNumber(arrayList, x);
    findPainNumber(numbers, x);
        System.out.println("-------------");
    numberRepeatingElements(numbers);
        System.out.println("-------------");
    numberRepeatingElements(arrayList);
        System.out.println("----------------");
        System.out.println(Arrays.toString(numbers));
    sortReverse(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayList);
    sortReverse(arrayList);
        System.out.println(arrayList);
        System.out.println("______");
        System.out.println(Arrays.toString(numbers));
    sortBubbleReverse(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayList);
    sortBubbleReverse(arrayList);
        System.out.println(arrayList);
        System.out.println("---------------");
        System.out.println(Arrays.toString(numbers));
    removingDuplicates(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayList);
    removingDuplicates(arrayList);
        System.out.println(arrayList);
        System.out.println("---------------");
    List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("orange");
        stringList.add("orange");
        stringList.add("orange");
        stringList.add("kivi");
        stringList.add("mango");
        stringList.add("mango");
        stringList.add("mango");
        stringList.add("mango");
        stringList.add("mango");
    String str = "apple";
        System.out.println(stringList);
    removeOccurrencesString(stringList, str);
        System.out.println(stringList);
        System.out.println("______________");
    String concatenatesStrList = concatenatesStrings(stringList);
        System.out.println(concatenatesStrList);
        System.out.println("____________");
    List<Integer> higherValue = valueGreater(arrayList, 3);
        System.out.println(arrayList);
        System.out.println(higherValue);
        System.out.println("___________");
        System.out.println(stringList);
    List<Integer> lengthLine = lengthStrings(stringList);
        System.out.println(lengthLine);
        System.out.println("__________");
        System.out.println(stringList);
    List<String> uniqueStrings = returnUniqueStrings(stringList);
        System.out.println(uniqueStrings);
        stringList.add("apple");
        stringList.add("orange");
        System.out.println(stringList);
    removeSpringLengthFeatures(stringList, "asfgh");
        System.out.println(stringList);
        System.out.println("___________");
    enumerationElementList(stringList);
    List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 5, 3, 4, 5, 6, 1, 6, 8, 9, 10, 56, 100, 4));
    int sum = findingSum(numbers1);
        System.out.println(sum);
    int median = findingMedian(numbers1);
        System.out.println(median);
    findingAverageMedianStandardDeviation(numbers1);
        stringList.add("orange");
        stringList.add("kivi");
        stringList.add("mango");
        stringList.add("mango");
        stringList.add("mango");
        System.out.println(stringList);
    List<String> repeatingLine = returnRowsGreaterGivenNumber(stringList, 2);
        System.out.println(repeatingLine);
}

    public static List<String> returnRowsGreaterGivenNumber(List<String> stringList, int number) {
        List<String> returnList = new ArrayList<>();
        int temp;
        for (int i = 0; i < stringList.size(); ++i) {
            temp = 0;
            for (int j = i; j < stringList.size(); ++j) {
                if ((stringList.get(j)).equals(stringList.get(i))) {
                    ++temp;
                }
            }
            if (number < temp) {
                returnList.add(stringList.get(i));
            }
        }

        return returnUniqueStrings(returnList);
    }

    public static void findingAverageMedianStandardDeviation(List<Integer> numbers) {
        int sum = findingSum(numbers);
        int median = findingMedian(numbers);
        int length = numbers.size();
        int average = sum / length;
        float dispersion = 0.0F;
        double standardDeviation;

        for (int i = 0; i < numbers.size(); ++i) {
            float dispNum = (float) Math.pow((numbers.get(i) - average), 2.0);
            dispersion += dispNum;
        }
        dispersion = dispersion / (float) length - 1.0F;
        standardDeviation = Math.sqrt(dispersion);
        System.out.println("Mean = " + average + "\nMedian =" + median + "\nStandard deviation =" + standardDeviation);
    }

    public static int findingMedian(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);
        int median;
        if (numbers.size() % 2 == 0) {
            int index = numbers.size() / 2;
            median = (numbers.get(index) + numbers.get(index + 1)) / 2;
        } else {
            median = numbers.get(numbers.size() / 2);
        }
        return median;
    }

    public static int findingSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); ++i) {
            sum += numbers.get(i);
        }
        return sum;
    }

    public static String enumerationElementList(List<String> stringList) {
        StringBuilder resultStringBuilder = new StringBuilder();
        if (stringList.size() == 0) {
            System.out.println("Not string");
        } else {
            for (int i = 0; i < stringList.size(); i++)
                resultStringBuilder.append(i + ", ");
        }
        String finishString = String.valueOf(resultStringBuilder);
        return finishString;
    }

    public static void sortBubble(ArrayList<Integer> numbers) {
        for (int j = 0; j < numbers.size(); ++j) {
            for (int i = 1 + j; i < numbers.size(); ++i) {
                if ( numbers.get(j) >  numbers.get(i)) {
                    int temp =  numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }

    }

    public static void removeSpringLengthFeatures(List<String> stringList, String str) {
        for (int i = 0; i < stringList.size(); ++i) {
            if ((stringList.get(i)).length() < str.length()) {
                stringList.remove(i);
                --i;
            }
        }

    }

    public static List<String> returnUniqueStrings(List<String> strings) {
        List<String> uniqueStrings = strings;
        for (int i = 0; i < uniqueStrings.size(); ++i) {
            for (int j = i + 1; j < strings.size(); ++j) {
                if ((strings.get(i)).equals(uniqueStrings.get(j))) {
                    uniqueStrings.remove(j);
                    --j;
                }
            }
        }
        return uniqueStrings;
    }

    public static List<Integer> lengthStrings(List<String> strings) {
        List<Integer> lengths = new ArrayList();
        for (int i = 0; i < strings.size(); ++i) {
            int length = ( strings.get(i)).length();
            lengths.add(length);
        }
        return lengths;
    }

    public static List<Integer> valueGreater(List<Integer> numberList, int number) {
        List<Integer> valueNumbers = new ArrayList();
        for (int i = 0; i < numberList.size(); ++i) {
            if (numberList.get(i) > number) {
                valueNumbers.add(numberList.get(i));
            }
        }

        return valueNumbers;
    }

    public static String concatenatesStrings(List<String> stringList) {
        StringBuilder resultStringBuilder = new StringBuilder();
        if (stringList.size() == 0) {
            System.out.println("Not string");
        } else {
            for (String str : stringList) {
                resultStringBuilder.append(str + " ");
            }
        }
        String finishString = resultStringBuilder.toString();
        return finishString;
    }

    public static void removeOccurrencesString(List<String> stringList, String string) {
        for (int i = 0; i < stringList.size(); ++i) {
            if ((stringList.get(i)).equalsIgnoreCase(string)) {
                stringList.remove(i);
                break;
            }
        }

    }

    public static void sortReverse(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); ++i) {
            int j = arrayList.size()-1- i;
            if (j > i) {
                int temp =  arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
            }
        }

    }

    public static void sortReverse(int[] numbers) {
        for (int i = 0; i < numbers.length; ++i) {
            int j = numbers.length -1 - i;
            if (j > i) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

    }

    public static void sortBubbleReverse(ArrayList<Integer> numbers) {
        for (int j = 0; j < numbers.size(); ++j) {
            for (int i = 1 + j; i < numbers.size(); ++i) {
                if ( numbers.get(j) < numbers.get(i)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }

    }

    public static void sortBubbleReverse(int[] numbers) {
        for (int j = 0; j < numbers.length; ++j) {
            for (int i = 1 + j; i < numbers.length; ++i) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

    }

    public static void removingDuplicates(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            for (int j = i + 1; j < numbers.size(); ++j) {
                if (numbers.get(i) == numbers.get(j)) {
                    numbers.set(j, 0);
                }
            }
        }

    }

    public static void removingDuplicates(int[] number) {
        for (int i = 0; i < number.length - 1; ++i) {
            for (int j = i + 1; j < number.length; ++j) {
                if (number[i] == number[j]) {
                    number[j] = 0;
                }
            }
        }

    }

    public static void numberRepeatingElements(ArrayList<Integer> numbers) {
        int[] repeating = new int[numbers.size()];
        ArrayList<Integer> newNumbers = (ArrayList<Integer>) numbers.clone();

        for (int i = 0; i < numbers.size(); ++i) {
            int temp = 0;

            for (int j = i; j < newNumbers.size(); ++j) {
                if ((Integer) numbers.get(i) != 0 && numbers.get(i) == newNumbers.get(j)) {
                    ++temp;
                    newNumbers.set(j, 0);
                    if (i < repeating.length) {
                        repeating[i] = temp;
                    }
                }
            }

            if (repeating[i] != 0) {
                System.out.println("Number " + numbers.get(i)+ " is repeated " + repeating[i] + " times ");
            }
        }

    }

    public static void numberRepeatingElements(int[] numbers) {
        int[] repeating = new int[numbers.length];
        int[] newNumbers = numbers.clone();

        for (int i = 0; i < numbers.length; ++i) {
            int temp = 0;
            for (int j = i; j < newNumbers.length; ++j) {
                if (numbers[i] != 0 && numbers[i] == newNumbers[j]) {
                    ++temp;
                    newNumbers[j] = 0;
                    if (i < repeating.length) {
                        repeating[i] = temp;
                    }
                }
            }
            if (repeating[i] != 0)
                System.out.println("Number " + numbers[i] + " is repeated " + repeating[i] + " times ");
        }


    }

    public static void findPainNumber(ArrayList<Integer> arrayList, int x) {
        for (int i = 0; i < arrayList.size(); ++i) {
            for (int j = i + 1; j < arrayList.size(); ++j) {
                if (arrayList.get(i) + arrayList.get(j) == x) {
                    System.out.println("fine numbers = " + arrayList.get(i) + " and " + arrayList.get(j));
                    break;
                }
            }
        }

    }

    public static void findPainNumber(int[] arrays, int x) {
        for (int i = 0; i < arrays.length; ++i) {
            for (int j = i + 1; j < arrays.length; ++j) {
                if (arrays[i] + arrays[j] == x) {
                    System.out.println("fine numbers = " + arrays[i] + " and " + arrays[j]);
                    break;
                }
            }
        }
    }
}

