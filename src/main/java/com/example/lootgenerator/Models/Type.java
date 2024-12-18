package com.example.lootgenerator.Models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "types")
public class Type {
    @Id
    private ObjectId id;
    private String name;
}
