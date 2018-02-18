package ru.myproject.firstaidkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.myproject.firstaidkit.beans.DrugBean;
import ru.myproject.firstaidkit.service.DrugServiceDAO;

@Controller
public class DrugController {

    @Autowired
    private DrugServiceDAO dao;


    public DrugController(DrugServiceDAO dao) {
        this.dao = dao;
    }


    //TODO Don't forget to change it, when real index appear
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String drugList(ModelMap model) {
        DrugBean drugBean = new DrugBean();
        drugBean.setDrugs(dao.getAll());

        model.put("drug_bean", drugBean);

        System.out.println("********** DRUGS ******************");

        return "drugsPage";
    }

    /*
    TODO Do Post and etc.
     */
    @RequestMapping(method = RequestMethod.POST, path = "/addDrugPage")
    public String addDrug(@RequestParam String drugName,
                          @RequestParam (required = false) String activeSubstance,
                          @RequestParam(required = false) String registrationNumber, ModelMap model) {
        dao.createDrug(drugName, activeSubstance, registrationNumber);

        System.out.println("********** ADD DRUGS ******************");

        return drugList(model);
    }


}
