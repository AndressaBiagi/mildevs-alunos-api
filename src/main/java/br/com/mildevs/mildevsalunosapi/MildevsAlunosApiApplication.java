package br.com.mildevs.mildevsalunosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//quando roda a aplicação, uma tabelé criada no bd, com os dados excritos na classe aluno
@SpringBootApplication
public class MildevsAlunosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MildevsAlunosApiApplication.class, args);
	}

}
