package com.bock.aopdemo.service.arbuckle;

import com.bock.aopdemo.model.Cat;
import com.bock.aopdemo.model.Dog;
import com.bock.aopdemo.repo.CatRepo;
import com.bock.aopdemo.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArbuckleService {
    private CatRepo catRepo;
    private DogRepo dogRepo;

    public ArbuckleService(@Autowired CatRepo catRepo, @Autowired DogRepo dogRepo){
        this.catRepo = catRepo;
        this.dogRepo = dogRepo;
    }

    public Cat getGarfield() {
        return catRepo.findOne(new Long(1));
    }

    public Dog getOdie() {
        return dogRepo.findOne(new Long(1));
    }

}
