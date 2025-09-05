package com.fiap.autoescola.dto.instrutor;

import com.fiap.autoescola.domain.enumx.Especialidade;

public record InstrutorListDTO(
        Long id,
        String nome,
        String email,
        String cnh,
        Especialidade especialidade
) {}
