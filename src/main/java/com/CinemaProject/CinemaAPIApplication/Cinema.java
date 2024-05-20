
package com.CinemaProject.CinemaAPIApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection="cinemas")
//each document in the movie collection

@Data // from lombok project it takes care of getter s and seeter and toString method
@AllArgsConstructor // annotation for constructor tht takes all field as parameters
//this annotation will let the framework know that this class sheet presents
@NoArgsConstructor // another constructor tht does not take any arguments

public class Cinema {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String realeaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference
    private List<Reviews> reviewIds;



}
