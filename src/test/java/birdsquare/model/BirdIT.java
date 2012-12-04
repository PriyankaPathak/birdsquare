package birdsquare.model;

import birdsquare.functional.framework.TestData;
import birdsquare.helper.BirdSquareSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BirdIT {

    private BirdSquareSession birdSquareSession;

    @Before
    public void setUp() {
        birdSquareSession = new BirdSquareSession();
    }

    @Test
    public void shouldLoadAllBirds() throws Exception {
        List allBirds = birdSquareSession.getAll(Bird.class);
        assertTrue(allBirds.size() > 0);
    }
    @Test
    public void shouldGetBirdIDAccordingToName(){
        List birds = birdSquareSession.getCorrespondingRowAccordingToFilterSet(Bird.class,"Lerwa lerwa","scientific_name");
        for (Object bird:birds){
            assertEquals(((Bird)bird).getId(),1);
        }
    }
    @Test
    public void testImageUrl(){
        long id =4;
        Bird bird = (Bird) birdSquareSession.get(Bird.class,id);
        System.out.println(bird.getImage_url());
    }
}
