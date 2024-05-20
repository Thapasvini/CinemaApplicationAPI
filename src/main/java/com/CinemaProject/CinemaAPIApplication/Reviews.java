package com.CinemaProject.CinemaAPIApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="reviews")
public class Reviews
{
    @Id
    private ObjectId Id;
    private  String body;

    public Reviews(String body) {
        this.body = body;
    }
}
