package birdsquare;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class DummyControllerIT {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private DummyController controller;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new DummyController();
    }

    @Test
    @Ignore
    public void testDummyPage() throws Exception {
        request.setRequestURI("/dummypage.html");
        request.setMethod("POST");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "dummypage");
    }
}