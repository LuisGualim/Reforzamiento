package com.lg.reforzamiento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lg.reforzamiento.entity.Producto;
import com.lg.reforzamiento.service.ProductoService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	private final ProductoService service;

	  public ProductoController(ProductoService service) { this.service = service; }
	  
	  @GetMapping
	  public ResponseEntity<List<Producto>> listar() {
		    return ResponseEntity.ok(service.listar());
		  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<Producto> obtener(@PathVariable Long id) {
	    return service.buscarPorId(id)
	        .map(ResponseEntity::ok)
	        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	  }
	  
	  @PostMapping
	  public ResponseEntity<Producto> crear(@Valid @RequestBody Producto producto) {
	    try {
	      Producto guardado = service.crear(producto);
	      return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
	    } catch (Exception e) {                           // try-catch requerido
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	  }
	  
	  @PutMapping("/{id}")
	  public ResponseEntity<Producto> actualizar(@PathVariable Long id, @Valid @RequestBody Producto producto) {
	    try {
	      return service.actualizar(id, producto)
	          .map(ResponseEntity::ok)
	          .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    } catch (Exception e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
	    try {
	      boolean eliminado = service.eliminar(id);
	      return eliminado ? ResponseEntity.noContent().build()
	                       : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    } catch (Exception e) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	  }
	  
	  @GetMapping("/search")
	  public ResponseEntity<List<Producto>> buscarPorNombre(@RequestParam String nombre) {
	    return ResponseEntity.ok(service.buscarPorNombre(nombre));
	  }

	  @GetMapping("/categoria/{categoria}")
	  public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable String categoria) {
	    return ResponseEntity.ok(service.buscarPorCategoria(categoria));
	  }

}
