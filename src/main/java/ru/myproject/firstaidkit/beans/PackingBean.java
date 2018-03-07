package ru.myproject.firstaidkit.beans;

import ru.myproject.firstaidkit.entity.Packing;

import java.util.List;

public class PackingBean {

    private List<Packing> packings;
    private Packing packing;
    private long id;

    public PackingBean() {

    }


    public List<Packing> getPackings() {
        return packings;
    }

    public void setPackings(List<Packing> packings) {
        this.packings = packings;
    }

    public Packing getPacking() {
        return packing;
    }

    public void setPacking(Packing packing) {
        this.packing = packing;
    }

    public long getId() {
        return id;
    }

}
