package birdsquare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {


    @RequestMapping(value = "/login")
    public String home(Model model){
        model.addAttribute("checkinurl", "checkin");
        return "home/login";
    }
}

