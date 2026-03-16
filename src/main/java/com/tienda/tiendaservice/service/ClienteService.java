package com.tienda.tiendaservice.service;

import com.tienda.tiendaservice.dto.ClienteDto;
import com.tienda.tiendaservice.entity.Cliente;
import com.tienda.tiendaservice.exception.ResourceNotFoundException;
import com.tienda.tiendaservice.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteDto crearCliente(ClienteDto dto) {

        Cliente cliente = Cliente.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .build();

        cliente = clienteRepository.save(cliente);

        return ClienteDto.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .email(cliente.getEmail())
                .telefono(cliente.getTelefono())
                .build();
    }

    public List<ClienteDto> listarClientes() {

        return clienteRepository.findAll()
                .stream()
                .map(cliente -> ClienteDto.builder()
                        .id(cliente.getId())
                        .nombre(cliente.getNombre())
                        .email(cliente.getEmail())
                        .telefono(cliente.getTelefono())
                        .build())
                .toList();
    }

    public ClienteDto obtenerClienteId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        return ClienteDto.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .email(cliente.getEmail())
                .telefono(cliente.getTelefono())
                .build();
    }
}