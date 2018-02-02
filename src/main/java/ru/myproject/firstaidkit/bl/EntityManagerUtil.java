package ru.myproject.firstaidkit.bl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerUtil {

    private EntityManager entityManager;


    public EntityManager getEntityManager(EntityManagerFactory factory) {
        entityManager = factory.createEntityManager();
        return entityManager;
    }


    public void beginEntityManagerTransaction() {
        entityManager.getTransaction().begin();
    }


    public void commitEntityManagerTransaction() {
        entityManager.getTransaction().commit();
    }


    public void rollbackEntityManagerTransaction() {
        entityManager.getTransaction().rollback();
    }


    public void closeEntityManager() {
        entityManager.close();
    }


}
