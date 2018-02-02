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

    private DrugServiceDAO drugServiceDAO;

    private Drug drug;

    @Before
    public void setUp() throws Exception {
        emFactory = Persistence.createEntityManagerFactory("TestUnitH2File");
        testManager = emFactory.createEntityManager();

        drugServiceDAO = new DrugServiceDAO(emFactory);

        drug = new Drug("Mig", "Ibuprofen", "PB-0000");
    }

    @After
    public void tearDown() throws Exception {
        drug = null;
    }


    @Test
    public void addTest() {

        drugServiceDAO.add(drug);

        assertEquals("Mig", testManager.find(Drug.class, drug.getId()).getDrugName());

        drugServiceDAO.closeEntityManager();

    }


    @Test
    public void updateTest() {

        drugServiceDAO.add(drug);

        drug.setDrugName("Aspirine");

        drug = drugServiceDAO.update(drug);

        assertEquals("Aspirine", testManager.find(Drug.class, drug.getId()).getDrugName());

        drugServiceDAO.closeEntityManager();

    }


    @Test
    public void deleteTest() {

        drugServiceDAO.add(drug);

        drugServiceDAO.delete(drug);

        assertNull("**********NULL************", testManager.find(Drug.class, drug.getId()));

        drugServiceDAO.closeEntityManager();

    }


    @Test
    public void getAllTest() {

        drugServiceDAO.add(new Drug("Aspirine", "Ibuprofen", "PB-0001"));
        drugServiceDAO.add(new Drug("Mig", "Analgin", "PB-0043"));

        System.out.println(drugServiceDAO.getAll());

        assertNotNull(drugServiceDAO.getAll());

        drugServiceDAO.closeEntityManager();

    }


    @Test
    public void getByIdTest() {

        drugServiceDAO.add(new Drug("Aspirine", "Ibuprofen", "PB-0001"));
        drugServiceDAO.add(new Drug("Mig", "Analgin", "PB-0043"));

        System.out.println(drugServiceDAO.getAll());

        assertEquals("Aspirine", drugServiceDAO.getById(1L).getDrugName());
        assertEquals("Analgin", drugServiceDAO.getById(2L).getActiveSubstance());
        assertNull(drugServiceDAO.getById(100L));

        drugServiceDAO.closeEntityManager();

    }


    @Test
    public void getByNameTest() {

        drugServiceDAO.add(new Drug("Aspirine", "Ibuprofen", "PB-0001"));
        drugServiceDAO.add(new Drug("Mig", "Analgin", "PB-0043"));

        System.out.println(drugServiceDAO.getAll());

        assertEquals("Mig", drugServiceDAO.getByName("Mig").getDrugName());
        assertEquals("Ibuprofen", drugServiceDAO.getByName("Aspirine").getActiveSubstance());
        assertNull(drugServiceDAO.getByName("Kadilak"));

        drugServiceDAO.closeEntityManager();

    }


}
