package ru.myproject.firstaidkit.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DRUG")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DRUG_NAME")
    private String drugName;

    @Column(name = "ACTIVE_SUBSTANCE")
    private String activeSubstance;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @OneToMany(mappedBy = "drug", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Packing> packings;


    public Drug() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String name) {
        this.drugName = name;
    }

    public String getActiveSubstance() {
        return activeSubstance;
    }

    public void setActiveSubstance(String activeSubstance) {
        this.activeSubstance = activeSubstance;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Set<Packing> getPackings() {
        return packings;
    }

    public void setPackings(Set<Packing> packings) {
        this.packings = packings;
    }


    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + drugName + '\'' +
                ", activeSubstance='" + activeSubstance + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }


}
