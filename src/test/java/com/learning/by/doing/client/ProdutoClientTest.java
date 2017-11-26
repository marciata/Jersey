package com.learning.by.doing.client;

import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;

import com.learning.by.doing.domain.Produto;

public class ProdutoClientTest {
	
	@Test
	public void testFindAllProduto() {
		ProdutoClient produtoClient = new ProdutoClient();
		List<Produto> all = produtoClient.getAllProdutos();
		
		assertNotNull(all);
	}

}
