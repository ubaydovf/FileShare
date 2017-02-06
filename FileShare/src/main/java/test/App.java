package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * Created by firdavs on 05/02/17.
 */
public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;


    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(String msg, EventType type, Event event) throws IOException {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
            msg = msg.replaceAll(String.valueOf(client.getId()),client.getFullName());
            event.setMessage(msg);
        } else {
            msg = msg.replaceAll(String.valueOf(client.getId()),client.getFullName());
            event.setMessage(msg);
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean(App.class);

        Event event = ctx.getBean(Event.class);
        app.logEvent("Some event for 1", EventType.INFO, event);

        event = ctx.getBean(Event.class);
        app.logEvent("One more event for 1", EventType.INFO, event);

        event = ctx.getBean(Event.class);
        app.logEvent("And one more event for 1", EventType.INFO, event);

        event = ctx.getBean(Event.class);
        app.logEvent("Some event for 2", EventType.ERROR, event);

        event = ctx.getBean(Event.class);
        app.logEvent("Some event for 3", null, event);

        ctx.close();
    }
}
