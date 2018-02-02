package ru.myproject.firstaidkit.dao;

import ru.myproject.firstaidkit.entity.StoringPlace;

import java.util.List;

public interface StoringPlaceDAO {

    //create
    void add(StoringPlace storingPlace);

    //read
    List<StoringPlace> getAll();

    StoringPlace getById(long id);

    StoringPlace getByName(String name);

    //update
    void update(StoringPlace storingPlace);

    //delete
    void remove(StoringPlace storingPlace);

}
