package com.lg.reforzamiento.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Producto {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @NotBlank @Size(min = 2, max = 120)
	  private String nombre;
	  @NotNull @DecimalMin(value = "0.0", inclusive = true)
	  private BigDecimal precio;
	  @NotBlank @Size(min = 2, max = 80)
	  private String categoria;
	  @Min(0)
	  private int stock;
	  
	  public Long getId() {
		  return id;
	  }
	  public void setId(Long id) {
		  this.id = id;
	  }
	  public String getNombre() {
		  return nombre;
	  }
	  public void setNombre(String nombre) {
		  this.nombre = nombre;
	  }
	  public BigDecimal getPrecio() {
		  return precio;
	  }
	  public void setPrecio(BigDecimal precio) {
		  this.precio = precio;
	  }
	  public int getStock() {
		  return stock;
	  }
	  public void setStock(int stock) {
		  this.stock = stock;
	  }
	  public String getCategoria() {
		  return categoria;
	  }
	  public void setCategoria(String categoria) {
		  this.categoria = categoria;
	  }

	  
}
