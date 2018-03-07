package ru.myproject.firstaidkit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.myproject.firstaidkit.beans.DrugBean;
import ru.myproject.firstaidkit.entity.Drug;
import ru.myproject.firstaidkit.service.DrugServiceDAO;

import javax.persistence.PersistenceException;

@Controller
public class DrugController {

    @Autowired
    private DrugServiceDAO dao;


    public DrugController(DrugServiceDAO dao) {
        this.dao = dao;
    }


    //Show all drugs on a page
    @RequestMapping(method = RequestMethod.GET, path = "/drugs")
    public String drugList(ModelMap model) {
        DrugBean drugBean = new DrugBean();
        drugBean.setDrugs(dao.getAll());

        model.put("drugs_bean", drugBean);

        System.out.println("********** DRUGS ******************");

        return "drugsPage";
    }


    //Add new drug to a DB, using post from addDrugPage.jsp
    @RequestMapping(method = RequestMethod.POST, path = "/addDrugPage")
    public String addDrug(@RequestParam String drugName,
                          @RequestParam(required = false) String activeSubstance,
                          @RequestParam(required = false) String registrationNumber, ModelMap model) {
        try {
            if (drugName.equals("")) throw new PersistenceException();
            dao.createDrug(drugName, activeSubstance, registrationNumber);
        } catch (Throwable t) {
            System.out.println("********************" + t.toString());
            return "redirect:/error/addDrugProblemPage";
        }
        System.out.println("********** ADD DRUGS ******************");

        return drugList(model);
    }


    //Open addDrugProblemPage.jsp if there is a problem in addDrug() method
    @RequestMapping(method = RequestMethod.GET, path = "/error/addDrugProblemPage")
    public String addDrugProblem() {
        return "addDrugProblemPage";
    }


    //Delete drug from DB
    @RequestMapping(path = "/deleteDrug/{id}")
    public String deleteDrug(@PathVariable("id") long id) {

        dao.delete(dao.getById(id));

        return "redirect:/drugs";
    }


    //Edit drug
    @RequestMapping(method = RequestMethod.GET, path = "/editDrug/{id}")
    public String editDrug(@PathVariable("id") long id, ModelMap model) {

        DrugBean drugBean = new DrugBean();
        drugBean.setDrug(dao.getById(id));

        model.addAttribute("drug_bean", drugBean);

        return "editDrugPage";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/editDrug")
    public String editDrugPost(@RequestParam long id,
                               @RequestParam String drugName,
                               @RequestParam(required = false) String activeSubstance,
                               @RequestParam(required = false) String registrationNumber) {

        try {
            Drug drug = dao.getById(id);

            drug.setDrugName(drugName);
            drug.setActiveSubstance(activeSubstance);
            drug.setRegistrationNumber(registrationNumber);

            dao.update(drug);

        } catch (Throwable t) {
            System.out.println("********************" + t.toString());
            return "redirect:/error/addDrugProblemPage";
        }
        System.out.println("********** EDIT DRUG ******************");

        return "redirect:/drugs";
    }

}
