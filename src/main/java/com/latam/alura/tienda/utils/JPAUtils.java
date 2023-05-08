package com.latam.alura.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    //Crea el administrador de entidades y establece la conexión con la base de datos
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tienda");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
