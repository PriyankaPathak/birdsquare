package birdsquare.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BirdInformationTest {

    @Test
    public void shouldReturnBirdName(){
        BirdInformation newBird = new BirdInformation("Ashwin", 1, "Bangalore", "I love Bangalore");
        assertThat(newBird.getBirdname(), is("Ashwin"));
    }

}
