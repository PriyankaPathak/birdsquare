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
    private Checkin checkinBefor7Days;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
        checkin = createCheckin();
        birdSquareSession.saveOrUpdate(checkin);
    }

    @After
    public void tearDown() {
        birdSquareSession.delete(checkin);
        birdSquareSession.close();
    }

    @Test
    public void shouldSaveCheckInModelToTheDB() throws Exception {

        Checkin loadedCheckIn = (Checkin) birdSquareSession.get(Checkin.class, checkin.getId());
        assertEquals(checkin.getBirdID(), loadedCheckIn.getBirdID());
        assertEquals(checkin.getNumber(), loadedCheckIn.getNumber());
        assertEquals(checkin.getDate(), loadedCheckIn.getDate());
        assertNotNull(loadedCheckIn.getDate());
    }

    @Test
    public void shouldReturnPointsForAParticularUserOfLast7Days() throws ParseException {
        checkinBefor7Days = createCheckinInstance7DaysBefore();
        birdSquareSession.saveOrUpdate(checkinBefor7Days);
        String id = "1111";
        int count = birdSquareSession.getPointsForLastSevenDays(id);
        System.out.println(checkin.getDate());
        System.out.println(checkinBefor7Days.getDate());
        assertEquals(1,count);
        birdSquareSession.delete(checkinBefor7Days);
    }

    private Checkin createCheckinInstance7DaysBefore() {
        Checkin checkin = new Checkin();
        checkin.setBirdId(1);
        checkin.setNumber(16);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE,-8);
        Date date = calendar.getTime();
        checkin.setDate(date);
        checkin.setFbuid("1111");
        return checkin;
    }

    private Checkin createCheckin() {
        Checkin checkin1=new Checkin();
        checkin1.setBirdId(2);
        checkin1.setNumber(2);
        checkin1.setFbuid("1111");
        return checkin1;
    }
}
