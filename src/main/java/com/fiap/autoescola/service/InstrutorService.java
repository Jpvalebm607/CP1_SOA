package com.fiap.autoescola.service;

import com.fiap.autoescola.domain.entity.Instrutor;
import com.fiap.autoescola.domain.vo.Endereco;
import com.fiap.autoescola.dto.instrutor.InstrutorCreateDTO;
import com.fiap.autoescola.dto.instrutor.InstrutorDetailDTO;
import com.fiap.autoescola.dto.instrutor.InstrutorListDTO;
import com.fiap.autoescola.dto.instrutor.InstrutorUpdateDTO;
import com.fiap.autoescola.repository.InstrutorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstrutorService {

    private final InstrutorRepository repository;

    @Transactional
    public InstrutorDetailDTO create(InstrutorCreateDTO dto) {
        Instrutor inst = Instrutor.builder()
                .nome(dto.nome())
                .email(dto.email())
                .telefone(dto.telefone())              // pode ser nulo na criação
                .cnh(dto.cnh())
                .especialidade(dto.especialidade())
                .endereco(new Endereco(
                        dto.logradouro(), dto.numero(), dto.complemento(),
                        dto.bairro(), dto.cidade(), dto.uf(), dto.cep()))
                .ativo(true)
                .build();

        repository.save(inst);
        return toDetail(inst);
    }

    @Transactional(readOnly = true)
    public Page<InstrutorListDTO> list(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable)
                .map(i -> new InstrutorListDTO(
                        i.getId(),
                        i.getNome(),
                        i.getEmail(),
                        i.getCnh(),
                        i.getEspecialidade()
                ));
    }

    @Transactional(readOnly = true)
    public InstrutorDetailDTO get(Long id) {
        Instrutor i = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado"));
        return toDetail(i);
    }

    @Transactional
    public InstrutorDetailDTO update(Long id, InstrutorUpdateDTO dto) {
        Instrutor i = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado"));

        // Regras: NÃO alterar email, CNH e Especialidade
        i.setNome(dto.nome());
        i.setTelefone(dto.telefone());
        i.setEndereco(new Endereco(
                dto.logradouro(), dto.numero(), dto.complemento(),
                dto.bairro(), dto.cidade(), dto.uf(), dto.cep()));

        return toDetail(i);
    }

    @Transactional
    public void inativar(Long id) {
        Instrutor i = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado"));
        i.setAtivo(false); // soft delete
    }

    private InstrutorDetailDTO toDetail(Instrutor i) {
        Endereco e = i.getEndereco();
        return new InstrutorDetailDTO(
                i.getId(),
                i.getNome(),
                i.getEmail(),
                i.getTelefone(),
                i.getCnh(),
                i.getEspecialidade(),
                e != null ? e.getLogradouro() : null,
                e != null ? e.getNumero() : null,
                e != null ? e.getComplemento() : null,
                e != null ? e.getBairro() : null,
                e != null ? e.getCidade() : null,
                e != null ? e.getUf() : null,
                e != null ? e.getCep() : null,
                i.getAtivo()
        );
    }
}
