package com.bock.aopdemo;

import com.bock.aopdemo.model.Cat;
import com.bock.aopdemo.model.Dog;
import com.bock.aopdemo.repo.CatRepo;

import com.bock.aopdemo.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner{

    private CatRepo catRepo;

    private DogRepo dogRepo;

    @Autowired
    public DataLoader(CatRepo catRepo, DogRepo dogRepo){
        this.catRepo = catRepo;
        this.dogRepo = dogRepo;
    }

    public void run(ApplicationArguments args){
        Cat garfield = new Cat(new Long(1), "Garfield");
        Cat tigger = new Cat(new Long(2), "Tigger");
        Cat mrBigglesWorth = new Cat(new Long(3), "Mr. Bigglesworth");

        catRepo.save(garfield);
        catRepo.save(tigger);
        catRepo.save(mrBigglesWorth);

        Dog odie = new Dog(new Long(1), "Odie");
        Dog cujo = new Dog(new Long(2), "Cujo");
        Dog brian = new Dog(new Long(3), "Brian");

        dogRepo.save(odie);
        dogRepo.save(cujo);
        dogRepo.save(brian);
    }
}