package com.learning.by.doing.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.collections4.CollectionUtils;

import com.learning.by.doing.domain.Produto;
import com.learning.by.doing.service.ProdutoService;

@Path("produto")
@PermitAll
public class ProdutoResource {
	
	private ProdutoService produtoService = new ProdutoService();
	
	@Context
	private SecurityContext securityContext;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getAllProduto() {
		
		if (securityContext == null) {
			throw new NotAuthorizedException("Acesso nao autorizado");
		}
		if (securityContext.isUserInRole("user")) {
			System.out.println("User");
		}
		if (securityContext.isUserInRole("admin")) {
			System.out.println("admin");
		}
		
		List<Produto> produtos = produtoService.findAllProduto();
		
		if (CollectionUtils.isEmpty(produtos)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.status(Status.OK).entity(new GenericEntity<List<Produto>>(produtos) {}).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@RolesAllowed("admin")
	public Response saveNewProduto(Produto produto) {
		produtoService.saveNewProduto(produto);
		
		return Response.status(Status.OK).build();
	}

}
