package com.bock.aopdemo.controller;

import com.bock.aopdemo.model.Cat;
import com.bock.aopdemo.service.CatService;
import com.bock.aopdemo.service.NoiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cats")
public class CatController{

    @Autowired
    private CatService catService;

    @Autowired
    private NoiseService noiseService;

    @GetMapping("/byId")
    public String byId(@RequestParam(value="id", required=true) Long id) {
        return noiseService.makeNoise(catService.findById(id));
    }

    @GetMapping("/tigger")
    public String tigger(){
        Cat cat = catService.getTigger();

        noiseService.addNoise(cat);

        String noise = noiseService.getNoise();

        noiseService.clearNoise();

        return noise;
    }

    @GetMapping("/garfield")
    public String garfield(){
        return noiseService.makeNoise(catService.getGarfield());
    }

    @GetMapping("/mrBigglesWorth")
    public String mrBigglesWorth(){
        return noiseService.makeNoise(catService.getMrBigglesWorth());
    }


}
