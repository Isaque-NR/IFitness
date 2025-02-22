package model;

import java.util.List;
import java.util.ArrayList;

public class Aluno extends Usuario{
	
	private String sexo;
	private double peso;
	private double altura;
	private String limitacoesFisicasOuSaude;
	private List<Treinos> meusTreinos;
	
	public Aluno(String nome, int idade, String matricula, String sexo, double peso, double altura,
	String limitacoesFisicasOuSaude){
		super(nome,idade,matricula);
		if(Validadores.isSexoValid(sexo) && Validadores.isPesoValid(peso) && Validadores.isAlturaValid(altura) &&
		   Validadores.isLimitacoesValid(limitacoesFisicasOuSaude)) {
		this.sexo=sexo;
		this.peso=peso;
		this.altura=altura;
		this.limitacoesFisicasOuSaude = limitacoesFisicasOuSaude;
		this.meusTreinos=new ArrayList<>();
		}else {
			System.out.println("Aluno Invalido");
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
	
	public double calcularIMC() {
        return peso/(altura*altura);
    }
	
	
    
	@Override
	public String toString() {
		return super.toString()+"| Sexo: " + sexo + "| Peso: " + peso + 
				"| Altura: " + altura + "| Limitacoes Fisicas Ou Saude: "
				+ limitacoesFisicasOuSaude + "| Meus Treinos:" + meusTreinos;
	}
}
