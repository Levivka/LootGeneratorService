package com.example.lootgenerator.Repositories;

import com.example.lootgenerator.Models.Dto.PlaceDto;
import com.example.lootgenerator.Models.Dto.TypeDto;
import com.example.lootgenerator.Models.Jewelry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface JewelryRepository extends MongoRepository<Jewelry, ObjectId> {
    List<Jewelry> findByType_Name(String typeName);
    List<Jewelry> findByPlace_Name(String placeName);
}
