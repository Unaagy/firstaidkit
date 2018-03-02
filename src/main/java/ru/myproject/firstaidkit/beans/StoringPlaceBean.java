package ru.myproject.firstaidkit.beans;

import ru.myproject.firstaidkit.entity.StoringPlace;

import java.util.List;

public class StoringPlaceBean {

    private List<StoringPlace> storingPlaces;
    private StoringPlace storingPlace;
    private long id;

    public StoringPlaceBean() {

    }

    public List<StoringPlace> getStoringPlaces() {
        return storingPlaces;
    }

    public void setStoringPlaces(List<StoringPlace> storingPlaces) {
        this.storingPlaces = storingPlaces;
    }

    public StoringPlace getStoringPlace() {
        return storingPlace;
    }

    public void setStoringPlace(StoringPlace storingPlace) {
        this.storingPlace = storingPlace;
    }

    public long getId() {
        return id;
    }

}
