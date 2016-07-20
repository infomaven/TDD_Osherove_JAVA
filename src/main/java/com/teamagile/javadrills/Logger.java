package com.teamagile.javadrills;

/**
 * Created by nadine on 7/19/16.
 */
public interface Logger {

    public void write( String text ) throws Throwable;

    void writeMessage( TraceMessage msg );
}
