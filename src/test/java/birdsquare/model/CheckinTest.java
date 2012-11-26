package birdsquare.model;

import birdsquare.helper.BirdSquareSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckinTest {

    private Checkin checkin;

    @Before
    public void setUp() {
        checkin = createCheckin();
    }

    @Test
    public void shouldSetTodayAsTheDateOfCheckIn() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(dateFormat.format(new Date()), dateFormat.format(checkin.getDate()));
        System.out.println(checkin.getDate());
    }

    @Test
    public void shouldReturnANonEmptyListOfBirdDetails() {
        List<String> listOfBirds = checkin.getBirdNameList(new BirdSquareSession());
        Assert.notEmpty(listOfBirds);
    }

    private Checkin createCheckin() {
        Checkin checkin = new Checkin();
        checkin.setBirdId(1);
        checkin.setNumber(16);
        return checkin;
    }
}
