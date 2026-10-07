package model;

import helper.IdGenerator;


public class User {
    private Integer id;
    private String name;

    public User(String name) {
        this.id = IdGenerator.getRandomId();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
