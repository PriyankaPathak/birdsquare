package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserIT {

    private BirdSquareSession birdSquareSession;
    private User persistedUser;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
        persistedUser = new User();
        persistedUser.setId("123456");
        persistedUser.setPoints(7);
        birdSquareSession.saveOrUpdate(persistedUser);


    }

    @Test
    public void shouldBeAbleToFetchPointsGivenAUserId() throws Exception {

        User loadedUser = (User) birdSquareSession.get(User.class, persistedUser.getId());
        assertEquals(persistedUser.getPoints(), loadedUser.getPoints());
    }


    @Test
    public void shouldBeAbleToAddAPointForAUserGivenAnID()
    {
        User loadedUser = (User) birdSquareSession.get(User.class, persistedUser.getId());
        loadedUser.incrementPointsByOne();
        birdSquareSession.save(loadedUser);
        assertEquals(8,persistedUser.getPoints());

    }

    @After
    public void tearDown()
    {
        birdSquareSession.delete(persistedUser);

    }
}
