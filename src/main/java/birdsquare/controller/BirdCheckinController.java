package birdsquare.controller;

import birdsquare.helper.BirdSessionFactory;
import birdsquare.model.Checkin;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class BirdCheckinController {

    @RequestMapping(value = "/status")
    public String retrieveBirdNameFromUserAndRedirectToStatusPage(@ModelAttribute("Checkin") Checkin checkin,Model model) {

        model.addAttribute("checkinurl", "birdcheckin");

        if (null != checkin &&
                null != checkin.getBirdname()) {
            model.addAttribute("message", checkin.birdname+" check in success!");
            checkin.setDate(new Date());
            putObjectToTable(checkin);

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

    @RequestMapping(value = "/birdcheckin" )
    public String birdcheckin(Model model){

        model.addAttribute("checkinurl", "status");

        return "checkin/birdcheckin";
    }
}
