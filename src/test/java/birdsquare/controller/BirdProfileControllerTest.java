package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Bird;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static junit.framework.Assert.assertEquals;

public class BirdProfileControllerTest{
    private MockHttpServletResponse response;
    private MockHttpServletRequest request;
    private BirdProfileController controller;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private BirdSquareSession session;


    @Before
    public void setup(){
        session = new BirdSquareSession();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new BirdProfileController(session);


    }
    @Test
    public void shouldRedirectToBirdProfilePage() throws Exception {
        long id = 2;
        Bird expectedBird = (Bird) session.get(Bird.class, id);
        request.setRequestURI("/birdprofile/2");
        request.setMethod("GET");
        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertEquals("birdprofile/birdprofile",mav.getViewName());
        ModelMap modelMap = mav.getModelMap();
        assertEquals(expectedBird.getCommon_name(),modelMap.get("birdname"));
        assertEquals(expectedBird.getScientific_name(),modelMap.get("scientificname"));
        assertEquals(expectedBird.getFamily_name(),modelMap.get("familyname"));
        assertEquals(expectedBird.getOrder_name(), modelMap.get("ordername"));
        assertEquals(expectedBird.getImage_url(),modelMap.get("linkToBirdImage"));
    }
}
