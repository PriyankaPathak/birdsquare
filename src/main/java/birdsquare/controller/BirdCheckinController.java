package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BirdCheckinController {

    private BirdSquareSession birdSquareSession;

    @Autowired
    public BirdCheckinController(BirdSquareSession birdSquareSession) {
        this.birdSquareSession = birdSquareSession;
    }

    @RequestMapping(value = "/status")
    public String retrieveBirdNameFromUserAndRedirectToStatusPage(@ModelAttribute("checkin") Checkin checkin, Model model) {

        model.addAttribute("checkinurl", "birdcheckin");
        if (null != checkin && null != checkin.getBirdname()) {
            model.addAttribute("message", checkin.birdname + " check in success!");
            checkin.setDate(new Date());
            birdSquareSession.save(checkin);
        } else
            model.addAttribute("message", "Wrong input");

        return "checkin/status";
    }

    @RequestMapping(value = "/birdcheckin", method = RequestMethod.GET)
    public String birdcheckin(Model model, @RequestParam(value = "name") String locationName, @RequestParam(value = "lat") Double lat, @RequestParam(value = "lng") String lng) {

        model.addAttribute("checkinurl", "status");
        model.addAttribute("locationName", locationName);
        model.addAttribute("lng", lng);
        model.addAttribute("lat", lat);
        return "checkin/birdcheckin";
    }
}
