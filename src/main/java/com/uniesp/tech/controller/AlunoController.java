package com.uniesp.tech.controller;

import com.uniesp.tech.model.Aluno;
import com.uniesp.tech.service.AlunoService;
import com.uniesp.tech.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos") // URL base: http://localhost:8080/alunos
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    // Listar todos (Antiga opção de "Visualizar Alunos")
    @GetMapping
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // Cadastrar (Antiga opção de "Cadastrar Aluno")
    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return repository.save(aluno);
    }

    // Buscar por ID (Nova funcionalidade útil)
    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Deletar (Antiga opção de "Remover Aluno")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}