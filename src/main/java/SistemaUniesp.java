import com.uniesp.tech.controller.AlunoController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaUniesp implements CommandLineRunner {private final AlunoController alunoController;

    // O Spring injeta o Controller aqui automaticamente
    public SistemaUniesp(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    public static void main(String[] args) {
        SpringApplication.run(SistemaUniesp.class, args);
    }

    @Override
    public void run(String... args) {
        // Agora o Spring já resolveu todas as dependências (Service e Repository)
        alunoController.exibirMenu();
    }
}