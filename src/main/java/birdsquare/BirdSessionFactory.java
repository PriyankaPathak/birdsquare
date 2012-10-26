package main.java.birdsquare;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BirdSessionFactory {
    private static SessionFactory ourSessionFactory;

    static
    {
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(new Configuration().addResource("hibernate.cfg.xml").configure().getProperties())
                .buildServiceRegistry();

        ourSessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
    }

    public static Session createSession()
    {
       return ourSessionFactory.openSession();
    }



}
