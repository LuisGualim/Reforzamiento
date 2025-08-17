package com.lg.reforzamiento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lg.reforzamiento.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	  List<Producto> findByNombreContainingIgnoreCase(String nombre);
	  List<Producto> findByCategoriaIgnoreCase(String categoria);       
}