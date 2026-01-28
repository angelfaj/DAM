package com.example.examen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	private static List<Producto> inventario = new ArrayList<Producto>();
	private static long idContador = 1;
	
	@GetMapping
	public List<Producto> listar(@RequestParam(required = false) String marca) {
		if (marca == null) {
			return inventario;
		}
		
		List<Producto> filtrados = new ArrayList<Producto>();
		for (Producto p:inventario) {
			if (p.getMarca().equalsIgnoreCase(marca)) {
				filtrados.add(p);
			}
		}
		
		return filtrados;
	}
	
	@PostMapping
	public Producto guardar(@RequestBody Producto nuevo) {
		nuevo.setId(idContador++);
		inventario.add(nuevo);
		return nuevo;
	}
	
	@PutMapping("/{id}")
	public Producto actualizar(@PathVariable Long id, @RequestBody Producto cambios) {
		for (Producto p:inventario) {
			if (p.getId().equals(id)) {
				p.setPrecio(cambios.getPrecio());
				p.setStock(cambios.getStock());
				
				return p;
			}
		}
		
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String borrar(@PathVariable Long id) {
		for (Producto p:inventario) {
			if (p.getId().equals(id)) {
				inventario.remove(p);
				return "Producto borrado correctamente";
			}
		}
		
		return "Producto no encontrado";
	}
	
	
//	private static List<Producto> inventario = new ArrayList<Producto>();
//	private static long idContador = 1;
//	
//	@GetMapping
//	public List<Producto> listar(@RequestParam(required = false) String marca) {
//		if (marca == null) {
//			return inventario;
//		}
//		
//		List<Producto> productosSolicitados = new ArrayList<Producto>();
//		for (Producto p:inventario) {
//			if (p.getMarca().equalsIgnoreCase(marca)) {
//				productosSolicitados.add(p);
//			}
//		}
//		return productosSolicitados;
//	}
//	
//	@PostMapping
//	public Producto guardar(@RequestBody Producto p) {
//		p.setId(idContador++);
//		inventario.add(p);
//		return p;
//	}
//	
//	@PutMapping("/{id}")
//	public Producto actualizar(@PathVariable Long id, @RequestBody Producto cambios) {
//		for (Producto p : inventario) {
//			if (p.getId().equals(id)) {
//				p.setPrecio(cambios.getPrecio());
//				p.setStock(cambios.getStock());
//				
//				return p;
//			}
//		}
//		return null;
//	}
//	
//	@DeleteMapping("/{id}")
//	public String borrar(@PathVariable Long id) {
//		for (Producto p: inventario) {
//			if (p.getId().equals(id)) {
//				inventario.remove(p);
//				return "Objeto borrado correctamente";
//			}
//		}
//		return "Objeto no encontrado";
//	}
	
}
