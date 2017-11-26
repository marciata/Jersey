package com.learning.by.doing.repository;

import java.util.ArrayList;
import java.util.List;

import com.learning.by.doing.domain.Categoria;
import com.learning.by.doing.domain.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository{
	
	private static ProdutoRepositoryImpl instance = null;
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public static ProdutoRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new ProdutoRepositoryImpl();
		}
		
		return instance;
	}
	
	private ProdutoRepositoryImpl() {
		Categoria cat = new Categoria();
		cat.setId(1L);
		cat.setNome("Categoria1");
		cat.setDescricao("Descricao da categoria 1");
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setNome("Produto1");
		produto.setDescricao("Descricao do produto 1");
		produto.setCategoria(cat);
		
		this.produtos.add(produto);
	}

	public List<Produto> findAllProdutos() {
		return this.produtos;
	}
	
	public void saveNewProduto(Produto produto) {
		if (!produtos.contains(produto)) {
			produtos.add(produto);
		}
	}
}
