package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Bird;
import birdsquare.model.Checkin;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.servlet.http.Cookie;

import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class BirdCheckinControllerTest {
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private BirdCheckinController controller;

    @Mock
    private BirdSquareSession birdSquareSession;

    @Before
    public void setUp() {
        initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new BirdCheckinController(birdSquareSession);
    }

    @Test
    public void shouldRenderProfilePage() throws Exception {
        request.setRequestURI("/homesuccess");
        request.setMethod("POST");
        request.setParameter("birdName","Lerwa lerwa");
        request.setCookies(new Cookie("fbuid", "fbUserId"));

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/home");
    }

    @Test
    public void shouldRenderBirdCheckinPage() throws Exception {
        request.setRequestURI("/checkinform");
        request.setMethod("POST");
        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "checkin/checkinform");
    }

    @Test
    public void verifyThatBirdInformationGetsSavedOnCheckIn() throws Exception {
        Checkin checkin = new Checkin();

        controller.retrieveBirdNameFromUserAndRedirectToProfilePage(checkin, new ExtendedModelMap(), "Lerwa lerwa", "fbuid");
        Mockito.verify(birdSquareSession, times(1)).save(checkin);
    }

    @Test
    public void verifyThatBirdIDIsBeingRetrievedOnCheckIn() throws Exception {
        Checkin checkin = new Checkin();

        controller.retrieveBirdNameFromUserAndRedirectToProfilePage(checkin, new ExtendedModelMap(), "Lerwa lerwa","fbuid");
        Mockito.verify(birdSquareSession, times(1)).getCorrespondingRowAccordingToFilterSet(Bird.class, "Lerwa lerwa", "scientific_name");
    }
}
