package birdsquare;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DummyController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Hello world!");
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("user", "John Doe");
        return "home";
    }

    @RequestMapping(value = "/dummypage", method = RequestMethod.POST)
    public String dummypage(Model model) {

        BirdInformation birdInformation = new BirdInformation("ashwin", "2 lbs", "Hello bird ashwin!");
        model.addAttribute("bird", birdInformation);

        final Session session = BirdSessionFactory.createSession();
        session.beginTransaction();

        session.saveOrUpdate(birdInformation);

        session.getTransaction().commit();
        session.close();

        return "dummypage";
    }
}
