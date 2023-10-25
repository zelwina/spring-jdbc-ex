package com.zelwina.springjdbc.entity;

import org.springframework.data.annotation.Id;

public class MyStuff {
    @Id
    private Long id;
    private String stuff;
    private Integer intStuff;

    public MyStuff(Long id, String stuff, Integer intStuff) {
        this.id = id;
        this.stuff = stuff;
        this.intStuff = intStuff;
    }

    public MyStuff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public Integer getIntStuff() {
        return intStuff;
    }

    public void setIntStuff(Integer intStuff) {
        this.intStuff = intStuff;
    }
}
