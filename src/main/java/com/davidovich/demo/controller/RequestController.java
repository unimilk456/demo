package com.davidovich.demo.controller;

import com.davidovich.demo.dto.RequestDTO;
import com.davidovich.demo.model.Person;
import com.davidovich.demo.model.Request;
import com.davidovich.demo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class RequestController {

        private final RequestService requestService;

        @GetMapping("/requests")
        private Iterable<Request> getAllRequests() {
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
        private int savePerson(@RequestBody RequestDTO requestDTO) {
            Request request = new Request(requestDTO.getRequest(),
                    requestDTO.getLocal_date_time(),
                    requestDTO.getIndex(),
                    requestDTO.getRegion(),
                    requestDTO.getCity(),
                    requestDTO.getSettlement(),
                    requestDTO.getStreet(),
                    requestDTO.getHouse()
            );
            Request result = requestService.saveOrUpdate(request);
            return result.getId();
        }
}
