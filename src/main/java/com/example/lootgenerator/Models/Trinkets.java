package com.example.lootgenerator.Models;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "trinkets")
public class Trinkets {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private int cost;
    private String Currency;
}
