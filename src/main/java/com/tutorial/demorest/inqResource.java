package com.tutorial.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("inqs")
public class inqResource {
	
	inqRepository repo = new inqRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<inq> getInqs() {
		System.out.println("abc");
		return repo.getInqs();
	}
	
	@GET
	@Path("inq/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public inq getInq(@PathParam("id") int id) {
		System.out.println("abc");
		return repo.getInq(id);
		
	}
	
	
	@POST
	@Path("inq")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public inq createInq(inq i1) {
		System.out.println(i1);
		repo.create(i1);
		return i1;
	}
	
	@PUT
	@Path("inq")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public inq updateInq(inq i1) {
		System.out.println(i1);
		
		if(repo.getInq(i1.getId()).getId()==0) {
			System.out.println("Not found");
		}
		else {
			repo.update(i1);
		}
		return i1;
	}
	
	@DELETE
	@Path("inq/{id}")
	public inq deleteinq(@PathParam("id") int id) {
		inq i = repo.getInq(id);
		
		if(i.getId()!=0)
			repo.delete(id);
		System.out.println("deleted successfully");
		return i;
	}
	

}

