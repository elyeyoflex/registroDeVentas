package com.comercio.registroDeVentas.service;

import com.comercio.registroDeVentas.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    Producto updateProducto(Long id, Producto producto);
    Producto deleteById(Long id);
}
