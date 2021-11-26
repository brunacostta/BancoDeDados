package com.bruna;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bruna.dao.CategoriaDao;
import com.bruna.dao.CategoriaModelo;
import com.bruna.model.Categoria;
import com.bruna.model.CategoriaModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CategoriaDao dao = new CategoriaDao();
        CategoriaModel model = new CategoriaModel();
        CategoriaModelo cm = new CategoriaModelo();
        Categoria cat = new Categoria();

        //model.setId(44);
        //model.setNome("teste 26/11");
        //model.setDescricao("teste daooooooo");

        //dao.create(model);

        // dao.update(model);

        cat.setNome("Bruna");
        cat.setDescricao("Nova");

        cm.create(cat);

        System.out.println("\n ******** Sistema de Banco -- ATP 59! ********** ");

        for (CategoriaModel categoria : dao.read()) {
            System.out.printf("\nId: %d -- || -- Nome: %s -- || -- Descrição: %s\n", categoria.getId(), categoria.getNome(), categoria.getDescricao());
        }
    }
}
