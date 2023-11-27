package ecommerce.model;

public class Conta {
	
	private String nome;
	private String senha;
	private int permissao;
	
	public Conta(String nome, String senha, int permissao) {
		this.nome = nome;
		this.senha = senha;
		this.permissao = permissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
}