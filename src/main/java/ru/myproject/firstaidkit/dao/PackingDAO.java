package ru.myproject.firstaidkit.dao;

import ru.myproject.firstaidkit.entity.Drug;
import ru.myproject.firstaidkit.entity.Packing;
import ru.myproject.firstaidkit.entity.StoringPlace;

import java.sql.Date;
import java.util.List;

public interface PackingDAO {

    //create
    void add(Packing packing);

    void createPacking(Drug drug, String manufacturer, long amount,
                       long dosage, Date expirationDate,
                       List<StoringPlace> storingPlaces);

    //read
    List<Packing> getAll();

    Packing getById(long id);

    Packing getByName(String name);

    //update
    Packing update(Packing packing);

    //delete
    void remove(Packing packing);

}
