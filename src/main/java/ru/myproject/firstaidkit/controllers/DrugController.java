package ru.myproject.firstaidkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.myproject.firstaidkit.beans.DrugBean;
import ru.myproject.firstaidkit.service.DrugServiceDAO;

@Controller
public class DrugController {

    @Autowired
    private DrugServiceDAO dao;


    public DrugController(DrugServiceDAO dao) {
        this.dao = dao;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index(ModelMap model) {
        DrugBean drugBean = new DrugBean();
        drugBean.setDrugs(dao.getAll());

        model.put("drug_bean", drugBean);

        return "drugPage";
    }

    /*
    TODO Do Post and etc.
     */


}
