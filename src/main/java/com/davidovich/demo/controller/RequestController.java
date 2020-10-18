package com.davidovich.demo.controller;

import com.davidovich.demo.model.Person;
import com.davidovich.demo.model.Request;
import com.davidovich.demo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class RequestController {

        @Autowired
        RequestService requestService;

        @GetMapping("/requests")
        private List<Request> getAllRequests() {
            return requestService.getAllRequests();
        }

        @GetMapping("/requests/{id}")
        private Request getRequest(@PathVariable("id") int id) {
            return requestService.getRequestById(id);
        }

        @DeleteMapping("/requests/{id}")
        private void deleteRequest(@PathVariable("id") int id) {
            requestService.delete(id);
        }

        @PostMapping("/requests")
        private int savePerson(@RequestBody Request request) {
            requestService.saveOrUpdate(request);
            return request.getId();
        }
}
