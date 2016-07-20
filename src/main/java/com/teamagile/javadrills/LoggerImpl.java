package com.teamagile.javadrills;

/**
 * Created by nadine on 7/19/16.
 */
public class LoggerImpl implements  Logger {

    public void writeMessage(TraceMessage msgText ) {

    }

    public void write( String text) throws InterruptedException {
        Thread.sleep( 3000 );
    }
}
