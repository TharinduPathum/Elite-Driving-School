package lk.ijse.javaFX.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure(); // loads hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ?
                (factoryConfiguration = new FactoryConfiguration()) :
                factoryConfiguration;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
