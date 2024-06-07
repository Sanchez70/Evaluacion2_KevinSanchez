package com.ista.gadi.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long condigo;
	@Column(length = 100) 
	private String descripcion;
	@DecimalMin(value = "0.01", inclusive = true)
    @Digits(integer = 10,fraction = 2)
	private Double precio;
	private Integer cantidad;
	@DecimalMin(value = "0.01", inclusive = true)
    @Digits(integer = 10,fraction = 2)
	private Double subtotal;
	@DecimalMin(value = "0.01", inclusive = true)
    @Digits(integer = 10,fraction = 2)
	private Double total;
	public Long getCondigo() {
		return condigo;
	}
	public void setCondigo(Long condigo) {
		this.condigo = condigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	

}
