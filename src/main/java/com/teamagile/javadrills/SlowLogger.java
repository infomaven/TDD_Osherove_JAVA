package com.teamagile.javadrills;

public class SlowLogger implements Logger {
    public String logEntry;

// todo: determine if SlowLogger and SlowWebService belong in main (or if they should go to test directory)

    public void write(String text) throws InterruptedException {
        this.logEntry = text;
        Thread.sleep(8000);
    }

    @Override
    public void writeMessage(TraceMessage msg) {

    }
}
