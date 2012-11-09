package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Checkin;
import org.hibernate.SQLQuery;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

public class BirdCheckinControllerTest {
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private BirdCheckinController controller;

    @Mock
    private BirdSquareSession birdSquareSession;
    private SQLQuery sqlQuery;

    @Before
    public void setUp() {
        initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        controller = new BirdCheckinController(birdSquareSession);
    }

    @Ignore
    @Test
    public void shouldRenderProfilePage() throws Exception {
        request.setRequestURI("/profilesuccess");
        request.setMethod("POST");
        request.setParameter("birdName","Lerwa lerwa");

        List<Object> fakeSQLQueryList = new ArrayList<Object>();
        fakeSQLQueryList.add(1);

        when(birdSquareSession.createSQLQuery(anyString())).thenReturn(sqlQuery);

        when(sqlQuery.list()).thenReturn(fakeSQLQueryList);

        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
//        Mockito.verify(birdSquareSession, times(1).retrieveResultFromSQLQuery(sqlQuery));
        assertViewName(mav, "profile/profile");
    }

    @Test
    public void shouldRenderBirdCheckinPage() throws Exception {
        request.setRequestURI("/checkinform");
        request.setMethod("POST");
        final ModelAndView mav = handlerAdapter.handle(request, response, controller);
        assertViewName(mav, "checkin/checkinform");
    }

    @Ignore
    @Test
    public void verifyThatBirdInformationGetsSavedOnCheckIn() throws Exception {
        Checkin checkin = new Checkin();
//        checkin.setBirdId(1);
        controller.retrieveBirdNameFromUserAndRedirectToProfilePage(checkin, new ExtendedModelMap(), "Lerwa lerwa");
        Mockito.verify(birdSquareSession, times(1)).save(checkin);
    }
}
