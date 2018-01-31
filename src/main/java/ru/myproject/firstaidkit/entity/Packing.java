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

    @Column(name = "STORING_PLACE", nullable = false)
    @ManyToMany(mappedBy = "packings")
    private Set<StoringPlace> storingPlaces;


    public Packing() {
    }

    public Packing(Drug drug, String manufacturer, long amount, long dosage, Date expirationDate, Set<StoringPlace> storingPlaces) {
        this.drug = drug;
        this.manufacturer = manufacturer;
        this.amount = amount;
        this.dosage = dosage;
        this.expirationDate = expirationDate;
        this.storingPlaces = storingPlaces;
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
        return storingPlaces != null ? storingPlaces.equals(packing.storingPlaces) : packing.storingPlaces == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (drug != null ? drug.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        result = 31 * result + (int) (dosage ^ (dosage >>> 32));
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (storingPlaces != null ? storingPlaces.hashCode() : 0);
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
