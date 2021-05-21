package com.marcuschiu.jacksonfasterxmlexamples.objectmapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

public class MixInExample {

    // Class we want to Serialize/Deserialize but can't @Annotate
    @Data
    @Builder
    public static class Pojo {
        private String firstName;
        private String lastName;
    }

    @Data
    @Builder
    public static class PojoMixIn {
        @JsonIgnore
        private String firstName;
    }

    public static void main(String[] args) throws JsonProcessingException {
        var om = new ObjectMapper();
        om.addMixIn(Pojo.class, PojoMixIn.class);

        Pojo pojo = Pojo.builder()
                .firstName("Marcus")
                .lastName("Chiu")
                .build();

        System.out.println(om.writeValueAsString(pojo));
    }
}
