package com.fiap.autoescola.repository;
import com.fiap.autoescola.domain.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AlunoRepository extends JpaRepository<Aluno, Long> {}
