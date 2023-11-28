package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Conta;
import ecommerce.model.Produto;
import ecommerce.repository.EcommerceRepository;

public class EcommerceController implements EcommerceRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	@Override
	public void cadastroProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto número " + (produto.getNumero()+1) + " foi adicionado com sucesso!");
	}
	
	@Override
	public void deletaProduto(int numero) {
		var produto = buscarProdutos(numero);
		
		if (produto != null) {
			if (listaProdutos.remove(produto) == true)
				System.out.println("\nO produto número " + numero + " foi removido com sucesso!");
			
		} else
			System.out.println("\nO produto número " + numero + " não foi adicionado!");
	}
	
	@Override
	public void listaProdutos() {
		for(var produto : listaProdutos) {
			produto.visualizar();
		}
	}
	
	@Override
	public void buscarPorNumero(int numero) {
		var produto = buscarProdutos(numero);
		
		if (produto != null) 
			produto.visualizar();
		else
			System.out.println("\nO produto número " + numero + " não foi adicionado!");
	}
	
	@Override
	public void atualizarProduto(Produto produto) {
		var buscaProduto = buscarProdutos(produto.getNumero());
		
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO produto número " + produto.getNumero() + " foi atualizado com sucesso!");
		} else
			System.out.println("\nO produto número " + produto.getNumero() + " não foi atualizado!");
	}
	
	@Override
	public void estocaProduto(int numero, int quantidade) {
		var produto = buscarProdutos(numero);
		
		if (produto != null)
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
		else
			System.out.println("\nO produto não existe!");
	}
	
	@Override
	public void removeProduto(int numero, int quantidade) {
		var produto = buscarProdutos(numero);
		
		if (produto != null)
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
		else
			System.out.println("\nO produto não existe!");
	}
	
	@Override
	public void cadastraUsuario(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA conta " + conta.getNome() + " foi criada com sucesso!");
	}
	
	@Override
	public void deletaUsuario(String nome) {
		var conta = buscarContas(nome);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("\nA conta " + nome + " foi deletada com sucesso!");
			else
				System.out.println("\nA conta " + nome + " não foi criada!");
		}
	}
	
	@Override
	public boolean checkLogin(String nome, String senha) {
		var conta = buscarContas(nome);
		
		if (conta != null) {
			if (conta.getNome().equals(nome) && conta.getSenha().equals(senha)) {
				return true;
			}
			System.out.println("\nSenha ou usuário incorreto!");
			return false;
		}
		System.out.println("\nUsuário não existe");
		return false;
	}
	
	public void criarAdmin() {
		listaContas.add(new Conta("admin", "admin", 1));
	}
	
	
	public Produto buscarProdutos(int numero) {
		for ( var produto : listaProdutos) {
			if (produto.getNumero() == numero) {
				return produto;
			}
		}
		
		return null;
	}
	
	public Conta buscarContas(String nome) {
		for ( var conta : listaContas) {
			if (conta.getNome().equals(nome)) {
				return conta;
			}
		}
		
		return null;
	}
}
