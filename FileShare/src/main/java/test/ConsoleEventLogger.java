package test;

/**
 * Created by firdavs on 05/02/17.
 */
public class ConsoleEventLogger implements EventLogger{

    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
