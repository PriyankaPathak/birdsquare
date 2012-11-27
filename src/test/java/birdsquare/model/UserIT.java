package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.hibernate.Criteria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    public void shouldBeAbleToAddAPointForAUserGivenAnID() {
        User loadedUser = (User) birdSquareSession.get(User.class, persistedUser.getId());
        loadedUser.incrementPointsByOne();
        birdSquareSession.save(loadedUser);
        assertEquals(8, persistedUser.getPoints());
    }

    @Test
    public void shouldReturnMaximumPointsAmongUsers(){
        int maxPoints = birdSquareSession.maximumPointsAmongUsers();
        List userList = birdSquareSession.getCorrespondingColumnAccordingToFilter(User.class, "points");
        int maxPointsInDB = getMaxUserPointsFromDB(userList);
        assertThat(maxPointsInDB,is(maxPoints));
    }

    private int getMaxUserPointsFromDB(List userList) {
        int maxPointsInDB = 0;
        for(Object userPoints:userList){
            if((Integer)userPoints>maxPointsInDB){
                maxPointsInDB=(Integer)userPoints;
            }
        }
        return maxPointsInDB;
    }

    @After
    public void tearDown() {
        birdSquareSession.delete(persistedUser);
    }
}
