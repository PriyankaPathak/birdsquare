package birdsquare.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BirdSessionFactory {
    private SessionFactory ourSessionFactory ;

    private static BirdSessionFactory birdSessionFactory = new BirdSessionFactory();
    private BirdSessionFactory() {
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(new Configuration().addResource("hibernate.cfg.xml").configure().getProperties())
                .buildServiceRegistry();

        ourSessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
    }

    public static BirdSessionFactory getInstance()
    {
        return birdSessionFactory;
    }

    public synchronized Session createSession() {
        return ourSessionFactory.openSession();
    }
}
