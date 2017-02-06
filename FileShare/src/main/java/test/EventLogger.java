package test;

import java.io.IOException;

/**
 * Created by firdavs on 05/02/17.
 */
public interface EventLogger {
    void logEvent(Event event) throws IOException;
}

