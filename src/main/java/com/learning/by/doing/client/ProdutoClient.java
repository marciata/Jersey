package com.learning.by.doing.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.learning.by.doing.domain.Produto;

public class ProdutoClient {

	private static final String URL = "http://localhost:8081/jersey-with-basic-auth/webapi/";
	private static final String PRODUTO = "produto";
	
	public List<Produto> getAllProdutos(){
		ClientConfig clientConfig = new ClientConfig();

		Client client = ClientBuilder.newClient(clientConfig);
		client.register(HttpAuthenticationFeature.basic("admin", "admin123"));
		WebTarget target = client.target(URL);
		
		List<Produto> produtos = target.path(PRODUTO).request().get(new GenericType<List<Produto>>() {});
		
		return produtos;
	}
}
