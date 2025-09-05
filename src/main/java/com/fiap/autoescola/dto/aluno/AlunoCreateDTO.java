package com.fiap.autoescola.dto.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AlunoCreateDTO {

    @NotBlank
    private String nome;

    @Email @NotBlank
    private String email;

    @NotBlank @Size(min = 8)
    private String telefone;

    @NotBlank private String logradouro;
    @NotBlank private String numero;
    private String complemento;
    @NotBlank private String bairro;
    @NotBlank private String cidade;

    @NotBlank @Size(min = 2, max = 2)
    private String uf;

    @NotBlank @Size(min = 8, max = 9)
    private String cep;
}
