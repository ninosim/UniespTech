package com.uniesp.tech.repository;

import com.uniesp.tech.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> listaAlunos = new ArrayList<>();

    public default void salvarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public default List<Aluno> listarAlunos() {
        return new ArrayList<>(listaAlunos);
    }

    public default void deletarAlunos() {
        listaAlunos.clear();
    }
}