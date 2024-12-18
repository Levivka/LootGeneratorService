package com.example.lootgenerator.Repositories;

import com.example.lootgenerator.Models.Jewelry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JewelryRepository extends MongoRepository<Jewelry, ObjectId> {
}
