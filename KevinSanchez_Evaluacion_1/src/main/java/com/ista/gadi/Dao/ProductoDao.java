package com.ista.gadi.Dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.gadi.Entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
