package com.davidovich.demo.service;

import com.davidovich.demo.model.Request;
import com.davidovich.demo.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository ;

    public Iterable<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request getRequestById(int id) {
        return requestRepository.findById(id).get();
    }

    public Request saveOrUpdate(Request request) {
        return requestRepository.save(request);
    }

    public void delete(int id) {
        requestRepository.deleteById(id);
    }

}
