package com.bock.aopdemo.model;

import javax.persistence.*;

@Entity
public class Cat implements Pet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Transient
    private String noise = "Meow";

    public Cat(){

    }

    public Cat(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (id != null ? !id.equals(cat.id) : cat.id != null) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    @Transient
    public void setNoise(String noise){
        this.noise = noise;
    }

    @Transient
    public String makeNoise(){
        return noise;
    }
}
