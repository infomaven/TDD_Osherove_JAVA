package com.teamagile.javadrills;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class StringCalculatorTests{

// factory pattern for testing
    private StringCalculator makeCalc() {

        return new StringCalculator();
    }

    private void assertAdding(String numbers, int expected) throws Throwable{
        StringCalculator sc = makeCalc();

        int result = sc.add(numbers);

        assertEquals(expected, result);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void add_negative_throws2()throws Throwable{
        StringCalculator calc = makeCalc();

        thrown.expect(IllegalArgumentException.class);
        calc.add("-1");
    }

    @Test( expected = NumberFormatException.class)
    public void add_nonNumber_throws3() throws Throwable {
        makeCalc().add("2, c");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_negative_throws1() throws Throwable {
        makeCalc().add("-1");
    }


    @Test
    public void add_negative_throws0() throws Throwable {
        StringCalculator stringCalculator = makeCalc();

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
        StringCalculator sc = makeCalc();

        int result = sc.parse("");

        assertEquals( 0, result );
    }

    @Test
    public void parse_singleNumber_returnsSameNumber() {
        StringCalculator sc = makeCalc();

        int result = sc.parse("1");

        assertEquals(1, result);

    }

    @Test
    public void parse_singleNumber2_returnsNumber2() {
        StringCalculator sc = makeCalc();

        int result = sc.parse("8");

        assertEquals(8, result);
    }

    @Test
    public void subtract_twoSimpleNumbers_subtractsThem() {
        StringCalculator sc = makeCalc();

        int result = sc.subtract(1, 2);

        assertEquals( 1, result);
    }



}

