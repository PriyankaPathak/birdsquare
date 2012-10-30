package birdsquare.controller;

import birdsquare.helper.BirdSessionFactory;
import birdsquare.model.BirdInformation;
import birdsquare.model.BirdInformationDAO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class BirdCheckinController {


    @Autowired
    @Qualifier("birdInformationDAO")
    private BirdInformationDAO dao;

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String retrieveBirdNameFromUserAndRedirectToStatusPage(@ModelAttribute("birdinformation") BirdInformation birdinformation,Model model) {

        model.addAttribute("checkinurl", "birdcheckin");

        if (null != birdinformation &&
                null != birdinformation.getBirdname()) {
            model.addAttribute("message", birdinformation.birdname+" check in success!");
            birdinformation.setDate(new Date());
        //    putObjectToTable(birdinformation);
            dao.save(birdinformation);
        }
        else
            model.addAttribute("message", "Wrong input");

        return "checkin/status";
    }

    public void setDao(BirdInformationDAO dao){
        this.dao=dao;
    }

    private void putObjectToTable(Object object)
    {
        final Session session = BirdSessionFactory.getInstance().createSession();
        session.beginTransaction();

        session.saveOrUpdate(object);

        session.getTransaction().commit();
        session.close();
    }

    @RequestMapping(value = "/birdcheckin" )
    public String birdcheckin(Model model){

        model.addAttribute("checkinurl", "status");

        return "checkin/birdcheckin";
    }


}