package com.bruna.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.bruna.model.CategoriaModel;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        this.entityManager = factory.createEntityManager();
    }

    public int create(CategoriaModel model){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(model);
        this.entityManager.getTransaction().commit();
        return model.getId();
    }

    public List<CategoriaModel> read(){
        return this.entityManager
        .createQuery("SELECT c FROM CategoriaModel c", CategoriaModel.class)
        .getResultList();
    }

    public void update(CategoriaModel model) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(model);
        this.entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        CategoriaModel model = this.entityManager.find(CategoriaModel.class, id);
        if (model != null) {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(model);
            this.entityManager.getTransaction().commit();
        }
    }
}
