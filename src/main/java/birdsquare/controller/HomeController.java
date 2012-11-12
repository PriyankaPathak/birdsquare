package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Location;
import birdsquare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private BirdSquareSession birdSquareSession;


    @Autowired
    public HomeController(BirdSquareSession birdSquareSession) {
        this.birdSquareSession = birdSquareSession;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@CookieValue("fbuid") String fbuid,Model model) {
        model.addAttribute("points", getUserPoints(fbuid));
        return "home/home";
    }

    private int getUserPoints(String fbuid) {
        User currentUser = (User) birdSquareSession.get(User.class,fbuid);
        int points;
        if(currentUser == null)
            points = 0;
        else
            points = currentUser.getPoints();
        return points;
    }

    @RequestMapping(value = "/home")
    public String home(@CookieValue("fbuid") String fbuid,Model model) {
        model.addAttribute("points", getUserPoints(fbuid));
        return "home/home";
    }

    @RequestMapping(value = "/checkinlocations")
    public String checkin(@ModelAttribute("Location") Location location, Model model) {
        model.addAttribute("locationName", location.getName());
        model.addAttribute("latitude", location.getLatitude());
        model.addAttribute("longitude", location.getLongitude());
        return "checkin/checkinlocations";
    }

//    @RequestMapping(value = "/profile")
//    public String profile(Model model) {
//        model.addAttribute("message", "");
//        return "home/home";
//    }
}

