package birdsquare.model;

import birdsquare.helper.SimpleDAO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckinIT {

    private SimpleDAO simpleDAO;

    @Before
    public void setUp() {
        simpleDAO = new SimpleDAO();
    }

    @Test
    public void shouldSaveCheckInModelToTheDB() throws Exception {
        Checkin persistedCheckin = new Checkin();
        persistedCheckin.setBirdname("foobar");
        persistedCheckin.setNumber(16);
        simpleDAO.saveOrUpdate(persistedCheckin);

        Checkin loadedCheckIn = (Checkin) simpleDAO.get(Checkin.class, persistedCheckin.getId());
        assertEquals(persistedCheckin.getBirdname(), loadedCheckIn.getBirdname());
        assertEquals(persistedCheckin.getNumber(), loadedCheckIn.getNumber());
        simpleDAO.delete(persistedCheckin);
        simpleDAO.close();
    }
}
