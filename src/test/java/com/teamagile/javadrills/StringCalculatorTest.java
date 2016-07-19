package com.teamagile.javadrills;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class StringCalculatorTest{

    private StringCalculator makeCalc() {
        return new StringCalculator();
    }

    private void assertAdding(String numbers, int expected) {
        StringCalculator sc = makeCalc();

        int result = sc.add(numbers);

        assertEquals(expected, result);
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void add_negative_throws2() {
        StringCalculator calc = makeCalc();

        thrown.expect(IllegalArgumentException.class);
        calc.add("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_negative_throws1() {
        makeCalc().add("-1");
    }


    @Test
    public void add_negative_throws0() {
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
    public void add_multipleNumbers_returnstheSum(){
        assertAdding("1,2", 3);
    }

    @Test
    public void add_singleNumber_returnsThatNumber(){
        assertAdding("1", 1);
    }



    @Test
    public void add_emptyString_returnsZero(){
        assertAdding("",0);
    }

    /*
    drills:
    1. Feature: String Calculator Logging
In order to easily debug the results the a user is getting
as developers
we want to have logging enabled for the string calculator
we will only use HAND WRITTEN mocks (no framework)

Scenario: Adding a number
Given a string calculator
And a slow logger instance
When the string calculator add method is called with input “1,2”
Then slow logger should be notified with “got3”

Scenario: Failed Logging
Given a string calculator
And a slow logger instance
And a web service instance
And calling logger results in an error ‘fakeerror’
When the string calculator add method is called with input “1,2” Then the web service should be notified with “got‘fakeerror’”

     */
}

