package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckinIT {

    private BirdSquareSession birdSquareSession;
    private Checkin checkin;
    private Checkin checkin2;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
        checkin = createCheckin();
        checkin2=createCheckin1();
    }

    @After
    public void tearDown() {
        birdSquareSession.delete(checkin);
        birdSquareSession.delete(checkin2);
        birdSquareSession.close();
    }

    @Test
    public void shouldSaveCheckInModelToTheDB() throws Exception {
        birdSquareSession.saveOrUpdate(checkin);

        Checkin loadedCheckIn = (Checkin) birdSquareSession.get(Checkin.class, checkin.getId());
        assertEquals(checkin.getBirdID(), loadedCheckIn.getBirdID());
        assertEquals(checkin.getNumber(), loadedCheckIn.getNumber());
        assertEquals(checkin.getDate(), loadedCheckIn.getDate());
        assertNotNull(loadedCheckIn.getDate());
    }

    @Test
    public void shouldReturnPointsForAParticularUser() throws ParseException {
        birdSquareSession.saveOrUpdate(checkin);
        birdSquareSession.saveOrUpdate(checkin2);
        String id = "1111";
        int count = birdSquareSession.getPointsForLastSevenDays(id);
        assertEquals(2,count);
    }

    private Checkin createCheckin1() {
        Checkin checkin1=new Checkin();
        checkin1.setBirdId(2);
        checkin1.setNumber(2);
        checkin1.setFbuid("1111");
        return checkin1;
    }

    private Checkin createCheckin() {
        Checkin checkin = new Checkin();
        checkin.setBirdId(1);
        checkin.setNumber(16);
        checkin.setFbuid("1111");
        return checkin;
    }
}
