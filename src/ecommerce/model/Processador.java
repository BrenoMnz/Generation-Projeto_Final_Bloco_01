package ecommerce.model;

public class Processador extends Produto{
	private String arquitetura;
	private int qtdNucleos;
	private int qtdThreads;
	private float frequenciaClock;
	
	public Processador(String nome, String marca, float preco, int quantidadeEstoque, String arquitetura, int qtdNucleos, int threads,
			float frequenciaClock) {
		super(nome, marca, preco, quantidadeEstoque);
		this.arquitetura = arquitetura;
		this.qtdNucleos = qtdNucleos;
		this.qtdThreads = threads;
		this.frequenciaClock = frequenciaClock;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public int getQtdNucleos() {
		return qtdNucleos;
	}

	public void setQtdNucleos(int qtdNucleos) {
		this.qtdNucleos = qtdNucleos;
	}

	public int getThreads() {
		return qtdThreads;
	}

	public void setThreads(int threads) {
		this.qtdThreads = threads;
	}

	public float getFrequenciaClock() {
		return frequenciaClock;
	}

	public void setFrequenciaClock(float frequenciaClock) {
		this.frequenciaClock = frequenciaClock;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Arquitetura: " + this.arquitetura);
		System.out.println("Quantidade de núcleos: " + qtdNucleos);
		System.out.println("Quantidade de threads: " + qtdThreads);
		System.out.println("Frequência do clock: " + frequenciaClock);
	}
}
