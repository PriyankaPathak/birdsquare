package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Bird;
import birdsquare.model.Checkin;
import birdsquare.model.Location;
import birdsquare.model.User;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BirdCheckinController {

    private BirdSquareSession birdSquareSession;

    @Autowired
    public BirdCheckinController(BirdSquareSession birdSquareSession) {
        this.birdSquareSession = birdSquareSession;
    }

    @RequestMapping(value = "/homesuccess", method = RequestMethod.POST)
    public String retrieveBirdNameFromUserAndRedirectToProfilePage(@ModelAttribute("checkin") Checkin checkin, Model model, @RequestParam("birdName") String birdName) {
        List birds = birdSquareSession.getCorrespondingRowAccordingToFilterSet(Bird.class, birdName, "scientific_name");
        for (Object bird : birds) {
            checkin.setBirdId((int) ((Bird) bird).getId());
        }

        User user = (User) birdSquareSession.get(User.class, checkin.getFbuid());
        if (null != checkin && null != birdName) {
            birdSquareSession.save(checkin);
            if (user == null) {
                user = new User(checkin.getFbuid());
            }
            user.incrementPointsByOne();
            birdSquareSession.saveOrUpdate(user);
        }
        model.addAttribute("points", user.getPoints());

        return "home/home";
    }


    @RequestMapping(value = "/checkinform", method = RequestMethod.POST)
    public String birdcheckin(@ModelAttribute("Location") Location location, Model model) throws JSONException {
        model.addAttribute("locationName", location.getName());
        model.addAttribute("longitude", location.getLongitude());
        model.addAttribute("latitude", location.getLatitude());
        Checkin checkin = new Checkin();
        List<String> birdNameList = checkin.getBirdNameList(birdSquareSession);
        model.addAttribute("allbirds", birdNameList);

        return "checkin/checkinform";
    }
}
