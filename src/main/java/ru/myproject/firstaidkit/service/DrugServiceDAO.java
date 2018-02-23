package ru.myproject.firstaidkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myproject.firstaidkit.bl.EntityManagerUtil;
import ru.myproject.firstaidkit.dao.DrugDAO;
import ru.myproject.firstaidkit.entity.Drug;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import java.util.List;


@Service
public class DrugServiceDAO implements DrugDAO {

//    private EntityManagerFactory factory;

    private EntityManager em;

    @Autowired
    public DrugServiceDAO(EntityManagerFactory factory) {
//        this.factory = factory;
        em = factory.createEntityManager();
//        this.em = em;
    }


    @Override
    public void add(Drug drug) {
//        beginEntityManagerTransaction();
        em.getTransaction().begin();

        try {
            em.persist(drug);
//            commitEntityManagerTransaction();
            em.getTransaction().commit();
        } catch (Throwable t) {
//            rollbackEntityManagerTransaction();
            em.getTransaction().rollback();
            throw t;
        }

    }

    @Override
    public void createDrug(String drugName, String activeSubstance, String registrationNumber) {
        Drug drug = new Drug(drugName, activeSubstance, registrationNumber);
        add(drug);
    }

    @Override
    public List<Drug> getAll() {

        try {
            String sql = "SELECT d FROM Drug d";
            List<Drug> list = em.createQuery(sql).getResultList();
            return list;
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public Drug getById(long id) {
        try {
            return (Drug) em.createQuery("SELECT d FROM Drug d WHERE d.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Drug getByName(String name) {
        try {
            return (Drug) em.createQuery("SELECT d FROM Drug d WhERE d.drugName = :name")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Drug update(Drug drug) {
//        beginEntityManagerTransaction();
        em.getTransaction().begin();

        try {
//            Drug mergedDrug = em.merge(drug);
//            commitEntityManagerTransaction();
//            em.getTransaction().commit();
//            return mergedDrug;
            //TODO try to do it using links instead of two objects
            Drug drug2 = getById(drug.getId());
            drug2.setDrugName(drug.getDrugName());
            drug2.setRegistrationNumber(drug.getRegistrationNumber());
            drug2.setActiveSubstance(drug.getActiveSubstance());
            em.persist(drug2);
            em.getTransaction().commit();
            return drug2;
        } catch (Throwable t) {
//            rollbackEntityManagerTransaction();
            em.getTransaction().rollback();
            return drug;
        }

    }

    @Override
    public void delete(Drug drug) {
//        beginEntityManagerTransaction();
        em.getTransaction().begin();

        try {
            em.remove(drug);
//            commitEntityManagerTransaction();
            em.getTransaction().commit();
        } catch (Throwable t) {
//            rollbackEntityManagerTransaction();
            em.getTransaction().rollback();
            throw t;
        }

    }
}
