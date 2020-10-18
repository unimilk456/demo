package com.davidovich.demo.service;


import com.davidovich.demo.model.DadaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MapperService {
    public DadaDTO transform (String string) throws JsonProcessingException {

        ApplicationContext context = new AnnotationConfigApplicationContext(ObjectInputFilter.Config.class);
        ArrayList<DadaDTO> arrDadaDTO = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(string);
        JsonNode root = jsonNode.get("suggestions");

        if (root.isArray()) {
            ArrayNode arrayNode = (ArrayNode) root;
            for(int i = 0; i < arrayNode.size(); i++) {
                JsonNode arrayElement = arrayNode.get(i);
//                JsonNode jsonNode = objectMapper.readTree(string);
//                JsonNode root = jsonNode.get("suggestions");
//                JsonNode root1 = arrayElement.get("data");

                String indexJS =  arrayElement.at("/data/postal_code").asText();
                DadaDTO dadaDTO = new DadaDTO();
                dadaDTO.setIndex(indexJS);
                System.out.println(indexJS);
//                System.out.println(root1.get("data").asText());
            }
        }
        return null;
    }
}
