package com.teamagile.javadrills;

/**
 * Created by nadine on 7/19/16.
 * Mock object / Stub for testing Log dependency
 * Configurable delay for different test scenarios
 */
 class FakeLogger implements Logger {

    public String logEntry;
    private Throwable toThrow;
    private int delay;

    public FakeLogger() {
        this.delay = 0;
    }

    public FakeLogger( int logDelay ) {
        this.delay = logDelay;
    }

    public void writeMessage(TraceMessage text) {
    }

    public void write(String text) throws Throwable {
        this.logEntry = text;
        if (toThrow != null) {
            throw toThrow;
        }

    }

    public void willThrow( Throwable throwable ) {
        toThrow = throwable;
    }
}
