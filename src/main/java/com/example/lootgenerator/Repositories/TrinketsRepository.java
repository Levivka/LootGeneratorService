package com.example.lootgenerator.Repositories;

import com.example.lootgenerator.Models.Trinkets;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TrinketsRepository extends MongoRepository<Trinkets, Long> {
    Optional<Trinkets> findById(Long Long);
    ArrayList<Trinkets> findAllByCost(int cost);
}
