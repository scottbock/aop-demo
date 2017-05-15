package com.bock.aopdemo.service;

import com.bock.aopdemo.model.Dog;
import com.bock.aopdemo.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    private DogRepo dogRepo;

    public DogService(@Autowired DogRepo dogRepo) {
        this.dogRepo = dogRepo;
    }

    public Dog getOdie() {
        return dogRepo.findOne(new Long(1));
    }

    public Dog getCujo() {
        return dogRepo.findOne(new Long(2));
    }

    public Dog getBrian() {
        return dogRepo.findOne(new Long(3));
    }

    public Dog findById(Long id){
        return dogRepo.findOne(id);
    }

}
