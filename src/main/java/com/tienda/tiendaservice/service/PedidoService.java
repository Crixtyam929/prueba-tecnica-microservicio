package com.tienda.tiendaservice.service;

import com.tienda.tiendaservice.dto.DetallePedidoDto;
import com.tienda.tiendaservice.dto.PedidoRequestDto;
import com.tienda.tiendaservice.dto.PedidoResponseDto;
import com.tienda.tiendaservice.entity.*;
import com.tienda.tiendaservice.exception.ResourceNotFoundException;
import com.tienda.tiendaservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    public PedidoResponseDto crearPedido(PedidoRequestDto request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setFecha(LocalDateTime.now());

        List<DetallePedido> detalles = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (DetallePedidoDto detalleDto : request.getDetalles()) {

            Producto producto = productoRepository.findById(detalleDto.getProductoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

            if (producto.getStock() < detalleDto.getCantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            BigDecimal subtotal = producto.getPrecio()
                    .multiply(BigDecimal.valueOf(detalleDto.getCantidad()));

            producto.setStock(producto.getStock() - detalleDto.getCantidad());
            productoRepository.save(producto);

            DetallePedido detalle = new DetallePedido();
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDto.getCantidad());
            detalle.setPrecio(producto.getPrecio());
            detalle.setPedido(pedido);

            detalles.add(detalle);

            total = total.add(subtotal);
        }

        pedido.setDetalles(detalles);
        pedido.setTotal(total);

        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        return convertirADto(pedidoGuardado);
    }

    public List<PedidoResponseDto> listarPedidos() {

        return pedidoRepository.findAll()
                .stream()
                .map(this::convertirADto)
                .toList();
    }

    public PedidoResponseDto obtenerPedidoId(Long id) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));

        return convertirADto(pedido);
    }

    private PedidoResponseDto convertirADto(Pedido pedido) {

        List<DetallePedidoDto> detallesDto = pedido.getDetalles()
                .stream()
                .map(detalle -> DetallePedidoDto.builder()
                        .productoId(detalle.getProducto().getId())
                        .cantidad(detalle.getCantidad())
                        .precio(detalle.getPrecio())
                        .build())
                .toList();

        return PedidoResponseDto.builder()
                .id(pedido.getId())
                .clienteId(pedido.getCliente().getId())
                .fecha(pedido.getFecha())
                .total(pedido.getTotal())
                .detalles(detallesDto)
                .build();
    }
}