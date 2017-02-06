package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by firdavs on 05/02/17.
 */
public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String filename) {
        super(filename);
    }

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if(cache.size() == cacheSize) {
            System.out.println("Заполнен cache");
            writeEventFromCache();
            System.out.print("Кэш записан ");
            cache.clear();
            System.out.println("и очищен");
        }
    }

    private void writeEventFromCache() throws IOException {
        for (int i = 0; i < cache.size(); i++) {
            super.logEvent(cache.get(i));
        }
    }
    public void destroy() throws IOException {
        System.out.println("Destroy Called");

        if ( !cache.isEmpty() ) {
            System.out.println("We are inside");
            writeEventFromCache();
            System.out.println("We are out");
        }
    }
    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }
}
