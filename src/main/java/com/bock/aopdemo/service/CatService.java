package com.bock.aopdemo.service;

import com.bock.aopdemo.model.Cat;
import com.bock.aopdemo.repo.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatService {

    private CatRepo catRepo;

    public CatService(@Autowired CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    public Cat getGarfield() {
        return catRepo.findOne(new Long(1));
    }

    public Cat getTigger() {
        return catRepo.findOne(new Long(2));
    }

    public Cat getMrBigglesWorth() {
        return catRepo.findOne(new Long(3));
    }

    public Cat findById(Long id){
        return catRepo.findOne(id);
    }

}
