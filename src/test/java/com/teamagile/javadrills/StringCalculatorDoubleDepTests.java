package com.teamagile.javadrills;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class StringCalculatorDoubleDepTests {

// factory pattern for testing
    private StringCalculatorWithTwoDep makeCalc() {

        return new StringCalculatorWithTwoDep( new FakeLogger(0), new FakeWebService());
    }

    private void assertAdding(String numbers, int expected) throws Throwable{
        StringCalculatorWithTwoDep sc = makeCalc();

        int result = sc.add(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void add_whenLoggerFails_callWebService() throws Throwable {
        FakeLogger failingLogger = new FakeLogger( 4000 );
        failingLogger.willThrow( new OutOfMemoryError());
        FakeWebService mockWebService = new FakeWebService();

        // add defective Logger for this test instead of using the Factory
        StringCalculatorWithTwoDep sc = new StringCalculatorWithTwoDep( failingLogger, mockWebService);

        sc.add("1,2");

        assertEquals( "got: java.lang.OutOfMemoryError", mockWebService.written);

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void add_negative_throws2()throws Throwable{
        StringCalculatorWithTwoDep calc = makeCalc();

        thrown.expect(IllegalArgumentException.class);
        calc.add("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_negative_throws1() throws Throwable {
        makeCalc().add("-1");
    }


    @Test
    public void add_negative_throws0() throws Throwable {
        StringCalculatorWithTwoDep stringCalculator = makeCalc();
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
        StringCalculatorWithTwoDep sc = makeCalc();

        int result = sc.parse("");

        assertEquals( 0, result );
    }

    @Test
    public void parse_singleNumber_returnsSameNumber() {
        StringCalculatorWithTwoDep sc = makeCalc();

        int result = sc.parse("1");

        assertEquals(1, result);

    }

    @Test
    public void parse_singleNumber2_returnsNumber2() {
        StringCalculatorWithTwoDep sc = makeCalc();

        int result = sc.parse("8");

        assertEquals(8, result);
    }

    @Test
    public void subtract_twoSimpleNumbers_subtractsThem() {
        StringCalculatorWithTwoDep sc = makeCalc();

        int result = sc.subtract(1, 2);

        assertEquals( 1, result);
    }



}

