package com.learning.by.doing.service;

import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("base64Util")
public class Base64UtilResource {

	@GET
	@Path("toBase64/{texto}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	public String toBase64(@QueryParam("texto") String texto) {
		String base64 = Base64.getEncoder().encodeToString(texto.getBytes());
		
		return base64;
	}
	
	@GET
	@Path("fromBase64/{texto}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	public String fromBase64(@QueryParam("texto") String texto) {
		byte[] base64 = Base64.getDecoder().decode(texto);
		
		return String.valueOf(base64);
	}
	

	
}
