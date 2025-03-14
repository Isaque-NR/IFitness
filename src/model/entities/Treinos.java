package model.entities;

import java.util.List;

import model.util.Excecoes;
import model.util.Validadores;

import java.io.Serializable;


public class Treinos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private List<Exercicio> exercicios;
	
	public Treinos(String nome, List<Exercicio> exercicios) throws Excecoes {
		if(Validadores.isNomeTreinoValid(nome)) {
		this.nome=nome;
		this.exercicios=exercicios;
		}else {
			throw new Excecoes ("Treino inválido");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(Validadores.isNomeTreinoValid(nome)) {
		this.nome = nome;
		}
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	
	public void setExercicios(List<Exercicio> exercicios) {
	    this.exercicios = exercicios;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\n" + " Exercicios: \n" + exercicios.toString();
	}
	
}
