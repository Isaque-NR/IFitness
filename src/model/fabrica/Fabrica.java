package model.fabrica;

import java.util.List;

import model.entities.*;

public class Fabrica {

	public static Aluno getAluno(String nome, int idade, String matricula, String sexo, double peso, double altura,
							String limitacoesFisicasOuSaude)
	{
		return new Aluno (nome, idade, matricula, sexo, peso, altura, limitacoesFisicasOuSaude);
	}
	
    public static Exercicio getExercicioCardio(String nome, int duracao, String intensidade) {
		return new Exercicio (nome, duracao, intensidade);
	}
	
	public static Exercicio getExercicioMusculacao(String nome, double carga, int repeticoes, int series) {
		return new Exercicio (nome, carga, repeticoes, series);
	}
	
	public static Instrutor getInstrutor (String nome, int idade, String matricula, String senha) {
		return new Instrutor(nome, idade, matricula, senha);
	}
	
	public static Treinos getTreino (String nome, List <Exercicio> exercicios) {
		return new Treinos (nome,exercicios);
	}
}
