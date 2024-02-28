package src._2024_02_19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ComplexOperationsServiceTest {
    private final ComplexOperationsService service = new ComplexOperationsService();

    @ParameterizedTest
    @CsvSource({"weak, false", "strongPassword1@, true", "noDigit!, false", "NoSpecialChar1, false"})
    void validate_password_strength_positive_test(String password, boolean isStrength) {
        if (isStrength) {
            assertTrue(service.validatePasswordStrength(password));
        }
    }

    @ParameterizedTest
    @CsvSource({"weak, false", "strongPassword1@, true", "noDigit!, false", "NoSpecialChar1, false"})
    void validate_password_strength_negative_test(String password, boolean isStrength) {
        if (!isStrength) {
            assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
        }
    }

    @ParameterizedTest
    @NullSource
    void validate_password_strength_null_test(String password) {
        if (password == null) {
            assertThrows(NullPointerException.class, () -> service.validatePasswordStrength(null));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void process_text_positive_test(String text) {
        if (!(text.contains("error") || text.contains("fail") || text.contains("wrong"))) {
            assertTrue(service.processText(text));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void process_text_negative_test(String text) {
        if (text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        }
    }

    @ParameterizedTest
    @NullSource
    void process_text_null_test(String text) {
        if (text == null) {
            assertThrows(NullPointerException.class, () -> service.processText(null));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "one,two,three", "10,,20", "5.5,6.5"})
    void sum_of_numbers_in_string_positive_test(String numbers) {
        if (!(numbers.matches(".*[a-zA-Z]+.*") || numbers.contains(",,"))) {
            double expectedSum = computeExpectedSum(numbers);
            Assertions.assertEquals(expectedSum, service.sumOfNumbersInString(numbers));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "one,two,three", "10,,20", "5.5,6.5"})
    void sum_of_numbers_in_string_negative_test(String numbers) {
        if (numbers.matches(".*[a-zA-Z]+.*") || numbers.contains(",,")) {
            assertThrows(IllegalArgumentException.class, () -> service.sumOfNumbersInString(numbers));
        }
    }

    @ParameterizedTest
    @NullSource
    void sum_of_numbers_in_string_null_test(String numbers) {
        if (numbers == null) {
            assertThrows(NullPointerException.class, () -> service.sumOfNumbersInString(null));
        }
    }

    double computeExpectedSum(String numbers) {
        return Arrays.stream(numbers.split(",")).map(Double::parseDouble).reduce(Double::sum).orElse(0.0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://valid.com", "https://valid.com", "ftp://invalid.com", "justtext"})
    void validate_url_format_positive_test(String url) {
        if (url.startsWith("http")) {
            assertTrue(service.validateUrlFormat(url));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://valid.com", "https://valid.com", "ftp://invalid.com", "justtext"})
    void validate_url_format_negative_test(String url) {
        if (!url.startsWith("http")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(url));
        }
    }

    @ParameterizedTest
    @NullSource
    void validate_url_format_null_test(String url) {
        if (url == null) {
            assertThrows(NullPointerException.class, () -> service.validateUrlFormat(null));
        }
    }

    public static Stream<Arguments> emailListProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
                Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("emailListProvider")
    void check_email_list_consistency_positive_test(List<String> emails, boolean isValid) {
        if (isValid) {
            assertTrue(service.checkEmailListConsistency(emails));
        }
    }

    @ParameterizedTest
    @MethodSource("emailListProvider")
    void check_email_list_consistency_negative_test(List<String> emails, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails));
        }
    }

    public static Stream<Arguments> emptyList() {
        return Stream.of(Arguments.of(List.of()));
    }

    @ParameterizedTest
    @MethodSource("emptyList")
    void check_email_list_consistency_empty_list_test(List<String> emails) {
        if (emails.isEmpty()) {
            assertThrows(NullPointerException.class, () -> service.checkEmailListConsistency(emails));
        }
    }


    @ParameterizedTest
    @CsvSource({
            "ANNa, true",
            "Palindrome, false",
            "Nan,true"
    })
    void check_string_palindrome_positive_test(String word, boolean isPalindrome) {
        if (isPalindrome) {
            assertTrue(service.checkStringPalindrome(word));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "ANNa, true",
            "Palindrome, false",
            "Nan,true"
    })
    void check_string_palindrome_negative_test(String word, boolean isPalindrome) {
        if (!isPalindrome) {
            assertThrows(IllegalArgumentException.class, () -> service.checkStringPalindrome(word));
        }
    }

    @ParameterizedTest
    @NullSource
    void check_string_palindrome_null_test(String word) {
        if (word == null) {
            assertThrows(NullPointerException.class, () -> service.checkStringPalindrome(null));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"AB123456", "sDfjj223", "Ac786543", "111124AS"})
    void validate_identification_number_positive_test(String id) {
        if (id.matches("^[A-Za-z]{2}\\d{6}$")) {
            assertTrue(service.validateIdentificationNumber(id));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"AB123456", "sDfjj223", "Ac786543", "111124AS"})
    void validate_identification_number_negative_test(String id) {
        if (!id.matches("^[A-Za-z]{2}\\d{6}$")) {
            assertThrows(IllegalArgumentException.class,
                    () -> service.validateIdentificationNumber(id));
        }
    }

    @ParameterizedTest
    @NullSource
    void validate_identification_number_null_test(String id) {
        if (id == null) {
            assertThrows(NullPointerException.class, () -> service.validateIdentificationNumber(null));
        }
    }

    public static Stream<Arguments> listNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 6, false),
                Arguments.of(Arrays.asList(1, 2, 3), 4, true),
                Arguments.of(Arrays.asList(null, null), 5, false)
        );
    }

    @ParameterizedTest
    @MethodSource("listNumbers")
    void check_sum_of_list_against_threshold_positive_test(List<Integer> numbers, int threshold, boolean expectedResult) {
            if (expectedResult) {
                assertTrue(service.checkSumOfListAgainstThreshold(numbers, threshold));
            }
    }

    @ParameterizedTest
    @MethodSource("listNumbers")
    void check_sum_of_list_against_threshold_negative_test(List<Integer> numbers, int threshold, boolean expectedResult) {
            if (!expectedResult) {
                assertThrows(IllegalArgumentException.class,
                        () -> service.checkSumOfListAgainstThreshold(numbers, threshold));
            }
    }

    @ParameterizedTest
    @CsvSource(",5")
    void check_sum_of_list_against_threshold_null_test(List<Integer> numbers, int threshold) {
        if (numbers == null) {
            assertThrows(NullPointerException.class,
                    () -> service.checkSumOfListAgainstThreshold(null, threshold));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.168.0.1", "255.255.255.255", "8.8.8.8", "256.168.0.1", "192.168.0", "172.16.31.45.1"})
    void validate_ip_address_positive_test(String ipAddress) {
            if (ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
                assertTrue(service.validateIPAddress(ipAddress));
            }
    }

    @ParameterizedTest
   @NullSource
    void validate_ip_address_null_test(String ipAddress) {
        if (ipAddress == null) {
            assertThrows(NullPointerException.class, () -> service.validateIPAddress(null));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.168.0.1", "255.255.255.255", "8.8.8.8", "256.168.0.1", "192.168.0", "172.16.31.45.1"})
    void validate_ip_address_negative_test(String ipAddress) {
            if (!ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
                assertThrows(IllegalArgumentException.class, () -> service.validateIPAddress(ipAddress));
            }
    }

    public static Stream<Arguments> listsInStrings() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "1", "2", "3"), false),
                Arguments.of(Arrays.asList("1", "2", "3", "4"), true),
                Arguments.of(Arrays.asList(null, null, "5", "4"), true),
                Arguments.of(Arrays.asList(null, null, "5", "4", "4"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("listsInStrings")
    void ensure_no_duplicate_entries_positive_test(List<String> entries, boolean expectedResult) {
        if (expectedResult) {
            assertTrue(service.ensureNoDuplicateEntries(entries));
        }
    }

    @ParameterizedTest
    @MethodSource("listsInStrings")
    void ensure_no_duplicate_entries_negative_test(List<String> entries, boolean expectedResult) {
        if (!expectedResult) {
            assertFalse(service.ensureNoDuplicateEntries(entries));
        }
    }

    @ParameterizedTest
    @MethodSource("listsInStrings")
    void ensure_no_duplicate_entries_list_empty_test(List<String> entries) {
        if (entries.isEmpty()) {
            assertThrows(NullPointerException.class, () -> service.ensureNoDuplicateEntries(entries));
        }
    }

    @ParameterizedTest
    @MethodSource("listsInStrings")
    void ensure_no_duplicate_entries_null_test(List<String> entries) {
        if (entries==null) {
            assertThrows(CollectionEmptyException.class, () -> service.ensureNoDuplicateEntries(entries));
        }
    }
}


