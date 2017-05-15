package com.bock.aopdemo.controller;

import com.bock.aopdemo.model.Dog;
import com.bock.aopdemo.service.DogService;
import com.bock.aopdemo.service.NoiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/dogs")
public class DogController{

    @Autowired
    private DogService dogService;

    @Autowired
    private NoiseService noiseService;

    @GetMapping("/byId")
    public String byId(@RequestParam(value="id", required=true) Long id) {
        return noiseService.makeNoise(dogService.findById(id));
    }

    @GetMapping("/cujo")
    public String cujo(){
        Dog dog = dogService.getCujo();

        noiseService.addNoise(dog);

        String noise = noiseService.getNoise();

        noiseService.clearNoise();

        return noise;
    }

    @GetMapping("/odie")
    public String odie(){
        return noiseService.makeNoise(dogService.getOdie());
    }

    @GetMapping("/brian")
    public String brian(){
        return noiseService.makeNoise(dogService.getBrian());
    }


}
