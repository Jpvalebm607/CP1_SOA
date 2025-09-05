package com.fiap.autoescola.service;

import com.fiap.autoescola.domain.entity.Aluno;
import com.fiap.autoescola.domain.vo.Endereco;
import com.fiap.autoescola.dto.aluno.AlunoCreateDTO;
import com.fiap.autoescola.dto.aluno.AlunoDetailDTO;
import com.fiap.autoescola.dto.aluno.AlunoListDTO;
import com.fiap.autoescola.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    @Transactional
    public AlunoDetailDTO create(AlunoCreateDTO dto) {   // <- assinatura que o controller espera
        Endereco end = Endereco.builder()
                .logradouro(dto.getLogradouro())
                .numero(dto.getNumero())
                .complemento(dto.getComplemento())
                .bairro(dto.getBairro())
                .cidade(dto.getCidade())
                .uf(dto.getUf())
                .cep(dto.getCep())
                .build();

        Aluno aluno = Aluno.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .endereco(end)
                .ativo(true)
                .build();

        Aluno saved = repository.save(aluno);

        return AlunoDetailDTO.builder()
                .id(saved.getId())
                .nome(saved.getNome())
                .email(saved.getEmail())
                .telefone(saved.getTelefone())
                .logradouro(saved.getEndereco() != null ? saved.getEndereco().getLogradouro() : null)
                .numero(saved.getEndereco() != null ? saved.getEndereco().getNumero() : null)
                .complemento(saved.getEndereco() != null ? saved.getEndereco().getComplemento() : null)
                .bairro(saved.getEndereco() != null ? saved.getEndereco().getBairro() : null)
                .cidade(saved.getEndereco() != null ? saved.getEndereco().getCidade() : null)
                .uf(saved.getEndereco() != null ? saved.getEndereco().getUf() : null)
                .cep(saved.getEndereco() != null ? saved.getEndereco().getCep() : null)
                .ativo(saved.getAtivo())
                .build();
    }

    @Transactional(readOnly = true)
    public Page<AlunoListDTO> list(Pageable pageable) {
        return repository.findAll(pageable).map(a ->
            AlunoListDTO.builder()
                .id(a.getId())
                .nome(a.getNome())
                .email(a.getEmail())
                .cidade(a.getEndereco() != null ? a.getEndereco().getCidade() : null)
                .uf(a.getEndereco() != null ? a.getEndereco().getUf() : null)
                .ativo(a.getAtivo())
                .build()
        );
    }
}
