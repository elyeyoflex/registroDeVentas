package com.comercio.registroDeVentas.service.implement;

import com.comercio.registroDeVentas.entity.Producto;
import com.comercio.registroDeVentas.repository.ProductoRepository;
import com.comercio.registroDeVentas.service.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(final Long id) {
        return productoRepository.findById(id).orElseThrow(()->new EntityNotFoundException(String.format("ProductoId %s no encontrado", id)));
    }

    @Override
    public Producto save(final Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(final Long id, final Producto producto) {
        final Producto producto1 = findById(id);
        return save(producto1.toBuilder()
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precioUnitario(producto.getPrecioUnitario())
                .precioMayorista(producto.getPrecioMayorista())
                .build());
    }

    @Override
    public Producto deleteById(final Long id) {
        final Producto producto = findById(id);
        return save(producto.toBuilder().fechaBaja(LocalDateTime.now()).build());
    }
}
