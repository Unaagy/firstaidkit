package ru.myproject.firstaidkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.myproject.firstaidkit.dao.StoringPlaceDAO;
import ru.myproject.firstaidkit.entity.Packing;
import ru.myproject.firstaidkit.entity.StoringPlace;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import java.awt.*;
import java.util.List;

public class StoringPlaceServiceDAO implements StoringPlaceDAO {

    private EntityManager em;

    @Autowired
    public StoringPlaceServiceDAO(EntityManagerFactory factory) {
        em = factory.createEntityManager();
    }


    @Override
    public void add(StoringPlace storingPlace) {
        em.getTransaction().begin();

        try {
            em.persist(storingPlace);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void createStoringPlace(String storingPlaceName, List<Packing> packings) {
        StoringPlace storingPlace = new StoringPlace();
        storingPlace.setStoringPlaceName(storingPlaceName);
        storingPlace.setPackings(packings);

        add(storingPlace);
    }

    @Override
    public List<StoringPlace> getAll() {
        try {
            String sql = "select s from StoringPlace s";
            List<StoringPlace> list = em.createQuery(sql).getResultList();
            return list;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StoringPlace getById(long id) {
        try {
            return (StoringPlace) em.createQuery("select s from StoringPlace s where s.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StoringPlace getByName(String name) {
        try {
            return (StoringPlace) em.createQuery("select s from StoringPlace s where s.storingPlaceName = :name")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StoringPlace update(StoringPlace storingPlace) {
        em.getTransaction().begin();

        try {
            StoringPlace storingPlace2 = getById(storingPlace.getId());

            storingPlace2.setStoringPlaceName(storingPlace.getStoringPlaceName());
            storingPlace2.setPackings(storingPlace.getPackings());

            em.persist(storingPlace2);
            em.getTransaction().commit();

            return storingPlace2;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            return storingPlace;
        }
    }

    @Override
    public void remove(StoringPlace storingPlace) {
        em.getTransaction().begin();

        try {
            em.remove(storingPlace);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}
