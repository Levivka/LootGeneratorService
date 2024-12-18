package com.example.lootgenerator.Models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "jewelry")
public class Jewelry {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private List<Type> type;
    private List<Place> place;
}
