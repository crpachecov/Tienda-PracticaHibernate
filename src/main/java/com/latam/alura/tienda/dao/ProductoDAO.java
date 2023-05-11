package com.latam.alura.tienda.dao;

import com.latam.alura.tienda.model.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductoDAO {

    private EntityManager em;

    public ProductoDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Producto producto){
        this.em.persist(producto);
    }

    public Producto consultarPorId(Long id){
        //busca por id y devuelve el objeto
        return this.em.find(Producto.class, id);
    }

    public List<Producto> consultarTodos(){
        return this.em.createQuery("SELECT p FROM Producto AS p", Producto.class).getResultList();
    }

    public List<Producto> consultaPorNombre(String nombre){
        return this.em.createQuery("SELECT p FROM Producto AS p WHERE p.nombre = :nombre", Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Producto> consultaPorNombreCategoria(String nombreCateg){
        return this.em.createQuery("SELECT p FROM Producto AS p WHERE p.categoria.nombre = :nombreCateg", Producto.class).setParameter("nombreCateg", nombreCateg).getResultList();
    }

    public BigDecimal consultaPrecioPorNombre(String nombre){
        return this.em.createQuery("SELECT p.precio FROM Producto AS p WHERE p.nombre = :nombre", BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }
}
