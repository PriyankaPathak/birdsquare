package birdsquare.controller;

import birdsquare.model.Checkin;
import birdsquare.model.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String checkin(@ModelAttribute("Location") Location location ,Model model){
        model.addAttribute("checkinurl", "birdcheckin");
        model.addAttribute("locationname",location.getLocationname());
        model.addAttribute("latitude",location.getLatitude());
        model.addAttribute("longitude",location.getLongitude());
       return "checkin/checkin";
    }

    @RequestMapping(value = "/checkinsuccess")
    public String checkinsuccess(){
        return "checkin/checkinsuccess";
    }
}

