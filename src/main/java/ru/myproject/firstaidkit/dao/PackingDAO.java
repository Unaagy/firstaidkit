package ru.myproject.firstaidkit.dao;

import ru.myproject.firstaidkit.entity.Packing;

import java.util.List;

public interface PackingDAO {

    //create
    void add(Packing packing);

    //read
    List<Packing> getAll();

    Packing getById(long id);

    Packing getByName(String name);

    //update
    void update(Packing packing);

    //delete
    void remove(Packing packing);

}
