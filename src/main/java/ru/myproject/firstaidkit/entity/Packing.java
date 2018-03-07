package ru.myproject.firstaidkit.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.security.PrivilegedExceptionAction;
import java.sql.Date;
import java.util.List;
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

//    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @ManyToOne
    @JoinTable(
            name = "PLACE_PACKING",
            joinColumns = @JoinColumn(name = "STORING_PLACE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PACKING_ID")
    )
    private StoringPlace storingPlace;


    public Packing() {
    }

    public Packing(Drug drug, String manufacturer, long amount, long dosage, Date expirationDate, StoringPlace storingPlace) {
        this.drug = drug;
        this.manufacturer = manufacturer;
        this.amount = amount;
        this.dosage = dosage;
        this.expirationDate = expirationDate;
        this.storingPlace = storingPlace;
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

    public StoringPlace getStoringPlace() {
        return storingPlace;
    }

    public void setStoringPlace(StoringPlace storingPlace) {
        this.storingPlace = storingPlace;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Packing packing = (Packing) o;

        if (id != packing.id) return false;
        if (amount != packing.amount) return false;
        if (dosage != packing.dosage) return false;
        if (drug != null ? !drug.equals(packing.drug) : packing.drug != null) return false;
        if (manufacturer != null ? !manufacturer.equals(packing.manufacturer) : packing.manufacturer != null)
            return false;
        if (expirationDate != null ? !expirationDate.equals(packing.expirationDate) : packing.expirationDate != null)
            return false;
        return storingPlace != null ? storingPlace.equals(packing.storingPlace) : packing.storingPlace == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (drug != null ? drug.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        result = 31 * result + (int) (dosage ^ (dosage >>> 32));
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (storingPlace != null ? storingPlace.hashCode() : 0);
        return result;
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
