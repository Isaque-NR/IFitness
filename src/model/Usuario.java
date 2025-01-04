package model;

public class Usuario {
	
	private String nome;
	private int idade;
	private String matricula;
	
	public Usuario(String nome, int idade, String matricula) {
		this.nome=nome;
		this.idade=idade;
		this.matricula=matricula;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
   
	public void exibirInformacoes() { // apagar depois, vai estar em view
		System.out.println("Nome: " + this.getNome() + "Idade: " + this.getIdade() + " " + this.getMatricula());
	}
	
	public boolean autenticarAcesso(String matricula) { // Polimorfismo para instrutor com matricula e senha  
		if(matricula.equals(this.getMatricula())) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
