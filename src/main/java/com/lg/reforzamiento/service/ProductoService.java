package com.lg.reforzamiento.service;

import com.lg.reforzamiento.entity.Producto;
import java.util.*;

public interface ProductoService {

	  List<Producto> listar();
	  Optional<Producto> buscarPorId(Long id);              
	  Producto crear(Producto p);
	  Optional<Producto> actualizar(Long id, Producto p);
	  boolean eliminar(Long id);
	  List<Producto> buscarPorNombre(String nombre);
	  List<Producto> buscarPorCategoria(String categoria);
	}
