package model;

import java.util.List;
import java.util.ArrayList;
import controller.Validadores;

public class Aluno extends Usuario{
	
	private String sexo;
	private double peso;
	private double altura;
	private String limitacoesFisicasOuSaude;
	private List<Treinos> treinos;
	
	public Aluno(String nome, int idade, String matricula, String sexo, double peso, double altura,
	String limitacoesFisicasOuSaude){
		super(nome,idade,matricula);
		if(Validadores.isAlunoValid(sexo,peso,altura,limitacoesFisicasOuSaude)) {
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
		this.limitacoesFisicasOuSaude = limitacoesFisicasOuSaude;
		this.treinos=new ArrayList<>();
		}else {
			System.out.println("Aluno Invalido");
		}
	}
    
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if(Validadores.isSexoValid(sexo)) {
		    this.sexo = sexo;
		}else {
			System.out.println("Insira um Sexo válido!");
		}
		
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if(Validadores.isPesoValid(peso)) {
			this.peso = peso;	
		}else {
			System.out.println("Insira um Peso Válido!");
		}
		
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		if(Validadores.isAlturaValid(altura)) {
			this.altura = altura;
		}else {
			System.out.println("insira uma altura válida!");
		}
	}

	public String getLimitacoesFisicasOuSaude() {
		return limitacoesFisicasOuSaude;
	}

	public void setLimitacoesFisicasOuSaude(String limitacoesFisicasOuSaude) {
		if(Validadores.isLimitacoesValid(limitacoesFisicasOuSaude)){
			this.limitacoesFisicasOuSaude = limitacoesFisicasOuSaude;
		}else {
			System.out.println("insira Limitações Válidas!");
		}
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
