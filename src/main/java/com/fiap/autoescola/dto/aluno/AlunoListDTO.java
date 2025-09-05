package com.fiap.autoescola.dto.aluno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AlunoListDTO {
    private Long id;
    private String nome;
    private String email;
    private String cidade;
    private String uf;
    private Boolean ativo;
}
