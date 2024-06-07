package com.ista.gadi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.gadi.Dao.ProductoDao;
import com.ista.gadi.Entity.Producto;
@Service
public class ProductoServicelmpl implements ProductoService{

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public Producto findbyId(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoDao.deleteById(id);
	}
	

}
