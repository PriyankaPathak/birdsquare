package birdsquare.controller;

import birdsquare.model.Checkin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("checkinurl", "checkin");
        return "home/home";
    }

    @RequestMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("checkinurl", "checkin");
        return "home/home";
    }

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

    @RequestMapping(value = "/checkin")
    public String checkin(@ModelAttribute("Checkin") Checkin checkin ,Model model){
        model.addAttribute("checkinurl", "birdcheckin");
        model.attribute(checkin)
        return "checkin/checkin";
    }

    @RequestMapping(value = "/checkinsuccess")
    public String checkinsuccess(){
        return "checkin/checkinsuccess";
    }
}

