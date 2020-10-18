package com.davidovich.demo.repository;

import com.davidovich.demo.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer> {

}