package com.tienda.tiendaservice.service;

import com.tienda.tiendaservice.dto.ProductoDto;
import com.tienda.tiendaservice.entity.Producto;
import com.tienda.tiendaservice.exception.ResourceNotFoundException;
import com.tienda.tiendaservice.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoDto crearProducto(ProductoDto dto) {

        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .build();

        producto = productoRepository.save(producto);

        return convertirADto(producto);
    }

    public List<ProductoDto> listarProductos() {

        return productoRepository.findAll()
                .stream()
                .map(this::convertirADto)
                .toList();
    }

    public ProductoDto obtenerProductoId(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        return convertirADto(producto);
    }

    private ProductoDto convertirADto(Producto producto) {

        return ProductoDto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .build();
    }
}