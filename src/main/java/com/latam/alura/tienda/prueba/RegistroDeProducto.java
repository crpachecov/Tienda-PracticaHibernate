package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.model.Categoria;
import com.latam.alura.tienda.model.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDeProducto {

    public static void main(String[] args) {

        Producto celular = new Producto("Xiaomi Redmi Note 8", "Celular Xiaomi Redmi Note 8 Usado", new BigDecimal("1500000"), Categoria.CELULARES);

        //Realiza las operaciones de persistencia en la base de datos
        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(em);

        //Comienza la transacción
        em.getTransaction().begin();
        //Guarda el objeto en la base de datos
//        em.persist(celular);
        productoDAO.guardar(celular);
        //Confirma la transacción
        em.getTransaction().commit();
        //Cierra el administrador de entidades
        em.close();
    }

}
