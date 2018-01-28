package ru.myproject.firstaidkit.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STORING_PLACE")
public class StoringPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "STORING_PLACE_NAME")
    private String storingPlaceName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "PLACE_PACKING",
            joinColumns = @JoinColumn(name = "STORING_PLACE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PACKING_ID")
    )
    private Set<Packing> packings;


    public StoringPlace() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoringPlaceName() {
        return storingPlaceName;
    }

    public void setStoringPlaceName(String name) {
        this.storingPlaceName = name;
    }

    public Set<Packing> getPackings() {
        return packings;
    }

    public void setPackings(Set<Packing> packings) {
        this.packings = packings;
    }


    @Override
    public String toString() {
        return "StoringPlace{" +
                "id=" + id +
                ", name='" + storingPlaceName + '\'' +
                '}';
    }
}
