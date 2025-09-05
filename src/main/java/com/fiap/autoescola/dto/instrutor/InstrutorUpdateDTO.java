package com.fiap.autoescola.dto.instrutor;

import jakarta.validation.constraints.NotBlank;

public record InstrutorUpdateDTO(
        @NotBlank String nome,
        String telefone,
        @NotBlank String logradouro,
        String numero,
        String complemento,
        @NotBlank String bairro,
        @NotBlank String cidade,
        @NotBlank String uf,
        @NotBlank String cep
) {}
