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
        CategoriaModel model = new CategoriaModel();
        model.setNome("Patati");
        model.setDescricao("patata");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();

        List<CategoriaModel> lista = em.createQuery("SELECT c FROM CategoriaModel c", CategoriaModel.class).getResultList();

        System.out.println("\n ******** Sistema de Banco -- ATP 59! ********** ");

        for (CategoriaModel categoria : lista) {
            System.out.printf("\nId: %d -- || -- Nome: %s -- || -- Descrição: %s\n", categoria.getId(), categoria.getNome(), categoria.getDescricao());
        }
    }
}
