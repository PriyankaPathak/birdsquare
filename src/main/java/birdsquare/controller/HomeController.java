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

    @RequestMapping(value = "/checkin")
    public String checkin(@ModelAttribute("Checkin") Checkin checkin ,Model model){
        model.addAttribute("checkinurl", "birdcheckin");
        model.addAttribute(checkin);
        return "checkin/checkin";
    }

    @RequestMapping(value = "/checkinsuccess")
    public String checkinsuccess(){
        return "checkin/checkinsuccess";
    }
}

