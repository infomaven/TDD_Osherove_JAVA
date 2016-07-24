package com.teamagile.javadrills;

public class StringCalculatorWithOneDep {

    private Logger log;

    public StringCalculatorWithOneDep( Logger logger ) {
        this.log  = logger;

    }

    public int add(String numbers) throws Throwable {
        int result = 0;
        int operandOne = 0;
        int operandTwo = 0;

        if (numbers.contains("-")) {
            this.log.write("Illegal Argument found - no negatives");
            throw new IllegalArgumentException("no negatives");
        }
        if (isEmptyInput(numbers)) {
            result = defaultValue();
            this.log.write("got: " + result);
            return result;
        }
        // try to process as numbers
        else {
            String[] equation = numbers.split(",");
            if (equation.length == 1) {
                result = parseSingleNumber(numbers);
                this.log.write("got: " + result);
                return result;
            } else {
                try {
                    operandOne = Integer.valueOf(equation[0]);
                    operandTwo = Integer.valueOf(equation[1]);
                    result = operandOne + operandTwo;
                    this.log.write("got: " + String.valueOf(result));
                    return result;
                } catch (NumberFormatException ex) {
                    this.log.write("Number Format Exception - one or more non-numbers found");
                    throw new NumberFormatException("number format error");
                }
            }
        }

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
