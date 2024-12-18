package com.example.lootgenerator.Models.Dto;

import com.example.lootgenerator.Models.Place;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class JewerlyDto {
    private String name;
    private String description;
    private List<String> type;
    private List<String> place;
}
