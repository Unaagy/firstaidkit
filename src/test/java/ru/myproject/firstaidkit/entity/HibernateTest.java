package ru.myproject.firstaidkit.entity;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class HibernateTest {

    private EntityManagerFactory emFactory;
    private EntityManager em;

    Date date;

    @Before
    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("TestUnitH2File");
        em = emFactory.createEntityManager();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 9, 22);

        date = new Date(calendar.getTime().getTime());
    }

    @After
    public void tearDown() {
        em.close();
        emFactory.close();
    }

    @Test
    public void drugTest() {
        em.getTransaction().begin();

        Drug drug = new Drug("Mig", "Ibuprofen", "PB-0000");

        em.persist(drug);
        em.getTransaction().commit();

        assertEquals("Mig", em.find(Drug.class, drug.getId()).getDrugName());
        assertEquals("Ibuprofen", em.find(Drug.class, 1L).getActiveSubstance());
        assertEquals("PB-0000", em.find(Drug.class, 1L).getRegistrationNumber());
    }

    @Test
    public void packingTest() {
        Drug drug = new Drug();
        drug.setDrugName("Aspirine");

        StoringPlace storingPlace = new StoringPlace();
        storingPlace.setStoringPlaceName("TestBox");

        Set<StoringPlace> places = new HashSet<>();
        places.add(storingPlace);

        Packing packing = new Packing(drug, "Teva", 10L,
                500, date, places);

        em.getTransaction().begin();
        em.persist(drug);
        em.persist(packing);
        em.getTransaction().commit();

        assertEquals("Aspirine", em.find(Drug.class, 1L).getDrugName());
        assertEquals(drug, em.find(Packing.class, 1L).getDrug());

        StoringPlace sp = (StoringPlace) em.find(Packing.class, 1L).getStoringPlaces().toArray()[0];
        assertEquals("TestBox", sp.getStoringPlaceName());

    }

    @Test
    public void storingPlaceTest() {

        StoringPlace storingPlace = new StoringPlace();
        storingPlace.setStoringPlaceName("Box");

        em.getTransaction().begin();
        em.persist(storingPlace);
        em.getTransaction().commit();

        assertEquals("Box", em.find(StoringPlace.class, storingPlace.getId()).getStoringPlaceName());

    }

}
