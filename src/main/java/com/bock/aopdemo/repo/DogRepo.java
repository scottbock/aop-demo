package com.bock.aopdemo.repo;

import com.bock.aopdemo.model.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepo extends CrudRepository<Dog, Long> {
}
