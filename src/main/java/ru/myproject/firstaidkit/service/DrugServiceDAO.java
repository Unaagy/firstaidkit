package ru.myproject.firstaidkit.service;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;
import ru.myproject.firstaidkit.bl.EntityManagerUtil;
import ru.myproject.firstaidkit.dao.DrugDAO;
import ru.myproject.firstaidkit.entity.Drug;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;


@Service
public class DrugServiceDAO extends EntityManagerUtil implements DrugDAO {

    private EntityManagerFactory factory;

    private EntityManager em;


    public DrugServiceDAO(EntityManagerFactory factory) {
        this.factory = factory;
        em = getEntityManager(factory);
    }


    @Override
    public void add(Drug drug) {
        beginEntityManagerTransaction();

        try {
            em.persist(drug);
            commitEntityManagerTransaction();
        } catch (Throwable t) {
            rollbackEntityManagerTransaction();
        }

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
        beginEntityManagerTransaction();

        try {
            Drug mergedDrug = em.merge(drug);
            commitEntityManagerTransaction();
            return mergedDrug;
        } catch (Throwable t) {
            rollbackEntityManagerTransaction();
            return drug;
        }

    }

    @Override
    public void delete(Drug drug) {
        beginEntityManagerTransaction();

        try {
            em.remove(drug);
            commitEntityManagerTransaction();
        } catch (Throwable t) {
            rollbackEntityManagerTransaction();
        }

    }
}
