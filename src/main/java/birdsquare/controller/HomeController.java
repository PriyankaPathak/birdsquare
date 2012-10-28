package birdsquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String checkin(Model model){

        model.addAttribute("checkinurl", "birdcheckin");

        return "checkin/checkin";
    }

    @RequestMapping(value = "/birdcheckin")
    public String birdcheckin(Model model){

        model.addAttribute("checkinurl", "checkinsuccess");

        return "checkin/birdcheckin";
    }

    @RequestMapping(value = "/checkinsuccess")
    public String checkinsuccess(){

        return "checkin/checkinsuccess";

    }

}

