package com.ista.gadi.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.gadi.Entity.Producto;
import com.ista.gadi.Services.ProductoService;


@RestController
@RequestMapping("/api")

public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/producto")
	public List<Producto> index() {
		return productoService.findAll();
	}

	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> show(@PathVariable Long id) {
		Producto listaEncontrada = productoService.findbyId(id);
		if(listaEncontrada==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(listaEncontrada);
	}

	@PostMapping("/producto")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Producto> create(@RequestBody Producto producto) {
		if(producto.getDescripcion().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		  if(producto.getCantidad() == null || producto.getCantidad() <= 0) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		    }
		    
		    if(producto.getPrecio()==null) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		    }
		  
		    
		if(producto.getCantidad()>0 && producto.getPrecio() > 0) {
			producto.setSubtotal(producto.getPrecio()*producto.getCantidad());
			if(producto.getSubtotal()>50) {
				producto.setSubtotal(producto.getSubtotal()-(producto.getSubtotal()*0.10));
				producto.setTotal(producto.getSubtotal()+(producto.getSubtotal()*0.12));
				
			}else {
				producto.setTotal(producto.getSubtotal()+(producto.getSubtotal()*0.12));
			}
				
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Producto listaGuardada = productoService.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(listaGuardada);
		
	}

	@PutMapping("/producto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto listaProducto = productoService.findbyId(id);
		if(listaProducto==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		if(listaProducto.getDescripcion().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		  if(listaProducto.getCantidad() == null || listaProducto.getCantidad() <= 0) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		    }
		    
		    if(listaProducto.getPrecio()==null) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		    }
		    String precioStr = String.valueOf(producto.getPrecio());
		    if(!precioStr.matches("\\d+(\\.\\d{1,2})?")) {
		     
		    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		    }
		    
		if(listaProducto.getCantidad()>0 && listaProducto.getPrecio()>0) {
			listaProducto.setSubtotal(producto.getPrecio()*producto.getCantidad());
			if(producto.getSubtotal()>50) {
				listaProducto.setSubtotal(producto.getSubtotal()-(producto.getSubtotal()*0.10));
				listaProducto.setTotal(producto.getSubtotal()+(producto.getSubtotal()*0.12));
				
			}else {
				listaProducto.setTotal(producto.getSubtotal()+(producto.getSubtotal()*0.12));
			}
				
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		listaProducto.setDescripcion(producto.getDescripcion());
		listaProducto.setCantidad(producto.getCantidad());
		listaProducto.setPrecio(producto.getPrecio());
		Producto listaGuardada =  productoService.save(listaProducto);
		return ResponseEntity.ok(listaGuardada);
	}

	@DeleteMapping("/producto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Producto listaEncontrada = productoService.findbyId(id);
		if(listaEncontrada==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		productoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
