package ecommerce.repository;

import ecommerce.model.Produto;
import ecommerce.model.Conta;

public interface EcommerceRepository {
	
	public void cadastroProduto(Produto produto);
	public void deletaProduto(int numero);
	public void listaProdutos();
	public void buscarPorNumero(int numero);
	public void atualizarProduto(Produto produto);
	public void estocaProduto(int numero, int quantidade);
	public void removeProduto(int numero, int quantidade);
	public void cadastraUsuario(Conta conta);
	public void deletaUsuario(Conta conta);
	
	public void compraProduto(int numero, int quantidade);
	
}
