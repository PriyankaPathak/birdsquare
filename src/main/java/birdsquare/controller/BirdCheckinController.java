package birdsquare.controller;

import birdsquare.helper.SimpleDAO;
import birdsquare.model.Checkin;
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
            model.addAttribute("message", checkin.birdname + " check in success!");
            checkin.setDate(new Date());
            putObjectToTable(checkin);

        }
        else
            model.addAttribute("message", "Wrong input");

        return "checkin/status";
    }

    @RequestMapping(value = "/birdcheckin" )
    public String birdcheckin(Model model){

        model.addAttribute("checkinurl", "status");

        return "checkin/birdcheckin";
    }

    private void putObjectToTable(Object object)
    {
        SimpleDAO simpleDAO = new SimpleDAO();
        simpleDAO.save(object);
        simpleDAO.close();
    }
}
