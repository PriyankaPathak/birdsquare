package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckinIT {

    private BirdSquareSession birdSquareSession;
    private Checkin checkin;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
        checkin = createCheckin();
    }

    @After
    public void tearDown() {
        birdSquareSession.delete(checkin);
        birdSquareSession.close();
    }

    @Test
    public void shouldSaveCheckInModelToTheDB() throws Exception {
        birdSquareSession.saveOrUpdate(checkin);

        Checkin loadedCheckIn = (Checkin) birdSquareSession.get(Checkin.class, checkin.getId());
     ///   assertEquals(checkin.getBirdName(), loadedCheckIn.getBirdName());
        assertEquals(checkin.getNumber(), loadedCheckIn.getNumber());
        assertNotNull(loadedCheckIn.getDate());
    }

    private Checkin createCheckin() {
        Checkin checkin = new Checkin();
        checkin.setBirdId(1);
        checkin.setNumber(16);
        return checkin;
    }
}
