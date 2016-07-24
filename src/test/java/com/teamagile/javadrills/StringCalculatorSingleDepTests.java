package com.teamagile.javadrills;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

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
    public void add_whenCalledEmpty_alwaysCallsLogger() throws Throwable {
        FakeLogger mockLog = new FakeLogger(8000);
        StringCalculatorWithOneDep sc = new StringCalculatorWithOneDep( mockLog);

        sc.add("");

        assertEquals( "got: 0", mockLog.logEntry);

    }

    @Test
    public void add_whenCalledNormally_callsLogger() throws Throwable {
        FakeLogger mockLog = new FakeLogger(4000);
        StringCalculatorWithOneDep sc = new StringCalculatorWithOneDep( mockLog);

        sc.add("1,2");

        assertEquals("got: 3", mockLog.logEntry);
    }



}

