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


    public Drug() {
    }


    public Drug(String drugName, String activeSubstance, String registrationNumber) {
        this.drugName = drugName;
        this.activeSubstance = activeSubstance;
        this.registrationNumber = registrationNumber;
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
