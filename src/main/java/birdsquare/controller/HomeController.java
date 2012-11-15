package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.helper.JsonReader;
import birdsquare.model.Location;
import birdsquare.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {
    private BirdSquareSession birdSquareSession;

    @Autowired
    public HomeController(BirdSquareSession birdSquareSession) {
        this.birdSquareSession = birdSquareSession;
    }


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String index(Model model, @CookieValue("fbuid") String uid) throws IOException, JSONException {//, @CookieValue("fbusername") String username) {

        User user = (User) birdSquareSession.get(User.class, uid);

        if (user == null) {
            JSONObject userDetails = new JsonReader().readJsonFromUrl("http://graph.facebook.com/" + uid);
            String username = (String) userDetails.get("name");
            user = new User(uid, username);
            birdSquareSession.save(user);
        }


        List leaderboardList = birdSquareSession.getSortedDescendingList(User.class, "points", 5);

        model.addAttribute("leaderboardlist", leaderboardList);
        model.addAttribute("points", user.getPoints());

        return "home/home";
    }

    @RequestMapping(value = "/checkinlocations")
    public String checkin(@ModelAttribute("Location") Location location, Model model) {
        model.addAttribute("locationName", location.getName());
        model.addAttribute("latitude", location.getLatitude());
        model.addAttribute("longitude", location.getLongitude());
        return "checkin/checkinlocations";
    }
}

