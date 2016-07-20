package com.teamagile.javadrills;

/**
 * Created by nadine on 7/19/16.
 */
public class TraceMessage {

    public final int severity;
    public final String message;

    public TraceMessage( int severity, String message) {
        this.severity = severity;
        this.message = message;
    }
}
