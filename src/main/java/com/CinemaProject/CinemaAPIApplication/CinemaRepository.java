package com.CinemaProject.CinemaAPIApplication;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // to let the framework know that its repository
public interface CinemaRepository extends MongoRepository<Cinema, ObjectId>
{
    Optional<Cinema> findCinemaByImdbId(String imdbId);
    //to search movie by imdbId , as builtin method does not come with methods for searching with imdbId
    // we have to iimplement it ourselves
}

