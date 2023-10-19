package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import pl.edu.agh.logger.ConsoleMessageSerializer;
import pl.edu.agh.logger.FileMessageSerializer;
import pl.edu.agh.logger.IMessageSerializer;
import pl.edu.agh.logger.Logger;
import pl.edu.agh.school.persistence.IPersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

// IoC container
public class SchoolModule extends AbstractModule {

    @Override
    public void configure() {
        bind(IPersistenceManager.class).to(SerializablePersistenceManager.class);
        bind(String.class).annotatedWith(Names.named("teachers")).toInstance("guice-teachers.dat");
        bind(String.class).annotatedWith(Names.named("class")).toInstance("guice-class.dat");
        bind(Logger.class).in(Singleton.class);
        Multibinder<IMessageSerializer> messageBinder = Multibinder.newSetBinder(binder(), IMessageSerializer.class);
        messageBinder.addBinding().toInstance(new FileMessageSerializer("persistence.log"));
        messageBinder.addBinding().to(ConsoleMessageSerializer.class);
    }
}
