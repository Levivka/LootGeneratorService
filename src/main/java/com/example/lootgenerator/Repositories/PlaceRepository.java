package com.example.lootgenerator.Repositories;

import com.example.lootgenerator.Models.Place;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlaceRepository extends MongoRepository<Place, ObjectId> {
    Optional<Place> findByName(String name);
}
