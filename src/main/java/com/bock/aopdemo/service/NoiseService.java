package com.bock.aopdemo.service;

import com.bock.aopdemo.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class NoiseService {

    private String noise = "";

    public void addNoise(Pet pet){
        noise += this.makeNoise(pet);
    }

    public String getNoise(){
        return noise;
    }

    public void clearNoise(){
        noise = "";
    }

    public String makeNoise(Pet pet){
        return pet.makeNoise();
    }
}
