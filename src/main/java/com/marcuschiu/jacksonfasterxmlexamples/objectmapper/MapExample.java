package com.marcuschiu.jacksonfasterxmlexamples.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcuschiu.jacksonfasterxmlexamples.model.Example1Pojo;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

    @Test
    public void readFromString() throws JsonProcessingException {
        String json = "{ \"a\" : \"Black\", \"b\" : \"BMW\", \"obj\" : { \"a\" : \"hello world\" } }";
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(json, Map.class);
        // objectMapper creates a linkedHashMap
        System.out.println(map.toString());
    }

    @Test
    public void writeToString() throws IOException {
        Map map = new LinkedHashMap();
        map.put("a", "Black");
        map.put("b", "BMW");

        Map subMap = new LinkedHashMap();
        subMap.put("a", "Hello, World!");
        map.put("obj", subMap);

        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(str);
    }
}
