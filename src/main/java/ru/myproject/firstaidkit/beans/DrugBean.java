package ru.myproject.firstaidkit.beans;

import ru.myproject.firstaidkit.entity.Drug;

import java.util.List;

public class DrugBean {

    private List<Drug> drugs;
    private Drug drug;
    private long id;


    public DrugBean() {
    }


    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public long getId() {
        return id;
    }


}
