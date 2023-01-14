package br.com.mildevs.mildevsalunosapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import br.com.mildevs.mildevsalunosapi.service.AlunoService;
//controller é a porta de entrada da API, atraves dele que os dados irao trafegar
@RestController 
@RequestMapping("/alunos")
public class AlunoController {

	//atualização usando o aluno service ao inves do repository
	@Autowired //não necessario
	AlunoService alunoService;
	
	@ResponseStatus(code = HttpStatus.CREATED) //ao inves de status 200, irá aparecer esse
	@PostMapping //diz que esse metodo, quando chamar na requisição (no postman)chamando o metodo post irá cair aqui
	public boolean insereAluno(@RequestBody Aluno aluno) { //request...o corpo do aluno
		return alunoService.insereAluno(aluno); //metodo guarda aluno no banco de dados
	}
	
	//uma consulta: passa o path, path variable diz que a matricula é a matricula que vem n url
	@GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno buscaAluno(@PathVariable Long matricula) {
		return alunoService.consultaAluno(matricula);
	}
	
	//listagem, se der um get sem nada vai achar os alunos no banco
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})//tipo de arquivo retornado, pode ser xml...
	public List<Aluno> buscaAlunos() {
		return alunoService.listaAlunos();
	}
	
	@DeleteMapping(path = "/{matricula}")
	public boolean removeAluno(@PathVariable Long matricula) {
		return alunoService.removeAluno(matricula);
	}
}
