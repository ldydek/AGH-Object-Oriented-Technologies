package pl.edu.agh.school;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;
import pl.edu.agh.logger.Logger;
import pl.edu.agh.school.guice.SchoolModule;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolModuleTest {

    private final Injector injector = Guice.createInjector(new SchoolModule());

    @Test
    public void testLoggerSingleton() {
        Logger logger = injector.getInstance(Logger.class);
        assertEquals(logger, injector.getInstance(Logger.class));
    }
}
