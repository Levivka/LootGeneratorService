package com.example.lootgenerator.Models.Dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class PlaceDto {
    private String name;
    private String description;
}
