package com.nannoprice.api.controller;

import com.nannoprice.api.model.Budget;
import com.nannoprice.api.service.BudgetService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/budget")
public class BudgetResource {

    @Inject
    BudgetService budgetService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ManagedAsync
    public void getAllProducts(@Suspended final AsyncResponse asyncResponse) {
        List<Budget> budgets = budgetService.findAll();
        asyncResponse.resume(budgets);
    }

}
