package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.servlet.http.Cookie;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class HomeControllerTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private HomeController controller;

    @Mock
    private BirdSquareSession birdSquareSession;

    @Before
    public void setUp() {
        initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new HomeController(birdSquareSession);
    }

    @Test
    public void shouldRenderHomePageAsLandingPage() throws Exception {
        request.setRequestURI("/");
        request.setCookies(new Cookie("fbuid", "fbUserId"));

        request.setMethod("GET");

        when(birdSquareSession.get(eq(User.class), anyString())).thenReturn(null);
        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/home");
    }

    @Test
    public void shouldRenderHomePageAfterClickingHomeButton() throws Exception {
        request.setRequestURI("/home");
        request.setCookies(new Cookie("fbuid", "fbUserId"));
        when(birdSquareSession.get(eq(User.class),anyString())).thenReturn(null);

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "home/home");
    }

    @Test
    public void shouldRenderCheckInPageAfterClickingCheckInButtonFromHomePage() throws Exception {
        request.setRequestURI("/checkinlocations");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "checkin/checkinlocations");
    }
}