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
    @CsvSource({"weak, false", "strongPassword1@, true", "noDigit!, false", "NoSpecialChar1, false", ",false"})
    void validatePasswordStrengthTest(String password, boolean isStrength) {

        if (password != null) {

            if (!isStrength) {
                assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
            } else {
                assertTrue(service.validatePasswordStrength(password));
            }

        } else {
            assertThrows(NullPointerException.class, () -> service.validatePasswordStrength(null));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    @NullSource
    void processTextTest(String text) {

        if (text == null) {
            assertThrows(NullPointerException.class, () -> service.processText(null));
            return;
        }

        if (text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        } else {
            assertTrue(service.processText(text));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "one,two,three", "10,,20", "5.5,6.5"})
    @NullSource
    void sumOfNumbersInStringTest(String numbers) {
        if (numbers != null) {

            if (numbers.matches(".*[a-zA-Z]+.*") || numbers.contains(",,")) {
                assertThrows(IllegalArgumentException.class, () -> service.sumOfNumbersInString(numbers));
            } else {
                double expectedSum = computeExpectedSum(numbers);
                Assertions.assertEquals(expectedSum, service.sumOfNumbersInString(numbers));
            }

        } else {
            assertThrows(NullPointerException.class, () -> service.sumOfNumbersInString(null));
        }
    }

    double computeExpectedSum(String numbers) {
        System.out.println(Arrays.stream(numbers.split(",")).mapToDouble(Double::parseDouble).sum());
        return Arrays.stream(numbers.split(",")).map(Double::parseDouble).reduce(Double::sum).orElse(0.0);

    }

    @ParameterizedTest
    @ValueSource(strings = {"http://valid.com", "https://valid.com", "ftp://invalid.com", "justtext"})
    @NullSource
    void validateUrlFormatTest(String url) {

        if (url != null) {

            if (!url.startsWith("http")) {
                assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(url));
            } else {
                assertTrue(service.validateUrlFormat(url));
            }

        } else {
            assertThrows(NullPointerException.class, () -> service.validateUrlFormat(null));
        }
    }

    public static Stream<Arguments> emailListProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
                Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true),
                Arguments.of(List.of(), false)
        );
    }

    @ParameterizedTest
    @MethodSource("emailListProvider")
    void checkEmailListConsistencyTest(List<String> emails, boolean isValid) {

        if (emails.isEmpty()) {
            assertThrows(NullPointerException.class, () -> service.checkEmailListConsistency(emails),
                    "Должно быть выброшено исключение NullPointerException");

        } else {
            if (!isValid) {
                assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails),
                        "Должно быть выброшено исключение IllegalArgumentException");
            } else {
                assertTrue(service.checkEmailListConsistency(emails),
                        "Список должен быть согласованным");
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
            "ANNa, true",
            "Palindrome, false",
            "Nan,true",
            ", false"
    })
    void checkStringPalindromeTest(String word, boolean isPalindrome) {

        if (word == null) {
            assertThrows(NullPointerException.class, () -> service.checkStringPalindrome(null));
        } else {

            if (!isPalindrome) {
                assertThrows(IllegalArgumentException.class, () -> service.checkStringPalindrome(word));
            } else {
                assertTrue(service.checkStringPalindrome(word));
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"AB123456","sDfjj223", "Ac786543", "111124AS"})
    @NullSource
    void validateIdentificationNumberTest(String id) {

        if(id!=null) {

            if (!id.matches("^[A-Za-z]{2}\\d{6}$")) {
                assertThrows(IllegalArgumentException.class,
                        ()-> service.validateIdentificationNumber(id));
            }else {
                assertTrue(service.validateIdentificationNumber(id));
            }

        }else {
            assertThrows(NullPointerException.class,()->service.validateIdentificationNumber(null));
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
    void checkSumOfListAgainstThresholdTest(List<Integer> numbers, int threshold, boolean expectedResult) {

        if (numbers != null) {

            if (!expectedResult) {
                assertThrows(IllegalArgumentException.class,
                        () -> service.checkSumOfListAgainstThreshold(numbers, threshold));
            } else {
                    assertTrue(service.checkSumOfListAgainstThreshold(numbers, threshold));
            }

        } else {
            assertThrows(NullPointerException.class,
                    () -> service.checkSumOfListAgainstThreshold(null, threshold));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "192.168.0.1","255.255.255.255","8.8.8.8","256.168.0.1","192.168.0","172.16.31.45.1"})
    void validateIPAddressTest(String ipAddress) {

        if(ipAddress!=null) {

            if (!ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
                assertThrows(IllegalArgumentException.class, () -> service.validateIPAddress(ipAddress));
            }else {
                assertTrue(service.validateIPAddress(ipAddress));
            }

        }else {
            assertThrows(NullPointerException.class,()-> service.validateIPAddress(null));
        }
    }

    public static Stream<Arguments> listsInStrings() {
        return Stream.of(
                Arguments.of(Arrays.asList("1","1","2","3"), false),
                Arguments.of(Arrays.asList("1", "2", "3","4"), true),
                Arguments.of(Arrays.asList(null, null,"5","4"), true),
                Arguments.of(Arrays.asList(null, null,"5","4","4"), false),
                Arguments.of(Arrays.asList(null, null), false)
        );
    }
    @ParameterizedTest
    @MethodSource("listsInStrings")
    void ensureNoDuplicateEntries(List<String> entries,boolean expectedResult) {
        if(entries.isEmpty()){
            assertThrows(NullPointerException.class,()->service.ensureNoDuplicateEntries(entries));
        }
        if(!expectedResult){
            assertFalse(service.ensureNoDuplicateEntries(entries));
        }else{
            assertTrue(service.ensureNoDuplicateEntries(entries));
        }

    }
}


