package com.learning.by.doing.repository;

import java.util.List;

import com.learning.by.doing.domain.Produto;

public interface ProdutoRepository {

	List<Produto> findAllProdutos();
	
	void saveNewProduto(Produto produto);

}
