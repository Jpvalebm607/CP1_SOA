package com.fiap.autoescola.controller;

import com.fiap.autoescola.dto.aluno.AlunoCreateDTO;
import com.fiap.autoescola.dto.aluno.AlunoDetailDTO;
import com.fiap.autoescola.dto.aluno.AlunoListDTO;
import com.fiap.autoescola.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDetailDTO create(@RequestBody @Valid AlunoCreateDTO dto) {
        return service.create(dto); // <- compila se o service tiver o método abaixo
    }

    @GetMapping
    public Page<AlunoListDTO> list(
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.list(pageable);
    }
}
