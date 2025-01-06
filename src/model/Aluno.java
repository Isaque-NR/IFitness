package model;

import java.util.List;
import java.util.ArrayList;

public class Aluno extends Usuario{
	
	private String sexo;
	private double peso;
	private double altura;
	private String limitacoesFisicasOuSaude;
	private List<Treinos> treinos;
	
	public Aluno(String nome, int idade, String matricula, String sexo, double peso, double altura,
	String limitacoesFisicasOuSaude){
		super(nome,idade,matricula);
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
		this.limitacoesFisicasOuSaude = limitacoesFisicasOuSaude;
		this.treinos=new ArrayList<>();
		
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

	public List<Treinos> getTreinos() {
		return treinos;
	}
	
	public double calcularIMC() {
		return peso/(altura*altura);
	}
	
	@Override
	public void exibirInformacoes() {
		System.out.println("Nome: " + this.getNome() + " Idade: " + this.getIdade() + " Matrícula: " + this.getMatricula()
		+ " Sexo: " + sexo + " Peso: " + peso + " Limitações físicas ou de saúde: " + limitacoesFisicasOuSaude);
	}

	@Override
	public String toString() {
		return "Aluno :" + getNome() + " Treinos: " + treinos.toString();
	}
	
	

}
