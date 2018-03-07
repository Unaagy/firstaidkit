package ru.myproject.firstaidkit.controllers;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.myproject.firstaidkit.beans.StoringPlaceBean;
import ru.myproject.firstaidkit.dao.StoringPlaceDAO;
import ru.myproject.firstaidkit.entity.StoringPlace;
import ru.myproject.firstaidkit.service.StoringPlaceServiceDAO;

import javax.persistence.PersistenceException;

@Controller
public class StoringPlaceController {

    @Autowired
    private StoringPlaceServiceDAO dao;


    public StoringPlaceController(StoringPlaceServiceDAO dao) {
        this.dao = dao;
    }


    //Show all places
    @RequestMapping(method = RequestMethod.GET, path = "/storingPlaceList")
    public String storingPlaceList(ModelMap model) {
        StoringPlaceBean storingPlaceBean = new StoringPlaceBean();
        storingPlaceBean.setStoringPlaces(dao.getAll());

        model.put("places_bean", storingPlaceBean);

        System.out.println("********** STORING PLACES ******************");

        return "storingPlacesPage";
    }


    //Add new storing place to a DB, using POST from addStoringPlacePage.jsp
    @RequestMapping(method = RequestMethod.POST, path = "/addStoringPlace")
    public String addStoringPlace(@RequestParam String storingPlaceName) {
        try {
            if (storingPlaceName.equals("")) throw new PersistenceException();
            dao.createStoringPlace(storingPlaceName);
        } catch (Throwable t) {
            System.out.println("***********" + t.toString());
            return "redirect:/error/addStoringPlaceProblem";
        }

        System.out.println("********** ADD STORING PLACE ******************");

        return "redirect:/storingPlaceList";
    }


    //Open addStoringPlaceProblemPage.jsp if there is a problem with adding
    @RequestMapping(path = "/error/addStoringPlaceProblem")
    public String addStoringPlaceProblem() {
        return "addStoringPlaceProblemPage";
    }


    //Delete Storing place
    @RequestMapping(path = "/deleteStoringPlace/{id}")
    public String deleteStoringPlace(@PathVariable("id") long id) {

        dao.remove(dao.getById(id));

        return "redirect:/storingPlaceList";
    }


    //Edit storing place
    @RequestMapping(method = RequestMethod.GET, path = "/editStoringPlace/{id}")
    public String editStoringPlace(@PathVariable("id") long id, ModelMap model) {

        StoringPlaceBean storingPlaceBean = new StoringPlaceBean();
        storingPlaceBean.setStoringPlace(dao.getById(id));

        model.addAttribute("place_bean", storingPlaceBean);

        return "editStoringPlacePage";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/editStoringPlace")
    public String editStoringPlacePost(@RequestParam long id,
                                       @RequestParam String storingPlaceName) {
        try {
            StoringPlace storingPlace = dao.getById(id);

            storingPlace.setStoringPlaceName(storingPlaceName);

            dao.update(storingPlace);
        } catch (Throwable t) {
            System.out.println("***********" + t.toString());
            return "redirect:/error/addStoringPlaceProblem";
        }

        return "redirect:/storingPlaceList";
    }


}
