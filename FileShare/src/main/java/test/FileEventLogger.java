package test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by firdavs on 05/02/17.
 */
public class FileEventLogger implements EventLogger{
    String filename;
    File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }
    public void init() throws IOException {
        this.file = new File(filename);
        if (!file.canWrite()) {
            throw new IOException();
        }
    }
    @Override
    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, (event + "\n").toString(), true);
    }
}
