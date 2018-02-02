package ru.myproject.firstaidkit.entity.testDAO;

import org.junit.*;
import ru.myproject.firstaidkit.entity.Drug;
import ru.myproject.firstaidkit.service.DrugServiceDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;


public class TestDrugServiceDAO {

    private EntityManagerFactory emFactory;
    private EntityManager testManager;

    private Drug drug;

    @Before
    public void setUp() throws Exception {
        emFactory = Persistence.createEntityManagerFactory("TestUnitH2File");
        testManager = emFactory.createEntityManager();

        drug = new Drug("Mig", "Ibuprofen", "PB-0000");
    }

    @After
    public void tearDown() throws Exception {
        drug = null;
    }


    @Test
    public void addTest() {

        DrugServiceDAO drugServiceDAO = new DrugServiceDAO(emFactory);
        drugServiceDAO.add(drug);

        assertEquals("Mig", testManager.find(Drug.class, drug.getId()).getDrugName());

        drugServiceDAO.closeEntityManager();

    }


    @Test
    public void updateTest() {

        DrugServiceDAO drugServiceDAO = new DrugServiceDAO(emFactory);
        drugServiceDAO.add(drug);

        drug.setDrugName("Aspirine");

        drug = drugServiceDAO.update(drug);

        assertEquals("Aspirine", testManager.find(Drug.class, drug.getId()).getDrugName());

        drugServiceDAO.closeEntityManager();

    }


}
