package com.tienda.tiendaservice.dto;

import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @Email(message = "Email inválido.")
    private String email;

    private String telefono;

}