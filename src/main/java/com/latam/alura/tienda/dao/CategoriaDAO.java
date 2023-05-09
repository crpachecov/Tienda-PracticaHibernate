package com.latam.alura.tienda.dao;

import com.latam.alura.tienda.model.Categoria;
import com.latam.alura.tienda.model.Producto;

import javax.persistence.EntityManager;

public class CategoriaDAO {

    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Categoria categoria) {
        this.em.persist(categoria);
    }
}
