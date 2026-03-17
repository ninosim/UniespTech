package com.uniesp.tech;

import com.uniesp.tech.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoServiceTest {
    private AlunoService alunoService;

    @BeforeEach
    void setup() {
        // Inicializa o serviço antes de cada teste
        alunoService = new AlunoService();
    }

    @Test
    @DisplayName("Não deve cadastrar aluno com nome vazio")
    void validarNomeVazio() {
        // O método assertThrows verifica se a exceção correta é lançada
        Exception exception = assertThrows(Exception.class, () -> {
            alunoService.cadastrarAluno("", "12345678901");
        });

        assertEquals("Nome não pode ser vazio!", exception.getMessage());
    }

    @Test
    @DisplayName("Não deve cadastrar CPF com tamanho diferente de 11")
    void validarCpfInvalido() {
        Exception exception = assertThrows(Exception.class, () -> {
            alunoService.cadastrarAluno("André", "123");
        });

        assertEquals("CPF inválido! O número deve ter 11 dígitos.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve cadastrar aluno com sucesso quando dados são válidos")
    void cadastrarComSucesso() {
        // assertDoesNotThrow garante que o código execute sem erros
        assertDoesNotThrow(() -> {
            alunoService.cadastrarAluno("Nino Xavier Simas", "11122233344");
        });

        // Verificamos se a lista agora tem 1 aluno
        assertEquals(1, alunoService.listarTodos().size());
        assertEquals("Nino Xavier Simas", alunoService.listarTodos().get(0).getNome());
    }
}