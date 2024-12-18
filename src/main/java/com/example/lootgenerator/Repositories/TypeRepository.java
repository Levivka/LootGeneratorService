package com.example.lootgenerator.Repositories;

import com.example.lootgenerator.Models.Type;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TypeRepository extends MongoRepository<Type, ObjectId> {
    Optional<Type> findByName(String name);
}
