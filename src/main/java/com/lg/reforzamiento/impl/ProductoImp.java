package com.lg.reforzamiento.impl;

import com.lg.reforzamiento.entity.Producto;
import com.lg.reforzamiento.repository.ProductoRepository;
import com.lg.reforzamiento.service.ProductoService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductoImp implements ProductoService {

	  private final ProductoRepository repo;

	  public ProductoImp(ProductoRepository repo) { this.repo = repo; }

	  @Override 
	  public List<Producto> listar() { return repo.findAll(); }

	  @Override 
	  public Optional<Producto> buscarPorId(Long id) { return repo.findById(id); }

	  @Override 
	  public Producto crear(Producto p) { return repo.save(p); }

	  @Override 
	  public Optional<Producto> actualizar(Long id, Producto p) {
	    return repo.findById(id).map(existente -> {
	      existente.setNombre(p.getNombre());
	      existente.setCategoria(p.getCategoria());
	      existente.setPrecio(p.getPrecio());
	      existente.setStock(p.getStock());
	      return repo.save(existente);
	    });
	  }

	  @Override public boolean eliminar(Long id) {
	    if (repo.existsById(id)) { repo.deleteById(id); return true; }
	    return false;
	  }

	  @Override public List<Producto> buscarPorNombre(String nombre) {
	    return repo.findByNombreContainingIgnoreCase(nombre);
	  }

	  @Override public List<Producto> buscarPorCategoria(String categoria) {
	    return repo.findByCategoriaIgnoreCase(categoria);
	  }
	}