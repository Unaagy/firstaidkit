package ru.myproject.firstaidkit;

import ru.myproject.firstaidkit.entity.Drug;
import ru.myproject.firstaidkit.entity.Packing;
import ru.myproject.firstaidkit.entity.StoringPlace;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class FirstAidKitMain {

    private  static Drug drug;
    private  static Packing packing;
    private  static StoringPlace storingPlace;

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("TestUnitH2");

        EntityManager em = factory.createEntityManager();


        createDrug(em);
        createPacking(em);
        createStoringPlace(em);

        em.close();
        factory.close();

    }

    public static void createDrug(EntityManager em) {
        em.getTransaction().begin();

        drug = new Drug();
        drug.setDrugName("Novopassit");
        drug.setActiveSubstance("Some active substance");
        drug.setRegistrationNumber("PB-12323232323");

        em.persist(drug);
        em.getTransaction().commit();

    }

    public static void createPacking(EntityManager em){
        em.getTransaction().begin();

        packing = new Packing();
        packing.setDosage(500);
        packing.setAmount(30);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.APRIL, 15);

        packing.setExpirationDate(new Date(calendar.getTime().getTime()));
        packing.setDrug(drug);
        packing.setManufacturer("TEVASTA");

        em.persist(packing);
        em.getTransaction().commit();

    }

    public static void createStoringPlace(EntityManager em) {
        em.getTransaction().begin();

        storingPlace = new StoringPlace();
        storingPlace.setStoringPlaceName("BigBox");

        Set<Packing> packings = new HashSet<Packing>();
        packings.add(packing);

        storingPlace.setPackings(packings);

        em.persist(storingPlace);
        em.getTransaction().commit();

    }

}
