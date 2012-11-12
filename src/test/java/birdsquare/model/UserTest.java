package birdsquare.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldIncrementAPointForACheckin()
    {
        User user=new User();
        user.setPoints(1);
        user.incrementPointsByOne();
        assertEquals(2, user.getPoints());
    }
}
