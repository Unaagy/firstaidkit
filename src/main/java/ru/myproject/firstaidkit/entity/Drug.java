package ru.myproject.firstaidkit.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "DRUG")
public class Drug implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DRUG_NAME", nullable = false)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drug drug = (Drug) o;

        if (id != drug.id) return false;
        if (drugName != null ? !drugName.equals(drug.drugName) : drug.drugName != null) return false;
        if (activeSubstance != null ? !activeSubstance.equals(drug.activeSubstance) : drug.activeSubstance != null)
            return false;
        return registrationNumber != null ? registrationNumber.equals(drug.registrationNumber) : drug.registrationNumber == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (drugName != null ? drugName.hashCode() : 0);
        result = 31 * result + (activeSubstance != null ? activeSubstance.hashCode() : 0);
        result = 31 * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
        return result;
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
