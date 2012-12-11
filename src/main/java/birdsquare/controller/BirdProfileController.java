package birdsquare.controller;

import birdsquare.helper.BirdSquareSession;
import birdsquare.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BirdProfileController {

    private BirdSquareSession birdSquareSession;

    @Autowired
    public BirdProfileController(BirdSquareSession birdSquareSession) {
        this.birdSquareSession = birdSquareSession;
    }

    @RequestMapping(value = "/birdprofile/{birdID}", method = RequestMethod.GET)
    public ModelAndView birdProfile(@PathVariable("birdID") String birdId){
        ModelAndView mv = new ModelAndView("birdprofile/birdprofile");
        ModelMap model = mv.getModelMap();
        long id = (long)Integer.parseInt(birdId);
        Bird bird = (Bird) birdSquareSession.get(Bird.class,id);
        model.addAttribute("birdname", bird.getCommon_name());
        model.addAttribute("scientificname", bird.getScientific_name());
        model.addAttribute("familyname",bird.getFamily_name());
        model.addAttribute("ordername",bird.getOrder_name());
        model.addAttribute("linkToBirdImage", bird.getImage_url());
        return mv;
    }
}
