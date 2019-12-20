package utils;

import org.hamcrest.Matcher;
import org.junit.Assert;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssertUtils {

    private static final String ASSERT_MESSAGE = "Assert that: {}{} [Actual value:] {}{}[Expected value:] {}";

    /**
     * @assertThat method check if actual value equals with expected value. Because in this method we log assert information: message, actual value, expected Value, message should have a positive
     * content, that will be explained by actual value and expected one.
     */
    public static <T> void assertThat(String message, T actual, Matcher<T> expected) {
        log.info(ASSERT_MESSAGE, message, System.lineSeparator(), actual, System.lineSeparator(), expected);
        Assert.assertThat(message, actual, expected);
    }

    /**
     * @assertTrue method check if a boolean condition is TRUE. Because in this method we log assert information: message and boolean condition, message should have a positive content, that will be
     * explained by actual boolean condition and expected one
     */
    public static void assertTrue(String message, boolean condition) {
        log.info(ASSERT_MESSAGE, message, System.lineSeparator(), condition, System.lineSeparator(), Boolean.TRUE);
        Assert.assertTrue(message, condition);
    }

}
