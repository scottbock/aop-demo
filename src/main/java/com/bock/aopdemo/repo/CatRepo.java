package com.bock.aopdemo.repo;

import com.bock.aopdemo.model.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepo extends CrudRepository<Cat, Long> {
}
