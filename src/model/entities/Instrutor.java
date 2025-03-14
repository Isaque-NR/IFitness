package model.entities;

import java.util.List;

import model.util.Validadores;

import java.io.Serializable;
import java.util.ArrayList;
import model.util.Excecoes;

public class Instrutor extends Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String senha;
	private List<Aluno> alunos;

	
	public Instrutor(String nome, int idade, String matricula, String senha) throws Excecoes {
		super(nome,idade,matricula);
		if(Validadores.isSenhaValid(senha)) {
		this.senha=senha;
		this.alunos=new ArrayList<>();
		}else {
		     throw new Excecoes ("Instrutor inválido");
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
			this.senha = senha;			
	}
	
	public List<Aluno> getAlunos() { 
		return alunos;
	}
    
	public void addAlunoInstrutor(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) { 
		alunos.remove(aluno);
	}

	public void associarTreino(Aluno aluno, Treinos treino) {
		aluno.getMeusTreinos().add(treino);
	}
	
	public void dissociarTreino(Aluno aluno, Treinos treino) {
		aluno.getMeusTreinos().remove(treino);
	}
	
	public Aluno consultarAluno(String matricula) { 
		for(Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}
	
}
