package lk.ijse.javaFX.config;

import lk.ijse.javaFX.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    public static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(CourseEnrollment.class);
        configuration.addAnnotatedClass(Instructors.class);
        configuration.addAnnotatedClass(Lessons.class);
        configuration.addAnnotatedClass(Payments.class);
        configuration.addAnnotatedClass(Students.class);
        configuration.addAnnotatedClass(Users.class);

        // create session factory object
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ?
                factoryConfiguration = new FactoryConfiguration() :
                factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();

    }

    public Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }
}
