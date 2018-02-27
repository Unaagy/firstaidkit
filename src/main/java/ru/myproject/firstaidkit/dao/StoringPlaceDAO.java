package ru.myproject.firstaidkit.dao;

import ru.myproject.firstaidkit.entity.Packing;
import ru.myproject.firstaidkit.entity.StoringPlace;

import java.util.List;

public interface StoringPlaceDAO {

    //create
    void add(StoringPlace storingPlace);

    void createStoringPlace(String storingPlaceName, List<Packing> packings);

    //read
    List<StoringPlace> getAll();

    StoringPlace getById(long id);

    StoringPlace getByName(String name);

    //update
    StoringPlace update(StoringPlace storingPlace);

    //delete
    void remove(StoringPlace storingPlace);

}
