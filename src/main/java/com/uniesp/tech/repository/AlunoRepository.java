package com.uniesp.tech.repository;

import com.uniesp.tech.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    List<Aluno> listaAlunos = new ArrayList<>();

    public void salvarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(listaAlunos);
    }

    public void deletarAlunos() {
        listaAlunos.clear();
    }
}