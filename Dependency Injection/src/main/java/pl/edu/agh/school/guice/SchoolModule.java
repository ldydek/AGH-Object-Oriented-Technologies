package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

// IoC container
public class SchoolModule extends AbstractModule {

    @Override
    public void configure() {
        bind(IPersistenceManager.class).to(SerializablePersistenceManager.class);
    }
}
