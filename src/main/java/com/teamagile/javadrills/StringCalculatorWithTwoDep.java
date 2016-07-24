package com.teamagile.javadrills;

public class StringCalculatorWithTwoDep {

    private Logger log;
    private WebService service;

    public StringCalculatorWithTwoDep( Logger logger, WebService webService) {
        this.log     = logger;
        this.service = webService;
    }

    public int add(String numbers) throws Throwable {
        log.writeMessage(new TraceMessage(100, "message"));
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
                return result;

            } else {
                try {
                    operandOne = Integer.valueOf(equation[0]);
                    operandTwo = Integer.valueOf(equation[1]);
                    result = operandOne + operandTwo;
                    notifyLogger(result);
                    return result;
                } catch (NumberFormatException ex) {
                    this.log.write("Number Format Exception - one or more non-numbers found");
                    throw new NumberFormatException("number format error");
                }
            }
        }
    }


    private boolean isSingleNumber(String numbers) {
        return !isMultipleNumbers(numbers);
    }

    private int parseSingleNumber(String numbers) throws Throwable {
        int result = Integer.parseInt( numbers );
        notifyLogger( result);
        return Integer.parseInt(numbers);
    }

    private void notifyLogger(int result) throws Throwable {
        try {
            this.log.write( "got: " + result );
        } catch (Throwable throwable) {
            service.write( "got: " + throwable.getClass().getName());
        }
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
