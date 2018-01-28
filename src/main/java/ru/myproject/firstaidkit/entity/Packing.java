package ru.myproject.firstaidkit.entity;

import javax.persistence.*;
import java.security.PrivilegedExceptionAction;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "PACKING")
public class Packing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "DRUG_ID", nullable = false)
    private Drug drug;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "DOSAGE")
    private long dosage;

    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @ManyToMany(mappedBy = "packings")
    private Set<StoringPlace> storingPlaces;


    public Packing() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getDosage() {
        return dosage;
    }

    public void setDosage(long dosage) {
        this.dosage = dosage;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Set<StoringPlace> getStoringPlaces() {
        return storingPlaces;
    }

    public void setStoringPlaces(Set<StoringPlace> storingPlaces) {
        this.storingPlaces = storingPlaces;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    @Override
    public String toString() {
        return "Packing{" +
                "id=" + id +
                ", drug=" + drug.getDrugName() +
                ", manufacturer='" + manufacturer + '\'' +
                ", amount=" + amount +
                ", dosage=" + dosage +
                ", expirationDate=" + expirationDate +
                '}';
    }


}
