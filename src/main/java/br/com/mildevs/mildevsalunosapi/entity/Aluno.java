package br.com.mildevs.mildevsalunosapi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aluno {

	@Id
	private long matricula;

	@Column(nullable = false)
	private String nome;
	
	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate dataNascimento;

	@Column(unique = true)
	private String cpf;
	
	@Column(name = "valor_mensalidade", nullable = false)
	private Float valorMensalidae;
	
	public Aluno() {
		
	}
	
	
	public Aluno(long matricula, String nome, LocalDate dataNascimento, String cpf, Float valorMensalidae) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.valorMensalidae = valorMensalidae;
	}


	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Float getValorMensalidae() {
		return valorMensalidae;
	}
	public void setValorMensalidae(Float valorMensalidae) {
		this.valorMensalidae = valorMensalidae;
	}

}
