package com.marcuschiu.jacksonfasterxmlexamples.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Example1Pojo {
    private String a;
    private String b;

    // used by Jackson FasterXML to create object
    public Example1Pojo() {

    }

    public Example1Pojo(String a, String b) {
        this.a = a;
        this.b = b;
    }

    // used by Jackson FasterXML to set object value
    public void setA(String a) {
        this.a = a;
    }
    // used by Jackson FasterXML to get object value
    public String getA() {
        return a;
    }

    // used by Jackson FasterXML to set object value
    public void setB(String b) {
        this.b = b;
    }
    // used by Jackson FasterXML to get object value
    public String getB() {
        return b;
    }
}
