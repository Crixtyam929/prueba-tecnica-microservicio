package com.tienda.tiendaservice.controller;

import com.tienda.tiendaservice.dto.PedidoRequestDto;
import com.tienda.tiendaservice.entity.Pedido;
import com.tienda.tiendaservice.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(@RequestBody PedidoRequestDto request) {
        return pedidoService.crearPedido(request);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable Long id) {
        return pedidoService.obtenerPedidoId(id);
    }
}