package ru.myproject.firstaidkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.myproject.firstaidkit.beans.PackingBean;
import ru.myproject.firstaidkit.bl.Util;
import ru.myproject.firstaidkit.entity.Packing;
import ru.myproject.firstaidkit.entity.StoringPlace;
import ru.myproject.firstaidkit.service.DrugServiceDAO;
import ru.myproject.firstaidkit.service.PackingServiceDAO;
import ru.myproject.firstaidkit.service.StoringPlaceServiceDAO;

import javax.persistence.PersistenceException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PackingController {

    @Autowired
    private PackingServiceDAO packingServiceDAO;

    @Autowired
    private DrugServiceDAO drugServiceDAO;

    @Autowired
    private StoringPlaceServiceDAO storingPlaceServiceDAO;


    public PackingController(PackingServiceDAO dao) {
        this.packingServiceDAO = dao;
    }


    //Show all packings
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String packingList(ModelMap model) {
        PackingBean packingBean = new PackingBean();
        packingBean.setPackings(packingServiceDAO.getAll());

        model.put("packings_bean", packingBean);

        System.out.println("********** PACKINGS ******************");

        return "packingListPage";
    }


    //Add new packing to a DB, using POST from addPackingPage.jsp
    @RequestMapping(method = RequestMethod.POST, path = "/addPacking")
    public String addPacking(@RequestParam String drug,
                             @RequestParam String manufacturer,
                             @RequestParam long amount,
                             @RequestParam long dosage,
                             @RequestParam String expirationDate,
                             @RequestParam String storingPlaceName) {
        try {
            if (drug.equals("")) throw new PersistenceException();

            Date date = Util.getDate(expirationDate);

            Packing packing = new Packing();
            packing.setDrug(drugServiceDAO.getByName(drug));
            packing.setManufacturer(manufacturer);
            packing.setAmount(amount);
            packing.setDosage(dosage);
            packing.setExpirationDate(date);
            packing.setStoringPlace(storingPlaceServiceDAO.getByName(storingPlaceName));

            packingServiceDAO.add(packing);

        } catch (Throwable t) {
            System.out.println("********************" + t.toString());
            return "redirect:/error/addPackingProblemPage";
        }

        return "redirect:/";
    }


    //Open addPackingProblemPage.jsp if there is a problem in addPacking() method
    @RequestMapping(value = "/error/addPackingProblemPage")
    public String addPackingProblem() {
        return "addPackingProblemPage";
    }


    //Delete packing
    @RequestMapping(path = "/deletePacking/{id}")
    public String deletePacking(@PathVariable("id") long id) {

        packingServiceDAO.remove(packingServiceDAO.getById(id));

        return "redirect:/";
    }


    //Edit packing
    @RequestMapping(method = RequestMethod.GET, path = "/editPacking/{id}")
    public String editPacking(@PathVariable("id") long id, ModelMap model) {

        PackingBean packingBean = new PackingBean();
        packingBean.setPacking(packingServiceDAO.getById(id));

        model.addAttribute("packing_bean", packingBean);

        return "editPackingPage";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/editPacking")
    public String editPackingPost(@RequestParam long id,
                                  @RequestParam String drug,
                                  @RequestParam String manufacturer,
                                  @RequestParam long amount,
                                  @RequestParam long dosage,
                                  @RequestParam String expirationDate,
                                  @RequestParam String storingPlaceName) {
        try {
            if (drug.equals("")) throw new PersistenceException();

            Date date = Util.getDate(expirationDate);

            Packing packing = packingServiceDAO.getById(id);

            packing.setDrug(drugServiceDAO.getByName(drug));
            packing.setManufacturer(manufacturer);
            packing.setAmount(amount);
            packing.setDosage(dosage);
            packing.setExpirationDate(date);
            packing.setStoringPlace(storingPlaceServiceDAO.getByName(storingPlaceName));

            packingServiceDAO.update(packing);
        } catch (Throwable t) {
            System.out.println("********************" + t.toString());
            return "redirect:/error/addPackingProblemPage";
        }

        return "redirect:/";
    }


}
