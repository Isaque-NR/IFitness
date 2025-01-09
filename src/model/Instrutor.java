package model;

import java.util.List;
import java.util.ArrayList;
import controller.Validadores;

public class Instrutor extends Usuario{
	
	private String senha;
	private List<Aluno> alunos;
	
	public Instrutor(String nome, int idade, String matricula, String senha) {
		super(nome,idade,matricula);
		if(Validadores.isSenhaValid(senha)) {
		this.senha=senha;
		this.alunos=new ArrayList<>();
		}else {
			System.out.println("Instrutor Invalido");
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(Validadores.isSenhaValid(senha)){
			this.senha = senha;
		}else {
			System.out.println("Insira uma Senha Válida!");
		}
				
	}
	
	public List<Aluno> getAlunos() { //falta testar esse, é usado para retornar uma consulta de todos os alunos (só o nome) associados a um instrutor
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
	
	public void atualizarTreino(Aluno aluno, Treinos treino) {
		
	}
	
	public Aluno consultarAluno(String matricula) { //metodo que vai retornar a busca de um aluno especifico (o objeto como um todo)
		for(Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}
	
	public boolean autenticarAcesso(String matricula, String senha) {
		if (matricula.equals(this.getMatricula()) && senha.equals(getSenha())) return true;
		else return false;
	}
	
	@Override
	public void exibirInformacoes() {
		System.out.println("Nome: " + this.getNome() + " Idade: " + this.getIdade() + " Matrícula: " + this.getMatricula() + " Lista de aluno: " + getAlunos());
	}
	
}
