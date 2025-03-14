package model.entities;

import java.util.List;
import java.io.Serializable;

import model.util.Excecoes;
import model.util.Validadores;
import java.util.ArrayList;

public class Aluno extends Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sexo;
	private double peso;
	private double altura;
	private String limitacoesFisicasOuSaude;
	private List<Treinos> meusTreinos;
	
	public Aluno(String nome, int idade, String matricula, String sexo, double peso, double altura,
	String limitacoesFisicasOuSaude) throws Excecoes{
		super(nome,idade,matricula);
		if(Validadores.isSexoValid(sexo) && Validadores.isPesoValid(peso) && Validadores.isAlturaValid(altura) &&
		   Validadores.isLimitacoesValid(limitacoesFisicasOuSaude)) {
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
		this.limitacoesFisicasOuSaude = limitacoesFisicasOuSaude;
		this.meusTreinos=new ArrayList<>();
		}else {
			throw new Excecoes ("Aluno inválido");
		}
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) { 
			this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getLimitacoesFisicasOuSaude() {
		return limitacoesFisicasOuSaude;
	}

	public void setLimitacoesFisicasOuSaude(String limitacoesFisicasOuSaude) {
		this.limitacoesFisicasOuSaude = limitacoesFisicasOuSaude;
	}

	public List<Treinos> getMeusTreinos() {
		return meusTreinos;
	}
	
}
