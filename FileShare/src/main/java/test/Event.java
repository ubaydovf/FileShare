package test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by firdavs on 05/02/17.
 */
public class Event {
    private long id;
    private String message;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
        this.id = new Random().nextLong();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Date: " + df.format(date) + " Message: " + message;
    }
}
