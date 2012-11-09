package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Checkin;
import birdsquare.model.Location;
import org.hibernate.SQLQuery;
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

    @RequestMapping(value = "/profilesuccess", method=RequestMethod.POST)
    public String retrieveBirdNameFromUserAndRedirectToProfilePage(@ModelAttribute("checkin") Checkin checkin, Model model, @RequestParam("birdName") String birdName) {

        model.addAttribute("checkinurl", "checkinlocations");

        System.out.println(birdName);
        String sql = "select id from bird where scientific_name='"+birdName+"';";
        System.out.println(sql);
        SQLQuery sqlQuery = birdSquareSession.createSQLQuery(sql);
        System.out.println(sqlQuery);

        for(Object object: sqlQuery.list())
        {
            System.out.println(object);
        }

        if (null != checkin && null != birdName) {
            model.addAttribute("message", "You have checked in " + checkin.getNumber() + " " + birdName + "(s) successfully!");
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
