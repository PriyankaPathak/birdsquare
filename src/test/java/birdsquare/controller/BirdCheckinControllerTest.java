package birdsquare.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class BirdCheckinControllerTest {
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private BirdCheckinController controller;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new BirdCheckinController();
    }

    @Test
    public void shouldRenderStatusPage() throws Exception {
        request.setRequestURI("/status");
        request.setMethod("POST");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "checkin/status");
    }

    @Test
    public void shouldRenderBirdCheckinPage() throws Exception {
        request.setRequestURI("/birdcheckin");
        request.setMethod("GET");
        request.setParameter("name", "Priyanka");
        request.setParameter("lat", "12");
        request.setParameter("lng", "14");


        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "checkin/birdcheckin");
    }
}
