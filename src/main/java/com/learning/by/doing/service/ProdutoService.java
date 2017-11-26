package com.learning.by.doing.service;

import java.util.List;

import com.learning.by.doing.domain.Produto;
import com.learning.by.doing.repository.ProdutoRepository;
import com.learning.by.doing.repository.ProdutoRepositoryImpl;

public class ProdutoService {
	
	private ProdutoRepository produtoRepository = ProdutoRepositoryImpl.getInstance();

	public List<Produto> findAllProduto(){
		return produtoRepository.findAllProdutos();
	}
	
	public void saveNewProduto(Produto produto) {
		produtoRepository.saveNewProduto(produto);
	}
}
