package com.nannoprice.api.service;

import com.nannoprice.api.model.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BudgetService extends MongoRepository<Budget, String> {
    public List<Budget> findAll();
}
