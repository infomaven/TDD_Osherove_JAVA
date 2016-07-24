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
        int operandOne = 0;
        int operandTwo = 0;
        int result = 0;

        if (numbers.contains("-"))
            throw new IllegalArgumentException("no negative input allowed");

        if (isEmptyInput(numbers))
            return defaultValue();


        else {
            String[] equation = numbers.split(",");
            if ( equation.length == 1) {
                result = parseSingleNumber(numbers);
                return result;
            }
            try {
                operandOne = Integer.valueOf(equation[0]);
                operandTwo = Integer.valueOf(equation[1]);
                result = operandOne + operandTwo;
                return result;
            } catch (NumberFormatException ex) {
                throw new NumberFormatException("number format error");
            }
        }
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
