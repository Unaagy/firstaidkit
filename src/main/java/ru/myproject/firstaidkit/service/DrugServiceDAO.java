package ru.myproject.firstaidkit.service;

import ru.myproject.firstaidkit.bl.EntityManagerUtil;
import ru.myproject.firstaidkit.dao.DrugDAO;
import ru.myproject.firstaidkit.entity.Drug;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

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
            closeEntityManager();
        } catch (Throwable t) {
            rollbackEntityManagerTransaction();
        }

    }

    @Override
    public List<Drug> getAll() {
        return null;
    }

    @Override
    public Drug getById(long id) {
        return null;
    }

    @Override
    public Drug getByName(String name) {
        return null;
    }

    @Override
    public void update(Drug drug) {

    }

    @Override
    public void remove(Drug drug) {

    }
}
