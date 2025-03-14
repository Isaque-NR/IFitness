package model.entities;

import java.io.Serializable;

import model.util.Excecoes;
import model.util.Validadores;

public class Usuario implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int idade;
	private String matricula;
	
	public Usuario(String nome, int idade, String matricula) throws Excecoes {
		if(Validadores.isNomeValid(nome) && Validadores.isIdadeValid(idade) 
		   && Validadores.isMatriculaValid(matricula)) {
			this.nome=nome;
			this.idade=idade; 
			this.matricula=matricula;
		
		} else {
			throw new Excecoes ("Usuario inválido");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(Validadores.isNomeValid(nome)) {
			this.nome = nome;
		}
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if(Validadores.isIdadeValid(idade)) {
			this.idade = idade;
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if(Validadores.isMatriculaValid(matricula)){
			this.matricula=matricula;
		}
	}
	
}
