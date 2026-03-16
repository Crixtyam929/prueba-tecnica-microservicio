package com.tienda.tiendaservice.controller;

import com.tienda.tiendaservice.dto.ClienteDto;
import com.tienda.tiendaservice.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ClienteDto crearCliente(@Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.crearCliente(clienteDto);
    }

    @GetMapping
    public List<ClienteDto> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteDto obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClienteId(id);
    }
}