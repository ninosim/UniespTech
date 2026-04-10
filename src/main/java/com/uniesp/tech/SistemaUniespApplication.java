package com.uniesp.tech;

import com.uniesp.tech.controller.AlunoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaUniespApplication {

	private final AlunoController alunoController;

	public SistemaUniespApplication(AlunoController alunoController) {
		this.alunoController = alunoController;
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaUniespApplication.class, args);
	}
}