package com.teamagile.javadrills;

public class StringCalculatorWithOneDep {

    private Logger log;

    public StringCalculatorWithOneDep( Logger logger ) {
        this.log  = logger;

    }



    // todo: add logic to handle comma delimited list of two numbers
    
    public int add(String numbers) throws Throwable {
        int result = 0;

        if (numbers.contains("-")) {
            this.log.write("Illegal Argument found - no negatives");
            throw new IllegalArgumentException("no negatives");
        }
        if (isEmptyInput(numbers)) {
            result = defaultValue();
            this.log.write("got: " + result);
            return result;
        }

        if (isSingleNumber(numbers)) {
            result = parseSingleNumber(numbers);
            this.log.write("got: " + String.valueOf(result));
            return result;
        }

        return result;
    }

    private boolean isSingleNumber(String numbers) {
        return !isMultipleNumbers(numbers);
    }

    // operates on one string operand at a time
    private int parseSingleNumber(String numbers) {
       // int result = Integer.parseInt( numbers );
        int result = parse(numbers);
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
