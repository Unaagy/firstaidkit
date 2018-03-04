package ru.myproject.firstaidkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.myproject.firstaidkit.beans.PackingBean;
import ru.myproject.firstaidkit.service.PackingServiceDAO;

import java.sql.Date;

@Controller
public class PackingController {

    @Autowired
    private PackingServiceDAO dao;


    public PackingController(PackingServiceDAO dao) {
        this.dao = dao;
    }


    //Show all packings
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String packingList(ModelMap model) {
        PackingBean packingBean = new PackingBean();
        packingBean.setPackings(dao.getAll());

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
                             @RequestParam Date expirationDate,
                             @RequestParam String storingPlaceName) {



        return "redirect:/";
    }


}
