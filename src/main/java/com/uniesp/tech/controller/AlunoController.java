package com.uniesp.tech.controller;

import com.uniesp.tech.service.AlunoService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AlunoController {
    private final AlunoService alunoService;
    private Scanner leitor = new Scanner(System.in);

    // Injeção via construtor
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public void exibirMenu() {
        label:
        while (true) {
            System.out.println(("======= SISTEMA ACADÊMICO UNIESP TECH ======="));
            System.out.println("1 - Cadastrar Aluno | 2 - Listar Alunos | 3 - Limpar Alunos| 4 - Sair");
            String opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    listar();
                    break;
                case "3":
                    deletar();
                    break;
                case "4":
                    System.out.println("Encerrando sistema...");
                    break label;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrar() {
        System.out.print("Nome: "); String nome = leitor.nextLine();
        System.out.print("CPF (somente números): "); String cpf = leitor.nextLine();
        try {
            alunoService.cadastrarAluno(nome, cpf);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    private void listar() {
        System.out.println("--- LISTA DE ALUNOS ---");
        alunoService.listarTodos().forEach(a ->
                System.out.println("Nome: " + a.getNome() + " | CPF: " + a.getCpf()));
    }

    private void deletar() {
        alunoService.apagarTodos();
        System.out.println("Dados apagados!");
    }
}