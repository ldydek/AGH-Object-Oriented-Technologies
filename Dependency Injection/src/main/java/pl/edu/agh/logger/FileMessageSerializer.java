package pl.edu.agh.logger;

import com.google.inject.Inject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileMessageSerializer implements IMessageSerializer {

    private final Writer output;

    @Inject
    public FileMessageSerializer(String filename) {
        try {
            output = new BufferedWriter(new FileWriter(filename, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void serializeMessage(String message) {
        try  {
            output.write(message + "\n");
            output.flush();
        } catch (IOException e) {
            System.err.println("FileMessageSerializer error: " + e.getMessage());
        }
    }
}
