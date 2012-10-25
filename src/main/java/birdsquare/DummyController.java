package main.java.birdsquare;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DummyController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", "Hello world!");

        return "index";
    }

    @RequestMapping(value = "/dummypage", method = RequestMethod.POST)
    public String dummypage(Model model) {

        model.addAttribute("birdname", "Pigeon");
        model.addAttribute("weight", "2 lbs");
        model.addAttribute("message", "Hello bird world!");

        return "dummypage";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){

        model.addAttribute("user", "John Doe");

        return "home";
    }



}
