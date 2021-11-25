package com.bruna;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bruna.model.CategoriaModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Sistema de banco!" );
        CategoriaModel model = new CategoriaModel();
        model.setNome("Teste JPA");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        EntityManager em = factory.createEntityManager();

        
        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();

        List<CategoriaModel> lista = em.createQuery("SELECT c FROM Categoria c", CategoriaModel.class).getResultList();

        for (CategoriaModel categoria : lista) {
            System.out.printf("%d - %s\n",categoria.getNome());
        }
    }
}