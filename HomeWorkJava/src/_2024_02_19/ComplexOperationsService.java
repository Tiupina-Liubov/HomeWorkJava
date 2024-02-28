package src._2024_02_19;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * validatePasswordStrength: Тестируйте различные пароли, чтобы проверить силу пароля.
 * Используйте @CsvSource для тестирования паролей с различными комбинациями символов.
 * <p>
 * processText: Проверьте тексты на наличие запрещенных слов.
 * Используйте @ValueSource с различными фразами.
 * <p>
 * sumOfNumbersInString: Тестируйте строки с числами, разделенными запятыми, включая некорректные строки.
 *
 * @CsvSource может использоваться для предоставления различных строк.
 * <p>
 * validateUrlFormat: Используйте @ValueSource для проверки различных форматов URL, включая невалидные.
 * <p>
 * checkEmailListConsistency: Создайте тесты для проверки списков электронных адресов на наличие невалидных адресов.
 * @MethodSource может использоваться для генерации и предоставления списков адресов.
 * <p>
 * checkStringPalindrome: Проверьте различные строки на то, являются ли они палиндромами.
 * Используйте @ValueSource для предоставления строк.
 * <p>
 * validateIdentificationNumber: Тестируйте различные идентификационные номера на соответствие формату.
 * @ValueSource подходит для этой задачи.
 * <p>
 * checkSumOfListAgainstThreshold: Проверьте, что сумма чисел в списке превышает заданный порог.
 * @MethodSource может использоваться для генерации тестовых списков чисел и порогов.
 * <p>
 * validateIPAddress: Тестируйте различные строки на соответствие формату IPv4.
 * Используйте @ValueSource для предоставления IP адресов.
 * <p>
 * ensureNoDuplicateEntries: Проверьте списки на наличие дубликатов.
 * @MethodSource подходит для предоставления различных списков строк.
 */
public class ComplexOperationsService {
    public static void main(String[] args) {
//        List<Integer> integers= Arrays.asList(null,null);
//        System.out.println(checkSumOfListAgainstThreshold(integers, 0));
    }


    /**
     * - понять что делает метод
     * - понять какие у него поведения
     * - понять пограничные значения
     * - написать параметризованный тест с использованием пограничных значений
     */
    public boolean validatePasswordStrength(String password) throws IllegalArgumentException, NullPointerException {
        if (password != null) {
            // Password must contain at least 8 characters, including a digit, a lowercase letter, an uppercase letter, and a special character
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Password does not meet the strength requirements.");
            }
            return true;
        } else {
            throw new NullPointerException("Password can not be null");
        }
    }

    public boolean processText(String text) throws IllegalArgumentException, NullPointerException {
        if (text != null) {
            // Text must not contain any forbidden words: "error", "fail", "wrong"
            List<String> forbiddenWords = Arrays.asList("error", "fail", "wrong");
            boolean containsForbiddenWord = forbiddenWords.stream().anyMatch(text::contains);
            if (containsForbiddenWord) {
                throw new IllegalArgumentException("Text contains forbidden words.");
            }
            return true;
        } else {
            throw new NullPointerException("Text can not be null");
        }
    }

    public double sumOfNumbersInString(String numbers) throws IllegalArgumentException, NullPointerException {

        if (numbers != null) {
            // The string must contain numbers separated by commas, e.g., "1,2,3"
            List<Double> parsedNumbers;

            try {
                parsedNumbers = Arrays.stream(numbers.split(","))
                        .map(Double::parseDouble)
                        .toList();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("String contains non-numeric values.");
            }
            return parsedNumbers.stream().reduce(Double::sum).orElse(0.0);

        } else {
            throw new NullPointerException("String can not be null");
        }
    }

    public boolean validateUrlFormat(String url) throws IllegalArgumentException, NullPointerException {
        if (url != null) {
            // URL must start with http or https and contain a domain name
            String regex = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}.*$";
            if (!url.matches(regex)) {
                throw new IllegalArgumentException("URL format is invalid.");
            }
            return true;
        } else {
            throw new NullPointerException("URL can not be null");
        }
    }

    public boolean checkEmailListConsistency(List<String> emails) throws IllegalArgumentException, NullPointerException {
        if (emails.isEmpty()) {
            throw new NullPointerException("Email list is empty");
        } else {
            // All emails in the list must be valid
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(emailRegex);
            boolean allEmailsValid = emails.stream().allMatch(email -> pattern.matcher(email).matches());

            if (!allEmailsValid) {
                throw new IllegalArgumentException("Email list contains invalid emails.");

            } else {
                return true;
            }
        }
    }


    public boolean checkStringPalindrome(String input) {

        if (input != null) {
            String sanitized = input.replaceAll("\\s+", "").toLowerCase();
            String reversed = new StringBuilder(sanitized).reverse().toString();

            if (!sanitized.equals(reversed)) {
                throw new IllegalArgumentException("String is not a palindrome.");
            } else {
                return true;
            }

        } else {
            throw new NullPointerException("String can not be null");
        }
    }

    public boolean validateIdentificationNumber(String id) {
        if (id != null) {
            // ID должен быть в формате: две буквы, за которыми следуют 6 цифр (например, AB123456)
            if (!id.matches("^[A-Za-z]{2}\\d{6}$")) {
                throw new IllegalArgumentException("Identification number format is invalid.");
            } else {
                return true;
            }
        } else {
            throw new NullPointerException("ID can not be null");
        }
    }

    public boolean checkSumOfListAgainstThreshold(List<Integer> numbers, int threshold) {
        if (numbers == null) {
            throw new NullPointerException("The list of numbers is null.");
        }
        int sum = numbers.stream()
                .filter(Objects::nonNull)  // Фильтрация null значений
                .mapToInt(Integer::intValue)
                .reduce(Integer::sum)
                .orElse(0);

        if ((sum <= threshold)) {
            throw new IllegalArgumentException("Sum of the list is not above the threshold.");
        }
        return true;
    }

    public boolean validateIPAddress(String ipAddress) {
        if (ipAddress == null) {
            throw new NullPointerException("IP address can not be null");
        }
        // IP адрес должен соответствовать формату IPv4
        if (!ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
            throw new IllegalArgumentException("IP address format is invalid.");
        } else {
            return true;
        }
    }


    public boolean ensureNoDuplicateEntries(List<String> entries) {
        if (entries != null) {
            List<String> listNotNull = entries.stream()
                    .filter(Objects::nonNull)
                    .toList();
            if (entries.isEmpty() || listNotNull.isEmpty()) {
                throw new NullPointerException("The list of numbers is null.");
            }
            long uniqueCount = listNotNull.stream().distinct().count();
            return uniqueCount >= listNotNull.size();
        } else {
            throw new CollectionEmptyException(ErrorMassager.COLLECTION_IS_EMPTY);
        }
    }
}