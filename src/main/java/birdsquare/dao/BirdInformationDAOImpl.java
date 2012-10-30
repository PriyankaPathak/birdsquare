package birdsquare.dao;

import birdsquare.model.BirdInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
public class BirdInformationDAOImpl implements BirdInformationDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public BirdInformationDAOImpl(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    @Transactional
    public void save(BirdInformation birdInformation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.persist(birdInformation);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
