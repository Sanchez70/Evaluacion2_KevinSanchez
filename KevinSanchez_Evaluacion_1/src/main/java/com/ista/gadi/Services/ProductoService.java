package com.ista.gadi.Services;

import java.util.List;

import com.ista.gadi.Entity.Producto;
public interface ProductoService {
	public List<Producto> findAll();

	public Producto save(Producto producto);

	public Producto findbyId(Long id);

	public void delete(Long id);

}
