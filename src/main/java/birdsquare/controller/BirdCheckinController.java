package birdsquare.controller;

import birdsquare.helper.BirdSessionFactory;
import birdsquare.model.BirdInformation;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class BirdCheckinController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String retrieveBirdNameFromUserAndRedirectToStatusPage(@ModelAttribute("birdinformation") BirdInformation birdinformation,Model model) {

        model.addAttribute("checkinurl", "home");

        if (null != birdinformation &&
                null != birdinformation.getBirdname()) {
            model.addAttribute("message", birdinformation.birdname+" check in success!");
            birdinformation.setDate(new Date());
            putObjectToTable(birdinformation);
        }
        else
            model.addAttribute("message", "Wrong input");

        return "checkin/status";
    }

    private void putObjectToTable(Object object)
    {

        final Session session = BirdSessionFactory.getInstance().createSession();
        session.beginTransaction();

        session.saveOrUpdate(object);

        session.getTransaction().commit();
        session.close();

    }

    @RequestMapping(value = "/birdcheckin")
    public String birdcheckin(Model model){

        model.addAttribute("checkinurl", "status");

        return "checkin/birdcheckin";
    }


}