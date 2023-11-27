package ecommerce.model;

public class PlacaDeVideo extends Produto{
	private String arquitetura;
	private int vram;
	private float frequenciaClock;

	public PlacaDeVideo(int numero, String nome, String marca, int tipo, float preco, int quantidadeEstoque, String arquitetura,
			int vram, float frequenciaClock) {
		super(numero, nome, marca, tipo, preco, quantidadeEstoque);
		this.arquitetura = arquitetura;
		this.vram = vram;
		this.frequenciaClock = frequenciaClock;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public int getVram() {
		return vram;
	}

	public void setVram(int vram) {
		this.vram = vram;
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
		System.out.println("VRAM(em GBs): " + vram);
		System.out.println("Frequência do clock: " + frequenciaClock);
	}
}
