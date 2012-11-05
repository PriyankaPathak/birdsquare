package birdsquare.controller;

import birdsquare.model.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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

    @RequestMapping(value = "/search")
    public String search(Model model){
        model.addAttribute("checkinurl", "birdcheckin");
        return "search/search";
    }

    @RequestMapping(value = "/profile")
    public String profile(Model model){
        model.addAttribute("checkinurl", "checkin");
        return "profile/profile";
    }


}

