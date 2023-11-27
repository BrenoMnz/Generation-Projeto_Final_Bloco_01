package ecommerce.model;

public abstract class Produto {
	private String nome;
	private String marca;
	private int tipo;
	private float preco;
	private int quantidadeEstoque;
	
	public Produto(String nome, String marca, float preco, int quantidadeEstoque) {
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo) {
		case 1 -> {
			tipo = "Processador";
		}
		case 2 -> {
			tipo = "Placa de vídeo";
		}
		}
		
		System.out.println("====================================================");
		System.out.println("Quantidade em estoque: " + quantidadeEstoque);
		System.out.println(tipo + " " + nome);
		System.out.println("Marca: " + marca);
		System.out.println("Preço: R$" + preco);
		System.out.println("Especificações: ");
	}
}
