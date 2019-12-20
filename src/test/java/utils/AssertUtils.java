package utils;

import org.hamcrest.Matcher;
import org.junit.Assert;

import lombok.extern.log4j.Log4j;

@Log4j
public class AssertUtils {

    private static final String ASSERT_MESSAGE = "Assert that: %s%s [Actual value:] %s%s[Expected value:] %s";

    /**
     * @param message
     *         - message have a positive content that will be explained by actual and expected value
     * @param actual
     *         value
     * @param expected
     *         value
     *
     * @assertThat method check if actual value equals with expected value. Because in this method we log assert information:
     */
    public static <T> void assertThat(String message, T actual, Matcher<T> expected) {
        log.info(String.format(ASSERT_MESSAGE, message, System.lineSeparator(), actual, System.lineSeparator(), expected));
        Assert.assertThat(message, actual, expected);
    }

    /**
     * @param message
     *         - message have a positive content that will be explained by actual boolean condition and expected one
     * @param condition
     *         - boolean value
     *
     * @assertTrue method check if a boolean condition is TRUE. Because in this method we log assert information:
     */
    public static void assertTrue(String message, boolean condition) {
        log.info(String.format(ASSERT_MESSAGE, message, System.lineSeparator(), condition, System.lineSeparator(), Boolean.TRUE));
        Assert.assertTrue(message, condition);
    }

}