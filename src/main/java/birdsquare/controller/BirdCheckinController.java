package birdsquare.controller;

import birdsquare.dao.BirdInformationDAO;
import birdsquare.model.BirdInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class BirdCheckinController {

    private BirdInformationDAO birdInformationDAO;

    @Autowired
    public BirdCheckinController(BirdInformationDAO birdInformationDAO) {
        this.birdInformationDAO = birdInformationDAO;
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public String retrieveBirdNameFromUserAndRedirectToStatusPage(@ModelAttribute("birdinformation") BirdInformation birdinformation, Model model) {

        model.addAttribute("checkinurl", "birdcheckin");

        if (null != birdinformation &&
                null != birdinformation.getBirdname()) {
            model.addAttribute("message", birdinformation.birdname + " check in success!");
            birdinformation.setDate(new Date());
            birdInformationDAO.save(birdinformation);
        } else
            model.addAttribute("message", "Wrong input");

        return "checkin/status";
    }

    @RequestMapping(value = "/birdcheckin")
    public String birdcheckin(Model model) {
        model.addAttribute("checkinurl", "status");
        return "checkin/birdcheckin";
    }
}