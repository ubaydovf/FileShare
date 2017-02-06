package test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by firdavs on 05/02/17.
 */
public class CombinedEventLogger implements EventLogger {
    Collection<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }

    }
}
