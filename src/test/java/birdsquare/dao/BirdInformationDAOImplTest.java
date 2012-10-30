package birdsquare.dao;

import birdsquare.model.BirdInformation;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.mockito.Mockito.*;

public class BirdInformationDAOImplTest {
    private EntityManagerFactory mockEntityManagerFactory;
    private EntityManager mockEntityManager;
    BirdInformation birdInformation;
    private BirdInformationDAOImpl birdInformationDao;

    @Before
    public void setUp() {
        birdInformation = new BirdInformation("Kingfisher", 2, "Aleppy", "Blue Bird");
        mockEntityManagerFactory = mock(EntityManagerFactory.class);
        mockEntityManager = mock(EntityManager.class);
        when(mockEntityManagerFactory.createEntityManager()).thenReturn(mockEntityManager);
        birdInformationDao = new BirdInformationDAOImpl(mockEntityManagerFactory);
    }

    @Test
    public void shouldCallPersistOnEntityManager() throws Exception {
        birdInformationDao.save(birdInformation);
        verify(mockEntityManager).persist(birdInformation);
    }

    @Test
    public void shouldCallCloseOnEntityManager() {
        birdInformationDao.save(birdInformation);
        verify(mockEntityManager).close();
    }
}
