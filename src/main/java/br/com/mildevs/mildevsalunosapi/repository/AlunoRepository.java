package br.com.mildevs.mildevsalunosapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mildevs.mildevsalunosapi.entity.Aluno;

@Repository //interface de comunicação com o banco de dados 
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	Optional<Aluno> findByCpfAndValorMensalidade(String cpf, float valorMensalidade);
		
	
	
}
