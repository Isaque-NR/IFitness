package model;

import controller.Validadores;

public class Exercicio {
	
	private String nome;
	private double carga;
	private int repeticoes;
	private int series;
	private int duracao; // min
	private String itensidade; // leve,moderado,itenso
	
	// Construtor Exercicos de Musculação
	public Exercicio(String nome, double carga, int repeticoes, int series) {
		if(Validadores.isExercicioMusculacaoValid(nome, carga, repeticoes, series)) {
		this.nome=nome;
		this.carga=carga;
		this.repeticoes=repeticoes;
		this.series=series;
		}else {
			System.out.println("Exercicio não valido");
		}
	}
	
	// Construtor Exercicios Cardio
	
	public Exercicio (String nome, int duracao, String itensidade) {
		if(Validadores.isExercicioCardioValid(nome, duracao, itensidade)) {
		this.nome=nome;
		this.duracao=duracao;
		this.itensidade=itensidade;
		}else {
			System.out.println("Exercicio Invalido");
		}
	}

	//Criar um método na classe Instrutor que permita ele fazer alterações nos exercicios de um treino caso deseje (usando get e set)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(Validadores.isNomeValid(nome)) {
				this.nome = nome;
		}else {
			System.out.println("Insira um nome válido!");
		}
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		if(carga>0 && carga<= 1000) {
				this.carga = carga;
		}else {
			System.out.println("Insira uma carga Válida!");
		}
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		if(repeticoes>=1 && repeticoes<=500) {
				this.repeticoes = repeticoes;
		}else {
			System.out.println("Insira repeticoes Válidas!");
		}
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		if(series>=1 && series<=200) {
				this.series = series;
		}else {
			System.out.println("Insira series Válidas!");
		}
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		if(duracao>=1 && duracao <=240) {
				this.duracao = duracao;
		}else{
			System.out.println("Insira uma duração válida!");
		}
	}

	public String getItensidade() {
		return itensidade;
	}

	public void setItensidade(String itensidade) {
		if(Validadores.isItensidadeValid(itensidade)) {
		this.itensidade = itensidade;
		}else {
			System.out.println("Insira uma itensidade Válida!");
		}
	}

	@Override
	public String toString() {
		return  nome + ", carga: " + carga + ", repeticoes; " + repeticoes + ", series: " + series
				+ ", duracao: " + duracao + ", itensidade: " + itensidade ;
	}
	
}
