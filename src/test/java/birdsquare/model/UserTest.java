package birdsquare.model;

import junit.framework.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void shouldIncrementAPointForACheckin()
    {
        User user=new User();
        user.setPoints(1);
        user.incrementPointsByOne();
        Assert.assertEquals(2,user.getPoints());
    }
}
