package com.comercio.registroDeVentas.controller;

import com.comercio.registroDeVentas.entity.Producto;
import com.comercio.registroDeVentas.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        final List<Producto> productos = productoService.findAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable final Long id) {
        try{
            final Producto producto = productoService.findById(id);
            return ResponseEntity.ok(producto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody final Producto productoRequest) {
        final Producto producto = productoService.save(productoRequest);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody final Producto productoDetails) {
        try{
            final Producto producto = productoService.updateProducto(id, productoDetails);
            return ResponseEntity.ok(producto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        try{
            final Producto producto = productoService.deleteById(id);
            return ResponseEntity.ok(producto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
