package model;

import java.util.List;
import java.util.ArrayList;

public class Instrutor extends Usuario{
	
	private String senha;
	private List<Aluno> alunos;
	
	public Instrutor(String nome, int idade, String matricula, String senha) {
		super(nome,idade,matricula);
		this.senha=senha;
		this.alunos=new ArrayList<>();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Aluno> getAlunos() { // na iterface visual listar alunos chama esse get
		return alunos;
	}
    
	public void cadastrarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void adicionarTreino(Aluno aluno, Treinos treino) {
		aluno.getTreinos().add(treino);
	}
	
	public void removerTreino(Aluno aluno, Treinos treino) {
		aluno.getTreinos().remove(treino);
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
