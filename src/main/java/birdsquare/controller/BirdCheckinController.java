package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Checkin;
import birdsquare.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class BirdCheckinController {

    private BirdSquareSession birdSquareSession;

    @Autowired
    public BirdCheckinController(BirdSquareSession birdSquareSession) {
        this.birdSquareSession = birdSquareSession;
    }

    @RequestMapping(value = "/status", method=RequestMethod.POST)
    public String retrieveBirdNameFromUserAndRedirectToStatusPage(@ModelAttribute("checkin") Checkin checkin, Model model) {

        model.addAttribute("checkinurl", "checkin");

        if (null != checkin && null != checkin.getBirdName()) {
            model.addAttribute("message", "You have checked in " + checkin.number + " " + checkin.birdName + "(s) successfully!");
            checkin.setDate(new Date());
            birdSquareSession.save(checkin);

        } else {
            model.addAttribute("message", "Please fill in all fields");
        }

        return "checkin/status";
    }


    @RequestMapping(value = "/birdcheckin", method = RequestMethod.POST)
    public String birdcheckin(@ModelAttribute("Location") Location location, Model model) {

        model.addAttribute("checkinurl", "status");
        model.addAttribute("locationname", location.getLocationname());
        model.addAttribute("longitude", location.getLongitude());
        model.addAttribute("latitude", location.getLatitude());

        return "checkin/birdcheckin";
    }
}
