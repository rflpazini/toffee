package com.nannoprice.api.controller;

import com.nannoprice.api.model.Product;
import com.nannoprice.api.service.ProductService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/products")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ManagedAsync
    public void getAllProducts(@Suspended final AsyncResponse asyncResponse) {
        List<Product> products = productService.findAll();
        asyncResponse.resume(products);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ManagedAsync
    public void getProductById(@Suspended final AsyncResponse asyncResponse, @PathParam("id") String id) {
        asyncResponse.resume(productService.getProductById(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ManagedAsync
    public void setProduct(@Suspended final AsyncResponse asyncResponse, Product product) {
        asyncResponse.resume(productService.save(product));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ManagedAsync
    public void updateProduct(@Suspended final AsyncResponse asyncResponse, Product product) {
        Product updatedProduct = productService.findOne(product.getId());
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());

        asyncResponse.resume(productService.save(updatedProduct));
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ManagedAsync
    public void delteProduct(@Suspended final AsyncResponse asyncResponse, @PathParam("id") String id) {
        try {
            productService.delete(id);
            asyncResponse.resume("The product was deleted");
        }catch (Exception e) {
            asyncResponse.resume(e.getMessage());
        }
    }
}
