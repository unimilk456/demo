package com.davidovich.demo.service;

import com.davidovich.demo.model.Request;
import com.davidovich.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepository ;

    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<Request>();
        requestRepository.findAll().forEach(request -> requests.add(request));
        return requests;
    }

    public Request getRequestById(int id) {
        return requestRepository.findById(id).get();
    }

    public void saveOrUpdate(Request request) {
        requestRepository.save(request);
    }

    public void delete(int id) {
        requestRepository.deleteById(id);
    }

}
