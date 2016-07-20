package com.teamagile.javadrills;

public class StringCalculatorWithOneDep {

    private Logger log;

    public StringCalculatorWithOneDep( Logger logger ) {
        this.log  = logger;

    }

    // todo: limit this method to TWO numbers at a time
    
    public int add(String numbers) throws Throwable {
        if (numbers.contains("-")) {
            throw new IllegalArgumentException("no negatives");
        }
        if (isEmptyInput(numbers))
            return defaultValue();

        if (isSingleNumber(numbers))
            return parseSingleNumber(numbers);

        int listLength = numbers.length();
        int firstNum, secondNum, sum;


        // log the sum
        this.log.write("3");

        return 3;
    }

    private boolean isSingleNumber(String numbers) {
        return !isMultipleNumbers(numbers);
    }

    private int parseSingleNumber(String numbers) {
        int result = Integer.parseInt( numbers );
        try {
            this.log.write( "got: " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
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
