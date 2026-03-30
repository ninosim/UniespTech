package com.uniesp.tech;

import com.uniesp.tech.controller.AlunoController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaUniespApplication implements CommandLineRunner {

	private final AlunoController alunoController;

	public SistemaUniespApplication(AlunoController alunoController) {
		this.alunoController = alunoController;
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaUniespApplication.class, args);
	}

	@Override
	public void run(String... args) {
		alunoController.exibirMenu();
	}
}