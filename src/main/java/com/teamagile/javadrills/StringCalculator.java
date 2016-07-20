package com.teamagile.javadrills;

import java.util.Date;

public class StringCalculator {

    /**
     * Method parses a String list of numbers, converts to numerical and performs the math.
     * No support for adding negative numbers
     * @param numbers
     * @return
     * @throws Throwable
     */
    public int add(String numbers) throws Throwable {
        if (numbers.contains("-")) {
            throw new IllegalArgumentException("no negative input allowed");
        }
        if (isEmptyInput(numbers)) {
            return defaultValue();
        }

        if (isSingleNumber(numbers))
            return parseSingleNumber(numbers);

        // todo: add()  needs to work for 2 or more numbers in a String

/// todo: replace hard-coded value with the calculated value
        return 3;
    }

    public String GetMessageWithDate() {
        return getTime() + " some message";
    }

    protected  long getTime() {
        return new Date().getTime();
    }

    private boolean isSingleNumber(String numbers) {
        return !isMultipleNumbers(numbers);
    }

    private int parseSingleNumber(String numbers) {
        return Integer.parseInt(numbers);
    }

    private boolean isMultipleNumbers(String numbers) {
        return numbers.contains(",");
    }

    private int defaultValue() {
        return 0;
    }

    private boolean isEmptyInput(String numbers) {
        return numbers.length()==0;
    }

    public int subtract(int howMuch, int from) {
        return from - howMuch;
    }

    public int parse(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        return Integer.parseInt(numbers);
    }
}
