package com.teamagile.javadrills;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test class for verifying our interactions with a third-party logger
 * The logger is represented by a homemade mock object
 *
 */
public class StringCalculatorSingleDepTests {


// StringCalculator with built-in logging for our tests
    private StringCalculatorWithOneDep makeCalc() {

        return new StringCalculatorWithOneDep( new FakeLogger() );
    }

    private void assertAdding(String numbers, int expected) throws Throwable{
        StringCalculatorWithOneDep sc = makeCalc();

        int result = sc.add(numbers);

        assertEquals(expected, result);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void add_whenCalled_callsLogger() throws Throwable {
        FakeLogger mockLog = new FakeLogger();
        // inject the mock into StringCalculator constructor
        StringCalculatorWithOneDep sc = new StringCalculatorWithOneDep( mockLog);

        // ignoring return value of add(), because the assert will check for logging
        sc.add("");

        assertEquals( "got: 0", mockLog.logEntry);

    }

    @Test
    public void add_whenCalled_callsSlowLogger() throws Throwable {
        FakeLogger slowLog = new FakeLogger( 8000 );
        StringCalculatorWithOneDep sc = new StringCalculatorWithOneDep( slowLog);

        sc.add("1,2");

        assertEquals( "got: 3", slowLog.logEntry);


    }

    @Test
    public void add_loggingFailure_failureIsRecorded() {

    }

    // todo: parse() - log contains the parsed number

    // todo: subtract() - log contains the calculated difference

    // todo: evaluate remaining test coverage for LoggedStringCalculator

    // everything else that follows is duplicated tests of the non-logged StringCalculator

    @Test
    public void add_negative_throws2()throws Throwable{
        StringCalculatorWithOneDep calc = makeCalc();

        thrown.expect(IllegalArgumentException.class);
        calc.add("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_negative_throws1() throws Throwable {
        makeCalc().add("-1");
    }


    @Test
    public void add_negative_throws0() throws Throwable {
        StringCalculatorWithOneDep stringCalculator = makeCalc();
        try {
            stringCalculator.add("-1");
        } catch (Throwable e) {
            //all good
            return;
        }
        assertFalse(true);

    }

    @Test
    public void add_multipleNumbers_returnstheSum() throws  Throwable {
        assertAdding("1,2", 3);
    }

    @Test
    public void add_singleNumber_returnsThatNumber() throws Throwable {
        assertAdding("1", 1);
    }



    @Test
    public void add_emptyString_returnsZero() throws Throwable {
        assertAdding("",0);
    }


    @Test
    public void parse_emptyString_returnsZero() {
        StringCalculatorWithOneDep sc = makeCalc();

        int result = sc.parse("");

        assertEquals( 0, result );
    }

    @Test
    public void parse_singleNumber_returnsSameNumber() {
        StringCalculatorWithOneDep sc = makeCalc();

        int result = sc.parse("1");

        assertEquals(1, result);

    }

    @Test
    public void parse_singleNumber2_returnsNumber2() {
        StringCalculatorWithOneDep sc = makeCalc();

        int result = sc.parse("8");

        assertEquals(8, result);
    }

    @Test
    public void subtract_twoSimpleNumbers_subtractsThem() {
        StringCalculatorWithOneDep sc = makeCalc();

        int result = sc.subtract(1, 2);

        assertEquals( 1, result);
    }



}

