package com.tienda.tiendaservice.controller;

import com.tienda.tiendaservice.dto.PedidoRequestDto;
import com.tienda.tiendaservice.dto.PedidoResponseDto;
import com.tienda.tiendaservice.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public PedidoResponseDto crearPedido(@Valid @RequestBody PedidoRequestDto request) {
        return pedidoService.crearPedido(request);
    }

    @GetMapping
    public List<PedidoResponseDto> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public PedidoResponseDto obtenerPedidoPorId(@PathVariable Long id) {
        return pedidoService.obtenerPedidoId(id);
    }
}