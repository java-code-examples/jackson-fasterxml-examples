package com.marcuschiu.jacksonfasterxmlexamples.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcuschiu.jacksonfasterxmlexamples.model.Example1Pojo;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileAndStringExample {

    @Test
    public void readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("example1Pojo_read.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Example1Pojo exp = objectMapper.readValue(is, Example1Pojo.class);
    }

    @Test
    public void readFromString() throws JsonProcessingException {
        String json = "{ \"a\" : \"Black\", \"b\" : \"BMW\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Example1Pojo exp = objectMapper.readValue(json, Example1Pojo.class);
    }

    @Test
    public void writeToFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File file = new File(classloader.getResource("example1Pojo_write.json").getFile());

        Example1Pojo exp = new Example1Pojo("from code", "from code");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, exp);
    }

    @Test
    public void writeToString() throws IOException {
        Example1Pojo exp = new Example1Pojo("from code", "from code");

        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(exp);
        System.out.println(str);
    }
}
