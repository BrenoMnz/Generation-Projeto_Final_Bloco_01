package ecommerce.model;

public abstract class Produto {
	private int numero;
	private String nome;
	private String marca;
	private int tipo;
	private float preco;
	private int quantidadeEstoque;
	
	public Produto(int numero, String nome, String marca, float preco, int quantidadeEstoque) {
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.numero = numero;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	
}
