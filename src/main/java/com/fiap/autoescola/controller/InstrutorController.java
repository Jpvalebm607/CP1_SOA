package com.fiap.autoescola.controller;

import com.fiap.autoescola.dto.instrutor.InstrutorCreateDTO;
import com.fiap.autoescola.dto.instrutor.InstrutorDetailDTO;
import com.fiap.autoescola.dto.instrutor.InstrutorListDTO;
import com.fiap.autoescola.dto.instrutor.InstrutorUpdateDTO;
import com.fiap.autoescola.service.InstrutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instrutores")
@RequiredArgsConstructor
public class InstrutorController {

    private final InstrutorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstrutorDetailDTO create(@RequestBody @Valid InstrutorCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public Page<InstrutorListDTO> list(
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.list(pageable);
    }

    @GetMapping("/{id}")
    public InstrutorDetailDTO get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public InstrutorDetailDTO update(@PathVariable Long id, @RequestBody @Valid InstrutorUpdateDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.inativar(id); // soft delete
    }
}
