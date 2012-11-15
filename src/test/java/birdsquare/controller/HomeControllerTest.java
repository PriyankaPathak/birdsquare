package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Location;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.servlet.http.Cookie;

import static junit.framework.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class HomeControllerTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private HomeController controller;

    @Mock
    private BirdSquareSession mockBirdSquareSession;

    @Before
    public void setUp() {
        initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new HomeController(mockBirdSquareSession);
    }

    @Test
    public void shouldRenderHomePageAsLandingPage() throws Exception {
        request.setRequestURI("/");
        request.setCookies(new Cookie("fbuid", "100004675148203"));
        request.setMethod("GET");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/home");
    }

    @Test
    public void shouldRenderHomePageAfterClickingHomeButton() throws Exception {
        request.setRequestURI("/home");
        request.setCookies(new Cookie("fbuid", "100004675148203"));
        request.setMethod("GET");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/home");
    }

    @Test
    public void shouldRenderCheckInPageAfterClickingCheckInButtonFromHomePage() throws Exception {
        request.setRequestURI("/checkinlocations");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "checkin/checkinlocations");
    }

    @Test
    public void shouldSetLocationToModelMapOnCheckIn() throws Exception {
        ExtendedModelMap model = new ExtendedModelMap();
        Location location = new Location();
        location.setName("TW");

        controller.checkin(location, model);
        assertEquals("TW", model.get("locationName"));
    }
}