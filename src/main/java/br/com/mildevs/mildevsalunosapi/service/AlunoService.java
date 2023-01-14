package br.com.mildevs.mildevsalunosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;
import br.com.mildevs.mildevsalunosapi.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	//CREATE
	public boolean insereAluno(Aluno aluno) {
		if(alunoRepository.existsById(aluno.getMatricula())) {
			return false;
		}
		alunoRepository.save(aluno);
		return true;
	}
	
	//READ
	public Aluno consultaAluno(Long matricula) {
		Optional<Aluno> alunoDb = alunoRepository.findById(matricula);
	
		if(alunoDb.isEmpty()) {
			return null;
		}
		return alunoDb.get();
	}
	
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
		
	}
	
	//UPDATE
	public boolean alteraAluno(Aluno aluno) {
		if(!alunoRepository.existsById(aluno.getMatricula())) {
			return false;
		}
		alunoRepository.save(aluno);
		return true;
	}
	
	//DELETE
	public boolean removeAluno(Long matricula) {
		if(!alunoRepository.existsById(matricula)) {
			return false;
		}
		alunoRepository.deleteById(matricula);
		return true;
	}
}
