package birdsquare.model;

import birdsquare.helper.BirdSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class BirdInformationTest {

    private SessionFactory sessionFactory;
    private Session session=null;

    @Before
    public void setup(){
        AnnotationConfiguration configuration=new AnnotationConfiguration();
        configuration.addAnnotatedClass(BirdInformation.class);
        configuration.setProperty("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class",
                "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void returnsBirdInformation(){



        BirdInformation birdInformation=new BirdInformation("Pigeon",1,"bangalore","i love birds");

        birdInformation.setDate(new Date());

        session.save(birdInformation);

        Session result=BirdSessionFactory.getInstance().createSession();

        result.getTransaction().commit();





    }
}
