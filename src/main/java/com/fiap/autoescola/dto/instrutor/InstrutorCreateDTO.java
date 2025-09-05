package com.fiap.autoescola.dto.instrutor;

import com.fiap.autoescola.domain.enumx.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstrutorCreateDTO(
        @NotBlank String nome,
        @Email @NotBlank String email,
        String telefone,                 // pode ser nulo na criação
        @NotBlank String cnh,
        @NotNull Especialidade especialidade,
        @NotBlank String logradouro,
        String numero,
        String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String uf,
        @NotBlank String cep
) {}
