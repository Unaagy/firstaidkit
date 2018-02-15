package ru.myproject.firstaidkit.dao;

import ru.myproject.firstaidkit.entity.Drug;

import java.util.List;

public interface DrugDAO {

    /*
    TODO Add createDrug() to the DrugDAO and DrugServiceDAO
     */

    //create
    void add(Drug drug);

    void createDrug(String drugName, String activeSubstance, String registrationNumber);

    //read
    List<Drug> getAll();

    Drug getById(long id);

    Drug getByName(String name);

    //update
    Drug update (Drug drug);

    //delete
    void delete(Drug drug);

}
