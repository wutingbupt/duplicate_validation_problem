package com.tim.wu.test.boundary.external;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBean implements Serializable {

    public MyBean() {
    }

    @HelloValidator
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
