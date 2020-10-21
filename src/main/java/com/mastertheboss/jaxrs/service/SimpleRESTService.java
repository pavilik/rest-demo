package com.mastertheboss.jaxrs.service;

import com.mastertheboss.jaxrs.service.ItemCollection;
import com.mastertheboss.jaxrs.model.Item;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;


@Path("/tutorial")
public class SimpleRESTService  {
	public ItemCollection itemCollection = new ItemCollection();

	@GET
	@Path("helloname/{name}")
	public String hello(@PathParam("name") final String name) {
		return "Hello " +name;
	}

    @GET
    @Path("itemListJson")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Item> getJSONItems() {
	//	ItemCollection itemCollection = new ItemCollection();
		itemCollection.setItemToMap(new Item.ItemBuilder().description("banana").price(5).buildItem());
		itemCollection.setItemToMap(new Item.ItemBuilder().description("mango").price(3).buildItem());
		itemCollection.setItemToMap(new Item.ItemBuilder().description("apple").price(1).buildItem());
//
      return itemCollection.getItemMap();
    }

	@GET
	@Path("itemListJson/banana")
	@Produces(MediaType.APPLICATION_JSON)
	public  Item getJSONItem() {


//не работает (
		return itemCollection.getItem("banana");
	}

	@POST
	@Path("itemListJson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setJSONItemToMap(Item item) {
		itemCollection.setItemToMap(item);
		System.out.println(item.getDescription() + item.getPrice());
		System.out.println(itemCollection.getItemMap().toString());
		return Response.ok(item).build();
	}

}
