package ru.myproject.firstaidkit.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "STORING_PLACE")
public class StoringPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "STORING_PLACE_NAME", nullable = false)
    private String storingPlaceName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "PLACE_PACKING",
            joinColumns = @JoinColumn(name = "STORING_PLACE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PACKING_ID")
    )
    private List<Packing> packings;


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

    public List<Packing> getPackings() {
        return packings;
    }

    public void setPackings(List<Packing> packings) {
        this.packings = packings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoringPlace that = (StoringPlace) o;

        if (id != that.id) return false;
        if (storingPlaceName != null ? !storingPlaceName.equals(that.storingPlaceName) : that.storingPlaceName != null)
            return false;
        return packings != null ? packings.equals(that.packings) : that.packings == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (storingPlaceName != null ? storingPlaceName.hashCode() : 0);
        result = 31 * result + (packings != null ? packings.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "StoringPlace{" +
                "id=" + id +
                ", name='" + storingPlaceName + '\'' +
                '}';
    }
}
