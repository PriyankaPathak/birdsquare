package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckinIT {

    private BirdSquareSession birdSquareSession;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
    }

    @Test
    public void shouldSaveCheckInModelToTheDB() throws Exception {
        Checkin persistedCheckin = new Checkin();
        persistedCheckin.setBirdName("foobar");
        persistedCheckin.setNumber(16);
        birdSquareSession.saveOrUpdate(persistedCheckin);

        Checkin loadedCheckIn = (Checkin) birdSquareSession.get(Checkin.class, persistedCheckin.getId());
        assertEquals(persistedCheckin.getBirdName(), loadedCheckIn.getBirdName());
        assertEquals(persistedCheckin.getNumber(), loadedCheckIn.getNumber());
        birdSquareSession.delete(persistedCheckin);
    }

    @After
    public void tearDown() {
        birdSquareSession.close();
    }
}
