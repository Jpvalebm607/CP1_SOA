package com.fiap.autoescola.dto.instrutor;

import com.fiap.autoescola.domain.enumx.Especialidade;

public record InstrutorDetailDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep,
        Boolean ativo
) {}
