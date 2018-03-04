package ru.myproject.firstaidkit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myproject.firstaidkit.dao.PackingDAO;
import ru.myproject.firstaidkit.entity.Drug;
import ru.myproject.firstaidkit.entity.Packing;
import ru.myproject.firstaidkit.entity.StoringPlace;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.List;

@Service
public class PackingServiceDAO implements PackingDAO {

    private EntityManager em;

    @Autowired
    public PackingServiceDAO(EntityManagerFactory factory) {
        em = factory.createEntityManager();
    }


    @Override
    public void add(Packing packing) {
        em.getTransaction().begin();

        try {
            em.persist(packing);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void createPacking(Drug drug, String manufacturer, long amount,
                              long dosage, Date expirationDate,
                              List<StoringPlace> storingPlaces) {

        Packing packing = new Packing(drug, manufacturer, amount, dosage,
                expirationDate, storingPlaces);

        add(packing);

    }

    @Override
    public List<Packing> getAll() {
        try {
            String sql = "select p from Packing p";
            List<Packing> list = em.createQuery(sql).getResultList();
            return list;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Packing getById(long id) {
        try {
            return (Packing) em.createQuery("select p from Packing p where p.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Packing getByName(String name) {
        try {
            return (Packing) em.createQuery("select p from Packing p where p.drug.drugName = :name")
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Packing update(Packing packing) {
        em.getTransaction().begin();

        try {
            Packing packing2 = getById(packing.getId());

            packing2.setDrug(packing.getDrug());
            packing2.setManufacturer(packing.getManufacturer());
            packing2.setAmount(packing.getAmount());
            packing2.setDosage(packing.getDosage());
            packing2.setExpirationDate(packing.getExpirationDate());
            packing2.setStoringPlaces(packing.getStoringPlaces());

            em.persist(packing2);
            em.getTransaction().commit();

            return packing2;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            return packing;
        }
    }

    @Override
    public void remove(Packing packing) {
        em.getTransaction().begin();

        try {
            em.remove(packing);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}
