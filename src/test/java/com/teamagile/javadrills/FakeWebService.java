package com.teamagile.javadrills;

/**
 * Created by nadine on 7/19/16.
 * Manual mock or stub class for a downstream dependency
 */
public class FakeWebService implements WebService {

    public String written;

    public void write( String text) {
        written = text;

    }

}
