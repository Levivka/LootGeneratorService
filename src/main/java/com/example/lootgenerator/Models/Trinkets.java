package com.example.lootgenerator.Models;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Trinkets {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private int cost;
    private String Currency;
}
