package com.latam.alura.tienda.prueba;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.model.Categoria;
import com.latam.alura.tienda.model.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDeProducto {

    public static void main(String[] args) {
        Categoria celulares = new Categoria("Celulares");
        Producto celular = new Producto("Xiaomi Redmi Note 8", "Celular Xiaomi Redmi Note 8 Usado", new BigDecimal("1500000"), celulares );

        //Realiza las operaciones de persistencia en la base de datos
        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        //Comienza la transacción
        em.getTransaction().begin();
        //Guarda el objeto en la base de datos
//        em.persist(celular);
        em.persist(celulares);
        celulares.setNombre("Softwares");
//        categoriaDAO.guardar(celulares);
//        productoDAO.guardar(celular);
        //Confirma la transacción
//        em.getTransaction().commit(); //Guarada en la base de datos los datos que se envian
        em.flush();//Guarada pero tenemos la opurtinada de modificar si hay un error
        //Cierra el administrador de entidades
//        em.close();//Cierra la conexión con la base de datos
        em.clear();//Limpia el administrador de entidades y no cierra la conexion

        celulares = em.merge(celulares);//Trae la entidad de la base de datos y la actualiza
        celulares.setNombre("Libros");//Actualiza el nombre de la categoria

        em.flush();
        em.clear();

        celulares = em.merge(celulares);

//        categoriaDAO.actualizar(celulares);//Guarda los cambios en la base de datos
        em.remove(celulares);//Elimina la categoria de la base de datos
        em.flush();
    }

}
