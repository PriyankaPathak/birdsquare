package birdsquare;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.inject.Inject;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class DummyControllerTest {

    @Inject
    private ApplicationContext applicationContext;

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
    public void shouldRenderIndex() throws Exception {

        request.setRequestURI("/index.html");
        request.setMethod("GET");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "index");
    }

    @Test
    public void testDummyPage() throws Exception {

        request.setRequestURI("/dummypage.html");
        request.setMethod("POST");

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "dummypage");

    }
}