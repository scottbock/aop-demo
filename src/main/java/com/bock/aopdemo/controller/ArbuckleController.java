package com.bock.aopdemo.controller;

import com.bock.aopdemo.service.NoiseService;
import com.bock.aopdemo.service.arbuckle.ArbuckleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/arbuckle")
public class ArbuckleController {

    @Autowired
    private ArbuckleService arbuckleService;

    @Autowired
    private NoiseService noiseService;

    @GetMapping("/garfield")
    public String garfield(){
        return noiseService.makeNoise(arbuckleService.getGarfield());
    }

    @GetMapping("/odie")
    public String odie(){
        return noiseService.makeNoise(arbuckleService.getOdie());
    }

}
