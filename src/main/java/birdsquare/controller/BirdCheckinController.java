package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Checkin;
import birdsquare.model.Location;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BirdCheckinController {

    private BirdSquareSession birdSquareSession;

    @Autowired
    public BirdCheckinController(BirdSquareSession birdSquareSession) {
        this.birdSquareSession = birdSquareSession;
    }

    @RequestMapping(value = "/profilesuccess", method=RequestMethod.POST)
    public String retrieveBirdNameFromUserAndRedirectToProfilePage(@ModelAttribute("checkin") Checkin checkin, Model model) {

        model.addAttribute("checkinurl", "checkinlocations");

        if (null != checkin && null != checkin.getBirdName()) {
            model.addAttribute("message", "You have checked in " + checkin.getNumber() + " " + checkin.getBirdName() + "(s) successfully!");
            birdSquareSession.save(checkin);

        } else {
            model.addAttribute("message", "Please fill in all fields");
        }

        return "profile/profile";
    }


    @RequestMapping(value = "/checkinform", method = RequestMethod.POST)
    public String birdcheckin(@ModelAttribute("Location") Location location, Model model) throws JSONException {
        model.addAttribute("checkinurl", "checkinlocations");
        model.addAttribute("locationName", location.getName());
        model.addAttribute("longitude", location.getLongitude());
        model.addAttribute("latitude", location.getLatitude());
        Checkin checkin = new Checkin();
        List<String> birdNameList = checkin.getBirdNameList(birdSquareSession);
        model.addAttribute("allbirds", birdNameList);

        return "checkin/checkinform";
    }

}
