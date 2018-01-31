package ru.myproject.firstaidkit.entity;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.*;

public class HibernateTest {

    private EntityManagerFactory emFactory;
    private EntityManager em;

    @Before
    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("TestUnitH2File");
        em = emFactory.createEntityManager();
    }

    @After
    public void terDown() {
        em.close();
        emFactory.close();
    }

    @Test
    public void drugTest() {
        em.getTransaction().begin();

        Drug drug = new Drug("Mig", "Ibuprofen", "PB-0000");

        em.persist(drug);
        em.getTransaction().commit();

        String name = em.find(Drug.class, drug.getId()).getDrugName();

        assertEquals("Mig", name);
    }


}
