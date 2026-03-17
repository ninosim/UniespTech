package com.uniesp.tech.service;

import com.uniesp.tech.model.Aluno;
import com.uniesp.tech.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AlunoService {

    private AlunoRepository alunoRepository = new AlunoRepository();

    public void cadastrarAluno(String nome, String cpf) throws Exception {
            if (nome == null || nome.isEmpty()) {
                throw new Exception("Nome não pode ser vazio!");
            }
            if (cpf.length() != 11) {
                throw new Exception("CPF inválido! O número deve ter 11 dígitos.");
            }

            Aluno novoAluno = new Aluno(nome, cpf);
            alunoRepository.salvarAluno(novoAluno);
        }

        public List<Aluno> listarTodos() {
            return alunoRepository.listarAlunos();
        }

        public void apagarTodos() {
            alunoRepository.deletarAlunos();
        }
    }