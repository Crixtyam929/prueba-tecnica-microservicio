package com.tienda.tiendaservice.controller;

import com.tienda.tiendaservice.dto.ProductoDto;
import com.tienda.tiendaservice.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ProductoDto crearProducto(@Valid @RequestBody ProductoDto productoDto) {
        return productoService.crearProducto(productoDto);
    }

    @GetMapping
    public List<ProductoDto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public ProductoDto obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoId(id);
    }
}