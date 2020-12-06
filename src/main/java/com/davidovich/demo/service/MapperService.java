package com.davidovich.demo.service;


import com.davidovich.demo.dto.DadaDTO;
import com.davidovich.demo.model.Suggestion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapperService {
    public List<DadaDTO> transform(String string) throws JsonProcessingException {

        List<DadaDTO> arrDadaDTO = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(string);
        JsonNode root = jsonNode.get("suggestions");

        if (root.isArray()) {
            ArrayNode arrayNode = (ArrayNode) root;
            for (int i = 0; i < arrayNode.size(); i++) {
                JsonNode arrayElement = arrayNode.get(i);

                String indexJS = arrayElement.at("/data/postal_code").asText();
                String region = arrayElement.at("/data/region").asText();
                String city = arrayElement.at("/data/city").asText();
                String settlement = arrayElement.at("/data/settlement").asText();
                String street = arrayElement.at("/data/street").asText();
                String house = arrayElement.at("/data/house").asText();

                DadaDTO dadaDTO = DadaDTO.builder()
                        .index(indexJS.equals("null")? null : indexJS)
                        .region(region.equals("null")? null : region)
                        .city(city.equals("null")? null : city)
                        .settlement(settlement.equals("null")? null : settlement)
                        .street(street.equals("null")? null : street)
                        .house(house.equals("null")? null : house)
                        .build();

                arrDadaDTO.add(dadaDTO);
                System.out.println(indexJS);
//                System.out.println(root1.get("data").asText());
            }
        }
        return arrDadaDTO;
    }

    public List<DadaDTO> transform(List<Suggestion> suggestions) {
        List<DadaDTO> res = new ArrayList<>();
        suggestions.stream()
            .forEach(s -> {
                DadaDTO dadaDTO = DadaDTO.builder()
                    .index(s.getIndex())
                    .region(s.getRegion())
                    .city(s.getCity())
                    .settlement(s.getSettlement())
                    .street(s.getStreet())
                    .house(s.getHouse())
                    .build();
                res.add(dadaDTO);
            });
        return res;
    }
}
